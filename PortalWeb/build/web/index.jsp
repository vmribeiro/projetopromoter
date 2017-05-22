<%-- 
    Document   : index.jsp
    Created on : 20/05/2017, 14:38:33
    Author     : vmrib
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <c:choose>
        <c:when test="${error}">
            <p>${error}</p>
            <c:remove var="error" scope="session"></c:remove>
        </c:when>
        <c:when test="${msg}">
            <p>${msg}</p>
            <c:remove var="msg" scope="session"></c:remove>
        </c:when>
    </c:choose> 
            <c:choose>
                <c:when test="${user}">
                    <p>Bem Vindo ${user.nome}</p>
                </c:when>
                <c:otherwise>
                     <a href="login.jsp">Login</a>
    <a href="cadastro.jsp">Cadastro</a>
                </c:otherwise>
            </c:choose>        
   
</body>
</html>