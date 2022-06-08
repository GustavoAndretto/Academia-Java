package com.estoque.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estoque.model.Produto;
import com.estoque.model.ProdutoDAO;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(urlPatterns = {"/produto"})
public class ProdutoREST extends HttpServlet {
    private static String responseType = "application/json;charset=UTF-8";
    private ProdutoDAO produtoDB;
    
    public ProdutoREST() {
        produtoDB = new ProdutoDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        JSONObject jsonRes = new JSONObject();

        try {
            out.print(new JSONArray(produtoDB.listarTodos()));
        } catch (Exception e) {
            jsonRes.put("success", false);
            jsonRes.put("error", e.toString());
            out.print(jsonRes.toString());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        JSONObject jsonRes = new JSONObject();

        try {
            JSONObject obj = new JSONObject(getBody(request));
            Produto prod =  converterJsonProduto(obj);
            Long genCodigo = produtoDB.inserir(prod);

            obj.put("codigo", genCodigo);
            jsonRes.put("success", true);
            jsonRes.put("object", obj);
            out.print(jsonRes.toString());
        } catch (Exception e) {
            jsonRes.put("success", false);
            jsonRes.put("error", e.toString());
            out.print(jsonRes.toString());
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        JSONObject jsonRes = new JSONObject();

        try {
            JSONObject obj = new JSONObject(getBody(request));  

            produtoDB.atualizar(converterJsonProduto(obj));
            jsonRes.put("success", true);
            jsonRes.put("object", obj);
            out.print(jsonRes.toString());
        } catch (Exception e) {
            jsonRes.put("success", false);
            jsonRes.put("error", e.toString());
            out.print(jsonRes.toString());
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType(responseType);
        PrintWriter out = response.getWriter();
        JSONObject jsonRes = new JSONObject();

        try {
            JSONObject obj = new JSONObject(getBody(request)); 

            produtoDB.remover(converterJsonProduto(obj));
            jsonRes.put("success", true);
            jsonRes.put("object", obj);
            out.print(jsonRes.toString());
            
        }
        catch (Exception e) {
            jsonRes.put("success", false);
            jsonRes.put("error", e.toString());
            out.print(jsonRes.toString());
        }
    }

    private static String getBody(HttpServletRequest request)  {
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
    
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            return "";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
    
                }
            }
        }
    
        body = stringBuilder.toString();
        return body;
    }

    private static Produto converterJsonProduto(JSONObject obj) {
        Produto prod = new Produto();

        if(obj.has("codigo")) {
            prod.setCodigo(obj.getLong("codigo"));
        }
        
        prod.setNome(obj.getString("nome"));
        prod.setCategoria(obj.getString("categoria"));       
        prod.setValor(obj.getFloat("valor"));
        prod.setQuantidade(obj.getInt("quantidade"));

        return prod;
    }
}