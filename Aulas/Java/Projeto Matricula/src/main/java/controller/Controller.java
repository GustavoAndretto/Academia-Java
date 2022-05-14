package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import model.DAO;

@WebServlet(urlPatterns = {"/home", "/create", "/read", "/insert"})
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
        else if(action.equals("/insert")) {
            this.adicionarAluno(req, res);
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
}
