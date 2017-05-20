<%-- 
    Document   : cadastro
    Created on : 20/05/2017, 14:40:08
    Author     : vmrib
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="css/materialize.min.css" type="text/css">
    <link rel="stylesheet" href="css/main.css" type="text/css">
</head>

<body>
    <section id="cadastro-section">
        <nav class="transparent" id="main-menu">
            <div class="nav-wrapper">
                <a href="#" class="brand-logo" id="logo-menu">Logo</a>
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <div class="col s10 offset-s1 m8 offset-m2" id="div-cadastro">
                <ul class="collapsible" data-collapsible="accordion" id="ul-form-cadastro">
                    <li>
                        <div class="collapsible-header active"><i class="material-icons">filter_drama</i>Cadastro</div>
                        <div class="collapsible-body" id="cadastro-form">
                            <div class="row">
                                <form class="col s12" onsubmit="return get_action(this);" id="form-cadastro" method="post">
                                    <div class="input-field col s12 m10 offset-m1 black-text">
                                        <input id="nome" name="nome" type="text" class="">
                                        <label for="nome" class="black-text">Nome completo</label>
                                    </div>

                                    <!--Endereco inicio-->
                                    <div id='enderecos' class="col s8 m6 offset-m1 black-text">
                                        
                                    </div>
                                    <a class="waves-effect waves-light btn col s8 m6 offset-s2 offset-m3" id="btnEndereco">Adicionar Endereço</a>
                                    
                                    <!--Endereco fim-->
                                    
                                    <!--Especialidade inicio-->
                                    <div class="input-field col s12 m10 offset-m1 black-text">
                                        <input id="especialidade" name="especialidade" type="text" class="">
                                        <label for="especialidade" class="black-text">Especialidade</label>
                                    </div>
                                    <!--Especialidade fim-->

                                    <div class="row">
                                        <div class="input-field col s12 m10 offset-m1 black-text">
                                            <textarea id="habilidades" name="habilidades" class="materialize-textarea" maxlength="2000"></textarea>
                                            <label for="habilidades" class="black-text">Habilidades</label>
                                        </div>
                                    </div>

                                    <!--Telefone inicio-->
                                    <div id='telefones' class="col s8 m6 offset-m1 black-text">
                                        
                                    </div>
                                    
                                    <a class="waves-effect waves-light btn col s8 m6 offset-s2 offset-m3" id="btnTelefone">Adicionar Telefone</a>
                                    <!--Telefone fim-->
                                    
                                    <div class="row"></div>
                                    
                                    <!--Telefone inicio-->
                                    <div id='especialidades' class="col s8 m6 offset-m1 black-text">
                                        
                                    </div>
                                    
                                    <a class="waves-effect waves-light btn col s8 m6 offset-s2 offset-m3" id="btnEspecialidade">Adicionar Especialidade</a>
                                    <!--Telefone fim-->
                                    
                                    <div class="row"></div>
                                    
                                    <!--Servico inicio-->
                                    <div id='servicos' class="col s8 m6 offset-m1 black-text">
                                        
                                    </div>
                                    
                                    <a class="waves-effect waves-light btn col s8 m6 offset-s2 offset-m3" id="btnServico">Adicionar Servico</a>
                                    <!--Servico fim-->
                                    
                                    <div class="row">
                                        <div class="input-field col s12 m10 offset-m1 black-text">
                                            <input id="email" type="email" class="">
                                            <label for="email" class="black-text">E-mail</label>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="input-field col s12 m10 offset-m1 black-text">
                                            <input id="senha1" type="password" class="">
                                            <label for="senha1" class="black-text">Senha</label>
                                        </div>
                                        <div class="row">
                                            <div class="input-field col s12 m10 offset-m1 black-text">
                                                <input id="senha2" type="password" class="">
                                                <label for="senha2" class="black-text">Digite a senha novamente</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col s12 m10 offset-m1 black-text">
                                            <input class="with-gap" name="tipoEntidade" type="radio" id="fisica" checked/>
                                            <label for="fisica" class="black-text">Pessoa Física</label>
                                        </div>
                                        <div class="col s12 m10 offset-m1 black-text">
                                            <input class="with-gap" name="tipoEntidade" type="radio" id="juridica" />
                                            <label for="juridica" class="black-text">Pessoa Jurídica</label>
                                        </div>
                                    </div>

                                    <!--Início pessoa física-->
                                    <div class="row">
                                        <div class="input-field col s12 m10 offset-m1 pf black-text">
                                            <input id="cpf" type="text" class="">
                                            <label for="cpf" class="black-text">CPF</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12 m10 offset-m1 pf black-text">
                                            <input id="dtaNasc" type="text" class="">
                                            <label for="dtaNasc" class="black-text">Data de Nascimento</label>
                                        </div>
                                    </div>
                                    <!--Fim pessoa física-->

                                    <!--Início pessoa jurídica-->
                                    <div class="row">
                                        <div class="input-field col s12 m10 offset-m1 not-display pj black-text">
                                            <input id="cnpj" type="text" class="">
                                            <label for="cnpj" class="black-text">CNPJ</label>
                                        </div>
                                    </div>
                                    <!--Fim pessoa jurídica-->
                                    <div class="row">
                                        <div class="col s10 center offset-m1">
                                            <button class="btn waves-effect waves-light center" type="submit" id="salvar" name="action">Cadastrar
                                                <i class="material-icons right">send</i>
                                            </button>
                                        </div>
                                    </div>

                                    <!--Início mensagens de erros-->
                                    <div class="row">
                                        <p class="red-text not-display col s10 offset-m1" id="error-name">Nome incompleto ou com caracteres não permitidos.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-rua">Rua incompleta</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-email">Email incompleto ou incorreto.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-phone">Telefone incompleto.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-pass">Senhas incompletas ou não coincidem.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-habilidades">Habilidades incompletas.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-cpf">Preencha o CPF.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-cnpj">Preencha o CNPJ.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-cep">CEP incompleto ou com caracteres não permitidos.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-city">Escolha um estado e uma cidade.</p>
                                        <p class="red-text not-display col s10 offset-m1" id="error-date">Preencha sua data de nascimento.</p>
                                    </div>
                                    <!--Fim mensagens de erros-->
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
    <script src="js/jquery.maskedinput.js"></script>
    <script src="js/materialize.min.js" type="text/javascript"></script>
    <script src="js/main.js" type="text/javascript"></script>
</body>

</html>
