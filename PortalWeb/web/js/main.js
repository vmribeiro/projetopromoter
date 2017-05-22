var qtdEnderecos;
var qtdServicos;
var qtdEspecialidades;
var qtdTelefones;

$(document).ready(function () {

    qtdEnderecos = 0;
    qtdServicos = 0;
    qtdEspecialidades = 0;
    qtdTelefones = 0;

    $('.collapsible').collapsible();
    $(".button-collapse").sideNav();
    $('select').material_select();

    $("#rg").mask("99.999.999-9");
    
    $("#cnpj").mask("99.999.999/9999-99");
    $("#cpf").mask("999.999.999-99");
    $("#dtaNasc").mask("99/99/9999");
});

$('#fisica').click(function () {
    if ($(this).is(':checked')) {
        $(".pf").removeClass('not-display');
        $(".pj").addClass('not-display');
    }
});

$('#juridica').click(function () {
    if ($(this).is(':checked')) {
        $(".pj").removeClass('not-display');
        $(".pf").addClass('not-display');
    }
});

$("#btnEndereco").click(function () {
    qtdEnderecos++;
    $("#enderecos").append("    <div class='row>'<p class='col s12 m10 offset-m1 black-text'>Endereço " + qtdEnderecos + "</p></div>\n\
                                <div class='input-field col s12 m10 offset-m1 black-text'>\n\
                                    <input id='rua" + qtdEnderecos + "' name='rua" + qtdEnderecos + "' type='text' class=''>\n\
                                    <label for='rua" + qtdEnderecos + "' class='black-text'>Rua</label>\n\
                                </div>\n\
                                <div class='input-field col s12 m10 offset-m1 black-text'>\n\
                                        <input id='estado" + qtdEnderecos + "' name='estado" + qtdEnderecos + "' type='text' class=''>\n\
                                        <label for='estado" + qtdEnderecos + "' class='black-text'>Estado</label>\n\
                                 </div>\n\
                                <div class='input-field col s12 m10 offset-m1 black-text'>\n\
                                        <input id='cidade" + qtdEnderecos + "' name='cidade" + qtdEnderecos + "' type='text' class=''>\n\
                                        <label for='cidade" + qtdEnderecos + "' class='black-text'>Estado</label>\n\
                                 </div>\n\
                                \n\
                                <div class='input-field col s12 m10 offset-m1 black-text'>\n\
                                    <input id='cep" + qtdEnderecos + "' name='cep" + qtdEnderecos + "' type='text' class='cep'>\n\
                                    <label for='cep" + qtdEnderecos + "' class='black-text'>CEP</label>\n\
                                </div>");
    
    $(".cep").mask("99.999-999");
});

$("#btnTelefone").click(function () {
    qtdTelefones++;
    $("#telefones").append("<div class='row>'<p class='col s12 m10 offset-m1 black-text'>Telefone " + qtdTelefones + "</p></div>\n\
                            <div class='input-field col s12 m10 offset-m1 black-text'>\n\
                                <input id='telefone" + qtdTelefones + "' name='telefone" + qtdTelefones + "' type='text' class='telefone'>\n\
                                <label for='telefone" + qtdTelefones + "' class='black-text'>Telefone</label>\n\
                            </div>");   
    
    $('.telefone').mask("(99) 9999?9-9999");
});

$("#btnEspecialidade").click(function () {
    qtdEspecialidades++;
    $("#especialidades").append("<div class='row>'<p class='col s12 m10 offset-m1 black-text'>Especialidade " + qtdEspecialidades + "</p></div>\n\
                            <div class='input-field col s12 m10 offset-m1 black-text'>\n\
                                <input id='especialidade" + qtdEspecialidades + "' name='especialidade" + qtdEspecialidades + "' type='text' class=''>\n\
                                <label for='especialidade" + qtdEspecialidades + "' class='black-text'>Especialidade</label>\n\
                            </div>");   
    
});

$("#btnServico").click(function () {
    qtdServicos++;
    $("#servicos").append(" <div class='row>'<p class='col s12 m10 offset-m1 black-text'>Serviço " + qtdServicos + "</p></div>\n\
                            <div class='input-field col s12 m10 offset-m1 black-text'>\n\
                                <input id='nomeServico" + qtdServicos + "' name='nomeServico" + qtdServicos + "' type='text' class=''>\n\
                                <label for='nomeServico" + qtdServicos + "' class='black-text'>Nome do serviço</label>\n\
                            </div>\n\
                            <div class='input-field col s12 m10 offset-m1 black-text'>\n\
                                <input id='descricaoServico" + qtdServicos + "' name='descricaoServico" + qtdServicos + "' type='text' class=''>\n\
                                <label for='descricaoServico" + qtdServicos + "' class='black-text'>Descrição do servico</label>\n\
                            </div>    ");               
    
});

function get_action(form) {
        form.action = "FrontControllerServlet?control=Afiliacao&action=inserir&qtdEspecialidades="+qtdEspecialidades+"&qtdServicos="+
                qtdServicos+"&qtdTelefones="+qtdTelefones+"&qtdEnderecos="+qtdEnderecos;
        
}