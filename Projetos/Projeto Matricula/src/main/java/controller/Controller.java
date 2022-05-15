package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import model.DAO;

@WebServlet(urlPatterns = {"/home", "/create", "/read", "/insert", "/getListAlunos"})
public class Controller extends HttpServlet {

    private DAO dao;

    public Controller() {
        try {
            this.dao = new DAO(
                "jdbc:mysql://localhost/matricula?user=root&password=Atos@2022", 
                "com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        String action = req.getServletPath();

        if(action.equals("/home")){
            res.sendRedirect("index.html");
        }
        else if(action.equals("/create")) {
            res.sendRedirect("cadastro.html");
        }
        else if(action.equals("/read")) {
            res.sendRedirect("lista.html");
        }
        else if(action.equals("/insert")) {
            this.adicionarAluno(req, res);
        }
        else if(action.equals("/getListAlunos")) {
            this.listarAlunos(req, res);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

    }

    public void adicionarAluno(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        try {
            this.dao.inserirAluno(
                new Aluno(
                    Integer.parseInt(req.getParameter("matricula")), 
                    req.getParameter("nome"),
                    req.getParameter("email"),
                    req.getParameter("telefone")));
        } catch(Exception e) {
            System.out.println(e);
        }

        res.sendRedirect("index.html");
    }

    public void listarAlunos(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        //res.setContentType("text/html");

        List<Aluno> listaAlunos = new ArrayList<Aluno>();

        try {
            listaAlunos = this.dao.listarAlunos();
        } catch (Exception e) {
            System.out.println(e);
        }

        JSONObject json = new JSONObject();
        JSONArray jsonAlunos = new JSONArray();

        for(var aluno : listaAlunos) {
            JSONObject jsonAluno = new JSONObject();
            jsonAluno.put("matricula", aluno.getId());
            jsonAluno.put("nome", aluno.getNome());
            jsonAluno.put("email", aluno.getEmail());
            jsonAluno.put("telefone", aluno.getTelefone());

            jsonAlunos.put(jsonAluno);
        }

        json.put("alunos", jsonAlunos);

        PrintWriter out = res.getWriter();

        out.print(json.toString());
    }
}
