/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package aulas.rotalogica.jsp;

import aulas.rotalogica.servlet.getpost.DadosFormulario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
@WebServlet(name = "ServletPost", urlPatterns = {"/aulas/rotalogica/jsp/servletpost"})
public class ServletPost extends HttpServlet {
    
    private ArrayList<DadosFormulario> dados;
    
    @Override
    public void init() throws ServletException{
        super.init();
        dados = new ArrayList<>();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String campoA = request.getParameter("campoA");
        String opcaoA = request.getParameter("opcaoA");
        String opcaoB = request.getParameter("opcaoB");
        
        DadosFormulario df = new DadosFormulario();
        df.setCampoA(campoA);
        df.setOpcaoA(opcaoA);
        df.setOpcaoB(opcaoB);
        
        dados.add(df);
        
        String url = "/aulas/rotafisica/jsp/dados.jsp";
        
        request.setAttribute("lista", dados);
        
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException{
        processRequest(req, rep);
    }
    
    @Override
    public void destroy(){
        dados.clear();
        dados = null;
    }
}
