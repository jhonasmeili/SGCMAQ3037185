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
import model.*;
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
                case "tipousuario":
                    doGetTipoUsuario(req, resp);
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
                case "tipousuario":
                    doPostTipoUsuario(req, resp);
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
        int tipoUsuarioId =  Integer.parseInt(req.getParameter("tipo_usuario_id"));
        
        Usuario us = new Usuario(id);
        us.setNome(nome);
        if(senha.length() > 20){
            us.setSenhaHash(senha);
        } else {
            us.setSenha(senha);
        }
        us.setTipoUsuarioId(tipoUsuarioId);
        
        UsuarioDAO dao = new UsuarioDAO();
        
        if(action.equals("new")) dao.insert(us);
        if(action.equals("update")) dao.update(us);
        
        req.getRequestDispatcher("/home/app/adm/usuario.jsp").forward(req, resp);
    }
    
    private void doGetTipoUsuario(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String action = req.getParameter("action");
        
        if((action != null) && (action.equals("delete"))){
            int id = Integer.parseInt(req.getParameter("id"));
            TipoUsuario tp = new TipoUsuario(id);
            TipoUsuarioDAO dao = new TipoUsuarioDAO();
            
            dao.delete(tp);
        }
        
        req.getRequestDispatcher("/home/app/adm/tipousuario.jsp").forward(req, resp);
    }
    
    private void doPostTipoUsuario(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        String action = req.getParameter("action"); // new  || update
        
        int id = Integer.parseInt(req.getParameter("id"));
        String adm = req.getParameter("adm");
        if(adm == null) adm = "N";
        String agd = req.getParameter("agd");
        if(agd == null) agd = "N";
        String atd = req.getParameter("atd");
        if(atd == null) atd = "N";
        
        TipoUsuario tp = new TipoUsuario(id);
        tp.setModuloAdministrativo(adm);
        tp.setModuloAgendamento(agd);
        tp.setModuloAtendimento(atd);
        TipoUsuarioDAO dao = new TipoUsuarioDAO();
        
        if(action.equals("new")) dao.insert(tp);
        if(action.equals("update")) dao.update(tp);
        
        req.getRequestDispatcher("/home/app/adm/tipousuario.jsp").forward(req, resp);
    }
    
}
