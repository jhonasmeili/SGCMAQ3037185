<%-- 
    Document   : usuario_form
    Created on : 17 de set. de 2026, 09:24:56
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
<%@page import="model.UsuarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Usuário</title>
    </head>
    <body>
        <%String action = "new";
        Usuario us = null;
        String id = request.getParameter("id");
        if(id != null){
            us = new UsuarioDAO().getUnique(Integer.parseInt(id));
            
            if(us != null){
                action = "update";
            }
        }
        %>
        <h1>Cadastro Usuário</h1>
        <form action="/sgcmaq3037185/home?task=usuario&action=<%=action%>" method="post">
            <label for="id">Id:</label>
            <input type="number" id="id" name="id" value="<%= us != null ? us.getId(): ""%>" required <%= us != null ? "readonly" : ""%>> <br/>
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= us != null ? us.getNome(): ""%>"> <br/>
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" value="<%= us != null ? us.getSenha(): ""%>" required <%= us != null ? "readonly" : ""%>> <br/>
            
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
