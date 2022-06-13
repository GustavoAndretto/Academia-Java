package com.coco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.coco.model.Produto;
import com.coco.model.ProdutoDAO;
import com.google.gson.Gson;

@WebServlet(urlPatterns = {"/produto"})
public class ProdutoServlet extends HttpServlet {
    private static String responseType = "application/json;charset=UTF-8";
    private ProdutoDAO produtoDAO;

    public ProdutoServlet() {
        produtoDAO = new ProdutoDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        
        try {
            out.print(new JSONArray(produtoDAO.listarTodos()));
        } catch (Exception e) {
            json.put("success", false);
            json.put("error", e.toString());
            out.print(json.toString());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
      
        try {
            Produto prod = new Gson().fromJson(request.getReader(), Produto.class);
            var codigo = produtoDAO.inserir(prod);

            JSONObject jsonProd = new JSONObject();
            jsonProd.put("codigo", codigo);
            jsonProd.put("nome", prod.getNome());
            jsonProd.put("categoria", prod.getCategoria());
            jsonProd.put("quantidade", prod.getQuantidade());
            jsonProd.put("valor", prod.getValor());

            json.put("success", true);
            json.put("object", jsonProd);

            out.print(json.toString());
        } catch (Exception e) {
            json.put("success", false);
            json.put("error", e.toString());
            out.print(json.toString());
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        
        try {
            Produto prod = new Gson().fromJson(request.getReader(), Produto.class);
            JSONObject jsonProd = new JSONObject();
            jsonProd.put("codigo", prod.getCodigo());
            jsonProd.put("nome", prod.getNome());
            jsonProd.put("categoria", prod.getCategoria());
            jsonProd.put("quantidade", prod.getQuantidade());
            jsonProd.put("valor", prod.getValor());

            produtoDAO.atualizar(prod);

            json.put("success", true);
            json.put("object", jsonProd);  
            out.print(json.toString());
        } catch (Exception e) {
            json.put("success", false);
            json.put("error", e.toString());
            out.print(json.toString());
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        
        try {
            Produto prod = new Gson().fromJson(request.getReader(), Produto.class);
            JSONObject jsonProd = new JSONObject();
            jsonProd.put("codigo", prod.getCodigo());
            jsonProd.put("nome", prod.getNome());
            jsonProd.put("categoria", prod.getCategoria());
            jsonProd.put("quantidade", prod.getQuantidade());
            jsonProd.put("valor", prod.getValor());

            produtoDAO.remover(prod);

            json.put("success", true);
            json.put("object", jsonProd);  
            out.print(json.toString());
        } catch (Exception e) {
            json.put("success", false);
            json.put("error", e.toString());
            out.print(json.toString());
        }
    }
}