<%-- 
    Document   : tipousuario_form
    Created on : 1 de out. de 2026, 08:38:15
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.TipoUsuario"%>
<%@page import="model.TipoUsuarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Tipo de Usuário</title>
    </head>
    <body>
        <%String action = "new";
        TipoUsuario tp = null;
        String id = request.getParameter("id");
        if(id != null){
            tp = new TipoUsuarioDAO().getUnique(Integer.parseInt(id));
            
            if(tp != null){
                action = "update";
            }
        }
        %>
        <h1>Cadastro de Tipo de Usuário</h1>
        <form action="/sgcmaq3037185/home?task=tipousuario&action=<%=action%>" method="post">
            <label for="id">Id:</label>
            <input type="number" id="id" name="id" value="<%= tp != null ? tp.getId(): ""%>" required <%= tp != null ? "readonly" : ""%>> <br/>
            <label for="adm">Modulo Administrativo:</label>
            <input type="checkbox" id="adm" name="adm" value="S" <%= (tp != null) && (tp.getModuloAdministrativo().equals("S")) ? "checked": ""%>> <br/>
            <label for="agd">Modulo Agendamento:</label>
            <input type="checkbox" id="agd" name="agd" value="S" <%= (tp != null) && (tp.getModuloAdministrativo().equals("S")) ? "checked": ""%>> <br/>
            <label for="atd">Modulo Agendamento:</label>
            <input type="checkbox" id="atd" name="atd" value="S" <%= (tp != null) && (tp.getModuloAdministrativo().equals("S")) ? "checked": ""%>> <br/>
            
            <input type="submit" value="Salvar">
        </form>
    </body> 
</html>
