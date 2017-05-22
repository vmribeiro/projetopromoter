<%-- 
    Document   : login
    Created on : 20/05/2017, 14:39:40
    Author     : Rabah Zeineddine ,Victor Moraes , Jessica Yumi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="css/materialize.min.css" type="text/css">
        <link rel="stylesheet" href="css/main.css" type="text/css">
    </head>

    <body>
    <section id="index-section">
            <nav class="transparent" id="main-menu">
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo" id="logo-menu">Logo</a>
                    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                    <c:choose>
                        <c:when test="${user!=null}">
                              <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/FrontControllerServlet?control=Acesso&action=logoff">Logout</a></li>
                
                    </ul>
                    <ul class="side-nav" id="mobile-demo">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/FrontControllerServlet?control=Acesso&action=logoff">Logout</a></li>
                    
                    </ul>
                        </c:when>
                        <c:otherwise>
                              <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="index.jsp">Home</a></li>
                                <li><a href="cadastro.jsp">Cadastro</a></li>
                        <li><a href="login.jsp">Login</a></li>
                    </ul>
                    <ul class="side-nav" id="mobile-demo">
                        <li><a href="index.jsp">Home</a></li>
                            <li><a href="cadastro.jsp">Cadastro</a></li>
                        <li><a href="login.jsp">Login</a></li>
                    </ul>
                        </c:otherwise>
                    </c:choose>
                    <div style="display: flex;justify-content: center;align-items: center;">
                        <p style="color:#fff;">${msg}</p>
                    </div>
                </div>
            </nav>
        <div style="height: 80%;display:flex;justify-content: center;align-items: center;">
            
        </div>
        </section>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/materialize.min.js" type="text/javascript"></script>
        <script src="js/main.js" type="text/javascript"></script>
    </body>

</html>
