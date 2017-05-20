$(document).ready(function () {
    $('.collapsible').collapsible();
    $(".button-collapse").sideNav();
    $('select').material_select();

    $.getJSON("json/estados_cidades.json", function (data) {
        var items = [];
        var options = '<option value="">Escolha um estado</option>';
        $.each(data, function (key, val) {
            options += '<option value="' + val.nome + '">' + val.nome + '</option>';

        });
        //$("#estados").html(options);
        document.getElementById('estados').innerHTML = options;
        $('select').material_select();

        $("#estados").change(function () {

            var options_cidades = '';
            var str = "";

            $("#estados option:selected").each(function () {
                str += $(this).text();
            });

            $.each(data, function (key, val) {
                if (val.nome == str) {
                    $.each(val.cidades, function (key_city, val_city) {
                        options_cidades += '<option value="' + val_city + '">' + val_city + '</option>';
                    });
                }
            });
            $("#cidades").html(options_cidades);
            $('select').material_select();
        }).change();

    });

    $("#cep").mask("99.999-999");
    $("#rg").mask("99.999.999-9");
    $("#cnpj").mask("99999999-9");
    $("#cpf").mask("999.999.999-99");
    $('#telefone').mask("(99)9999?9-9999");
    $("#dtaNasc").mask("99/99/9999");

    //Validação com regex
    $.fn.validateRegex = function (type, value) {
        var regex;
        switch (type) {
            case "phone":
                //Celular ou telefone
                regex = /^(?:(?:\+|00)?(55)\s?)?(?:\(?([1-9][0-9])\)?\s?)?(?:((?:9\d|[2-9])\d{3})\-?(\d{4}))$/;
                break;

            case "email":
                regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                break;

            case "name":
                regex = /^([ \u00c0-\u01ffa-zA-Z'\-])+$/;
                break;

            case "password":
                //Minimum 8 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character.
                regex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
                break;

            case "cpf":
                regex = /^\d{3}\x2E\d{3}\x2E\d{3}\x2D\d{2}$/;
                break;

            case "date":
                // 00/00/0000
                regex = /^(((0[1-9]|[12]\d|3[01])\/(0[13578]|1[02])\/((19|[2-9]\d)\d{2}))|((0[1-9]|[12]\d|30)\/(0[13456789]|1[012])\/((19|[2-9]\d)\d{2}))|((0[1-9]|1\d|2[0-8])\/02\/((19|[2-9]\d)\d{2}))|(29\/02\/((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$/;
                break;

            case "cep":
                regex = /^[0-9]{2}.[0-9]{3}-[0-9]{3}$/;
                break;

        }

        return value.match(regex);
    };

    $.fn.validateValuesUser = function () {

        var error = true;

        if (!$(this).validateRegex("name", $("#nome").val())) {
            $("#error-name").removeClass("not-display");
            //alert("erro nome");
            error = false;
        } else {
            $("#error-name").addClass("not-display");
        }

        if ($("#rua").val() == "") {
            $("#error-rua").removeClass("not-display");
            //alert("erro rua");
            error = false;
        } else {
            $("#error-rua").addClass("not-display");
        }

        if ($("#senha1").val() != $("#senha2").val() || $("#senha1").val() == "" || $("#senha2").val() == "") {
            $("#error-pass").removeClass("not-display");
            //alert("erro senha");
            error = false;
        } else {
            $("#error-pass").addClass("not-display");
        }

        if ($("#habilidades").val() == "") {
            $("#error-habilidades").removeClass("not-display");
            //alert("erro habilidades");
            error = false;
        } else {
            $("#error-habilidades").addClass("not-display");
        }

        if (!$(this).validateRegex("email", $("#email").val())) {
            $("#error-email").removeClass("not-display");
            error = false;
        } else {
            $("#error-email").addClass("not-display");
        }

        if (!$(this).validateRegex("phone", $("#telefone").val())) {
            $("#error-phone").removeClass("not-display");
            error = false;
        } else {
            $("#error-phone").addClass("not-display");
        }

        if ($("#fisica").is(':checked')) {
            if (!$(this).validateRegex("cpf", $("#cpf").val())) {
                $("#error-cpf").removeClass("not-display");
                error = false;
                $("#error-cnpj").addClass("not-display");
            } else {
                $("#error-cpf").addClass("not-display");
                $("#error-cnpj").addClass("not-display");
            }

            if (!$(this).validateRegex("date", $("#dtaNasc").val())) {
                $("#error-date").removeClass("not-display");
                error = false;
                $("#error-cnpj").addClass("not-display");
            } else {
                $("#error-date").addClass("not-display");
                $("#error-cnpj").addClass("not-display");
            }
        } else {
            if ($("#cnpj").val() == "") {
                $("#error-cnpj").removeClass("not-display");
                $("#error-date").addClass("not-display");
                $("#error-cpf").addClass("not-display");
                error = false;
            } else {
                $("#error-cnpj").addClass("not-display");
                $("#error-date").addClass("not-display");
                $("#error-cpf").addClass("not-display");
            }
        }

        if (!$(this).validateRegex("cep", $("#cep").val())) {
            $("#error-cep").removeClass("not-display");
            error = false;
        } else {
            $("#error-cep").addClass("not-display");
        }

        if ($("#cidades").val() == undefined) {
            $("#error-city").removeClass("not-display");
            error = false;
        } else {
            $("#error-city").addClass("not-display");
        }
        if (!error) {
            //alert("here");
            $("#form-cadastro").submit(function () {
                return false;
            });
        } else {
            //alert("here");
            $("#form-cadastro").submit(function () {
                return true;
            });
        }
    };

    $("#salvar").click(function () {
        $(this).validateValuesUser();
    });

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
