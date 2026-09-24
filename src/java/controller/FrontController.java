/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAO;
import framework.log.ExceptionLogTrack;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String  task = req.getParameter("task");
        
        try{
            switch (task) {
                case "usuario": 
                    doGetUsuario(req, resp);
                    break;
                case null:
                default:
                    doDefault(req, resp);
            }
        } catch(Exception ex){
            ExceptionLogTrack.getInstance().addLog(ex);
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String  task = req.getParameter("task");
        
        try{
            switch (task) {
                case "usuario": 
                    doPostUsuario(req, resp);
                    break;
                case null:
                default:
                    doDefault(req, resp);
            }
        } catch(Exception ex){
            ExceptionLogTrack.getInstance().addLog(ex);
            throw new ServletException(ex);
        }
    }
    
    private void doDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("home/login.jsp").forward(req, resp);
        
    }
    
    private void doGetUsuario(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String action = req.getParameter("action");
        
        if((action != null) && (action.equals("delete"))){
            int id = Integer.parseInt(req.getParameter("id"));
            Usuario us = new Usuario(id);
            UsuarioDAO dao = new UsuarioDAO();
            
            dao.delete(us);
        }
        
        req.getRequestDispatcher("/home/app/adm/usuario.jsp").forward(req, resp);
    }
    
    private void doPostUsuario(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        String action = req.getParameter("action"); // new  || update
        
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        
        Usuario us = new Usuario(id);
        us.setNome(nome);
        us.setSenha(senha);
        
        UsuarioDAO dao = new UsuarioDAO();
        
        if(action.equals("new")) dao.insert(us);
        if(action.equals("update")) dao.update(us);
        
        req.getRequestDispatcher("/home/app/adm/usuario.jsp").forward(req, resp);
    }
    
}
