<%-- 
    Document   : modulos
    Created on : 1 de out. de 2026, 11:05:45
    Author     : aluno
--%>
<%@page import="model.Usuario"%>
<%@page import="model.TipoUsuario"%>
<%
    String nomeUsuarioSessao = "";
    if((session != null) && (session.getAttribute("usuario_sessao") != null)){
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuario_sessao");
        nomeUsuarioSessao = usuarioSessao.getId() + " " + usuarioSessao.getNome();
    }
    
    TipoUsuario tps = null;
    if((session != null) && (session.getAttribute("tipo_usuario_sessao") != null)){
        tps = (TipoUsuario) session.getAttribute("tipo_usuario_sessao");
    }
%>


<h1>Menu</h1>
<menu>
    <li><a href="/sgcmaq3037185/home/app/menu.jsp">Home</a></li>
    <%if ((tps != null) && (tps.getModuloAdministrativo().equals("S"))) {%>
    <li><a href="/sgcmaq3037185/home/app/adm/usuario.jsp">Usuários</a></li>
    <li><a href="/sgcmaq3037185/home/app/adm/tipousuario.jsp">Tipos de Usuário</a></li>
    <% } %>
    <li><a href="/sgcmaq3037185/home?task=logout"><%= nomeUsuarioSessao%> -- Logout</a></li>
</menu>
