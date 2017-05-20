<%-- 
    Document   : login
    Created on : 20/05/2017, 14:39:40
    Author     : vmrib
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="css/materialize.min.css" type="text/css">
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>

<body>
    <section id="login-section">
        <nav class="transparent" id="main-menu">
            <div class="nav-wrapper">
                <a href="#" class="brand-logo" id="logo-menu">Logo</a>
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="cadastro.jsp">Cadastro</a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="cadastro.jsp">Cadastro</a></li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <div class="col s10 offset-s1 m8 offset-m2">
                <ul class="collapsible" data-collapsible="accordion" id="ul-form-cadastro">
                    <li>
                        <div class="collapsible-header active"><i class="material-icons">send</i>Login</div>
                        <div class="collapsible-body" id="cadastro-form">
                            <div class="row">
                                <form class="col s12" method="post" action="FrontControllerServlet?control=Acesso">

                                    <div class="row">
                                        <div class="input-field col s12 m10 offset-m1 black-text">
                                            <input id="email" name="email" type="email" class="validate">
                                            <label for="email" class="black-text">E-mail</label>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="input-field col s12 m10 offset-m1 black-text">
                                            <input id="senha1" name="password" type="password" class="validate">
                                            <label for="senha1" class="black-text">Senha</label>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col s12 m4 offset-m1 left row">
                                            <button class="btn waves-effect waves-light center col s10" type="submit" name="action">
                                                Entrar
                                            </button>
                                        </div>
                                        <div class="col s12 m4 right row">
                                            <a class="waves-effect waves-light btn indigo darken-4  col s10" href="cadastro.html">Cadastre-se</a>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="js/materialize.min.js" type="text/javascript"></script>
    <script src="js/main.js" type="text/javascript"></script>
</body>

</html>
