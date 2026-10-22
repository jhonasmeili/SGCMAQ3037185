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
        <%@include file="/home/app/modulos.jsp"%>
        <%
            ArrayList<Usuario> lista = new UsuarioDAO().getAll();    
        %>
        <h1>Usuários</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>TipoUsuarioId</th>
                <th>Nascimento</th>
                <th>Logadouro</th>
                <th>Numero</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>Estado</th>
                <th>UF</th>
                <th>CEP</th>
                <th></th>
                <th></th>
            </tr>
            
            <% for(Usuario us : lista) {%>
            <tr>
                <td><%=us.getId()%></td>
                <td><%=us.getNome()%></td>
                <td><%=us.getTipoUsuarioId()%></td>
                <td><%= us.getNascimento() != null ? us.getNascimento() : "-" %></td>
                <td><%=us.getLogadouro() != null ? us.getLogadouro() : "-" %></td>
                <td><%=us.getNumero() != null ? us.getNumero() : "-" %></td>
                <td><%=us.getBairro() != null ? us.getBairro() : "-" %></td>
                <td><%=us.getCidade() != null ? us.getCidade() : "-" %></td>
                <td><%=us.getEstado() != null ? us.getEstado() : "-" %></td>
                <td><%=us.getUf() != null ? us.getUf() : "-" %></td>
                <td><%=us.getCep() != null ? us.getCep() : "-" %></td>
                <td><a href="/sgcmaq3037185/home/app/adm/usuario_form.jsp?id=<%=us.getId()%>">Alterar</a></td>
                <td><a href="/sgcmaq3037185/home?task=usuario&action=delete&id=<%=us.getId()%>" onclick="return confirm('Deseja realmente excluir Usuário <%= us.getNome()%>, Id: <%=us.getId()%>?')">Excluir</a></td>
            </tr>
            <% } %>
        </table>
        <button onclick="window.location.href='/sgcmaq3037185/home/app/adm/usuario_form.jsp'">Adicionar</button>
    </body>
</html>
