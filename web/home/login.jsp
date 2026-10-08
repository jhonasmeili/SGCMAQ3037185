<%-- 
    Document   : login
    Created on : 17 de set. de 2026, 08:46:57
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <% if (request.getAttribute("msg") != null){ %>
        <script>
            alert(" <%= (String) request.getAttribute("msg") %>");
        </script>
        <% } %>
        <%
            String id = "";
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("id")){
                        id = cookie.getValue();
                    }
                }
            }
        %>
        <form action="/sgcmaq3037185/home?task=login" method="post">
            <h1>Login</h1>
            <label for="id">Id:</label>
            <input type="number" id="id" name="id" value="<%= id %>" required> <br/>
            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" value="" required> <br/>
        
            <input type="submit" value="Login">
        </form>
    </body>
</html>
