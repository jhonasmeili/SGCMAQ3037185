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
        <%@include file="/home/app/modulos.jsp"%>
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
            <input type="text" id="nome" name="nome" value="<%= (us != null)  && (us.getNome() != null) ? us.getNome(): ""%>"> <br/>
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" value="<%= us != null ? us.getSenha(): ""%>" required <%= us != null ? "readonly" : ""%>> <br/>
            <label for="tipo_usuario_id">Tipo de Usuário:</label>
            <input type="number" id="tipo_usuario_id" name="tipo_usuario_id" value="<%= us != null ? us.getTipoUsuarioId(): ""%>" required <%= us != null ? "readonly" : ""%>> <br/>
            <label for="nascimento">Nascimento:</label>
            <input type="date" id="nascimento" name="nascimento" value="<%= (us != null)  && (us.getNascimento()!= null) ? us.getNascimento(): ""%>"> <br/>
            <label for="logadouro">Logadouro:</label>
            <input type="text" id="logadouro" name="logadouro" value="<%= (us != null)  && (us.getLogadouro()!= null) ? us.getLogadouro(): ""%>"> <br/>
            <label for="numero">Numero:</label>
            <input type="text" id="numero" name="numero" value="<%= (us != null)  && (us.getNumero()!= null) ? us.getNumero(): ""%>"> <br/>
            <label for="bairro">Bairro:</label>
            <input type="text" id="bairro" name="bairro" value="<%= (us != null)  && (us.getBairro()!= null) ? us.getBairro(): ""%>"> <br/>
            <label for="cidade">Cidade;</label>
            <input type="text" id="cidade" name="cidade" value="<%= (us != null)  && (us.getCidade()!= null) ? us.getCidade(): ""%>"> <br/>
            <label for="estado">Estado;</label>
            <input type="text" id="estado" name="estado" value="<%= (us != null)  && (us.getEstado()!= null) ? us.getEstado(): ""%>"> <br/>
            <label for="uf">UF:</label>
            <input type="text" id="uf" name="uf" value="<%= (us != null)  && (us.getUf() != null) ? us.getUf(): ""%>"> <br/>
            <label for="cep">CEP:</label>
            <input type="text" id="cep" name="cep" value="<%= (us != null)  && (us.getCep()!= null) ? us.getCep(): ""%>"> <br/>
            
            
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
