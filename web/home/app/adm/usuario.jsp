<%-- 
    Document   : usuario
    Created on : 17 de set. de 2026, 09:24:38
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="model.UsuarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
    </head>
    <body>
        <%
            ArrayList<Usuario> lista = new UsuarioDAO().getAll();
            
        %>
        <h1>Usuários</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th></th>
                <th></th>
            </tr>
            
            <% for(Usuario us : lista) {%>
            <tr>
                <td><%=us.getId()%></td>
                <td><%=us.getNome()%></td>
                <td><a href="/sgcmaq3037185/home/app/adm/usuario_form.jsp?id=<%=us.getId()%>">Alterar</td>
                <td>Excluir</td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
