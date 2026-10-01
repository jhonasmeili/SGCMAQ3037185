<%-- 
    Document   : modulos
    Created on : 1 de out. de 2026, 11:05:45
    Author     : aluno
--%>
<%@page import="model.Usuario"%>
<%
    String nomeUsuarioSessao = "";
    if((session != null) && (session.getAttribute("usuario_sessao") != null)){
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuario_sessao");
        nomeUsuarioSessao = usuarioSessao.getId() + " " + usuarioSessao.getNome();
    }
%>


<h1>Menu</h1>
<menu>
    <li><a href="/sgcmaq3037185/home?task=logout"><%= nomeUsuarioSessao%> -- Logout</a></li>
</menu>
