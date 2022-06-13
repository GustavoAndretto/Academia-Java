package com.estoque.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estoque.model.Produto;
import com.estoque.model.ProdutoDAO;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(urlPatterns = { "/produto" })
public class ProdutoREST extends HttpServlet {
    private static String responseType = "application/json;charset=UTF-8";
    private ProdutoDAO produtoDB;

    public ProdutoREST() {
        produtoDB = new ProdutoDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {            
            sendSuccessMessage(response, produtoDB.listarTodos());
        } catch (Exception e) {
            sendErrorMessage(response, e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            Produto prod = makeProdutoFromRequestBody(request);
            Long codigo = produtoDB.inserir(prod);
            prod.setCodigo(codigo);
            sendSuccessMessage(response, prod);
        } catch (Exception e) {
            sendErrorMessage(response, e);
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            Produto produto = makeProdutoFromRequestBody(request);
            produtoDB.atualizar(produto);
            sendSuccessMessage(response, produto);
        } catch (Exception e) {
            sendErrorMessage(response, e);
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            Produto produto = makeProdutoFromRequestBody(request);
            produtoDB.remover(produto);
            sendSuccessMessage(response, produto);
        } catch (Exception e) {
            sendErrorMessage(response, e);
        }
    }

    private static void sendSuccessMessage(HttpServletResponse response, List<Produto> listProduto)
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        out.print(new JSONArray(listProduto));
    }

    private static void sendSuccessMessage(HttpServletResponse response, Produto produto)
    throws ServletException, IOException {
        response.setContentType(responseType);
        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        json.put("success", true);
        json.put("object", makeJsonFromProduto(produto));
        out.print(json.toString());
    }

    private static void sendErrorMessage(HttpServletResponse response, Exception e)
    throws ServletException, IOException {
        response.setContentType(responseType);
        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        json.put("success", false);
        json.put("error", e.toString());
        out.print(json.toString());
    }

    private static Produto makeProdutoFromRequestBody(HttpServletRequest request)
    throws ServletException, IOException {
        return new Gson().fromJson(request.getReader(), Produto.class);
    }

    private static JSONObject makeJsonFromProduto(Produto produto) {
        var obj = new JSONObject();
        obj.put("codigo", produto.getCodigo());
        obj.put("nome", produto.getNome());
        obj.put("categoria", produto.getCategoria());
        obj.put("quantidade", produto.getQuantidade());
        obj.put("valor", produto.getValor());

        return obj;
    }
}