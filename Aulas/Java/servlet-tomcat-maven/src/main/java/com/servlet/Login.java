package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) 
    throws ServletException, IOException {
       
      res.setContentType("text/html");

      PrintWriter out = res.getWriter();

      String user = req.getParameter("username");
      String pass = req.getParameter("password");

      if(!user.equals("admin")) {
         out.println("<h1>Acesso não permitido para o usuário " + user +".</h1>");
         return;
      }

      Database db;

      try {
         db = new Database("jdbc:mysql://localhost/biblioteca?user=root&password=Atos@2022", "com.mysql.cj.jdbc.Driver");
      } catch (Exception e) {
         out.println("<h1>" + e.toString() + ".<h1>");
         return;
      }

      try {
         if(!db.validaUsuario(user, pass)){
            out.println("<h1>Senha incorreta.</h1>");
            return;
         }
      } catch(Exception e){
         out.println("<h1>" + e.toString() + ".<h1>");
         return;
      }

      out.print("<h1>Bem vindo " + user +".</h1>");
    }
}
