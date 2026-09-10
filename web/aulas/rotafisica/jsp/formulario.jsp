<%-- 
    Document   : formulario
    Created on : 10 de set. de 2026, 09:16:10
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulário JSP</h1>
        <form action="/sgcmaq3037185/aulas/rotalogica/jsp/servletpost" method="post">
            <label for="campoA">CampoA</label>
            <input type="number" id="campoA" name="campoA" required="">
            <br><br>
            
            <label for="opcaoA">OpçãoA</label>
            <input type="checkbox" id="opcaoA" name="opcaoA" value="S">
            <br><br>
            
            <label for="opcaoB">OpçãoB</label>
            <input type="checkbox" id="opcaoB" name="opcaoB" value="S">
            <br><br>
            
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
