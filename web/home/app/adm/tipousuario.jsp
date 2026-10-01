<%-- 
    Document   : tipousuario
    Created on : 1 de out. de 2026, 08:32:53
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.TipoUsuario" %>
<%@page import="model.TipoUsuarioDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo Usuários</title>
    </head>
    <body>
        
        <% 
            ArrayList<TipoUsuario> lista = new TipoUsuarioDAO().getAll();
        %>
        
        <h1>Tipo Usuários</h1>
        
        <table>
            
            <tr>
                <th>Id</th>
                <th>Módulo Administrativo</th>
                <th>Módulo Agendamento</th>
                <th>Módulo Atendimento</th>
                <th></th>
                <th></th>
            </tr>
            
            <% for( TipoUsuario tp : lista ) { %>
                <tr>
                    
                    <td><%= tp.getId() %></td>
                    <td><%= tp.getModuloAdministrativo()%></td>
                    <td><%= tp.getModuloAgendamento()%></td>
                    <td><%= tp.getModuloAtendimento()%></td>
                    
                    <td><a href="/sgcmaq3037185/home/app/adm/tipousuario_form.jsp?id=<%= tp.getId() %>">Alterar</a></td>
                    
                    <td><a href="/sgcmaq3037185/home?task=tipousuario&action=delete&id=<%= tp.getId()%>" onclick="return confirm('Deseja realmente excluir Tipo Usuário <%= tp.getId() %>')" >Excluir</a></td>
                    
                </tr>
            <% } %>
        
        </table>
            
        <button onclick="window.location.href='/sgcmaq3037185/home/app/adm/tipousuario_form.jsp'">Adicionar</button>
        
    </body>
</html>

