/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.afiliar.controllers.concrete;

import apd3.afiliar.controllers.AbstractController;
import apd3.negocios.mgtAfiliado.entities.Endereco;
import apd3.negocios.mgtAfiliado.entities.Entidade;
import apd3.negocios.mgtAfiliado.entities.Especialidade;
import apd3.negocios.mgtAfiliado.entities.PessoaFisica;
import apd3.negocios.mgtAfiliado.entities.PessoaJuridica;
import apd3.negocios.mgtAfiliado.entities.Promoter;
import apd3.negocios.mgtAfiliado.entities.Servico;
import apd3.negocios.mgtAfiliado.entities.State;
import apd3.negocios.mgtAfiliado.entities.Telefone;
import apd3.negocios.mgtAfiliado.mgtAfiliacao;
import apd3.negocios.mgtAfiliado.mgtAfiliacaoImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author vmrib
 */
public class AfiliacaoController extends AbstractController {

    String resMessageType, resMessage, resPage;
    String nome, email, senha, habilidades, cpf, cnpj, dtaNasc, razaoSocial, confirmSenha, objetivo;// Implementar na página web
    List<Especialidade> especialidadesObj;
    List<Telefone> telefonesObj;
    List<Servico> servicosObj;
    List<Endereco> enderecosObj;

    @Override
    public void execute(String action) {
        switch (action) {
            case "inserir":
                inserir();
                break;
            case "atualizar":
                atualizar();
                break;
            case "getDetalhe":
                getDetalhe();
                break;

            case "validacao":
                validarConta();
                break;
        }
    }

    private void getDetalhe() {
        int id = Integer.parseInt(this.getRequest().getParameter("id"));
        mgtAfiliacao mgt = new mgtAfiliacaoImpl();
        Entidade e = mgt.getDetalheById(id);
        if (e != null) {
            setResponse("user", "index.jsp", e);
        } else {
            //Criar página de erro
            setResponse("error", "login.jsp", "Não foi possível encontrar o usuário de id = " + id);
        }
    }

    private void validarConta() {
        HttpServletRequest request = this.getRequest();
        mgtAfiliacao mgt = new mgtAfiliacaoImpl();
        String token = request.getParameter("token");
        String idStr = request.getParameter("id");

        Entidade ent = mgt.getDetalheById(Integer.parseInt(idStr));

        if (ent != null) {
            if(token.equals(ent.getState().getToken())){
                ent.getState().setState("Valid");
                ent = mgt.update(ent);
                if(ent != null ){
                setResponse("user", "/index.jsp", ent);
                }else{
                        setResponse("error", "/index.jsp", "Erro ao atualizar o estado da conta!");
                }
            }else{
                setResponse("error", "/validarConta.jsp", "Token invalido!");
            }
            
            
        } else {
            //Error
            setResponse("error","/index.jsp", "Id invalido!");

        }

    }

    private void inserir() {
        boolean resp;
        Entidade e = getRequestParams();

        mgtAfiliacao mgt = new mgtAfiliacaoImpl();

        Entidade aux = mgt.getDetalheByEmail(e.getEmail());
//        boolean resp = mgt.insert(e);

        if (aux == null) {

            if (e instanceof PessoaFisica) {
                aux = mgt.getDetalheByCPF(((PessoaFisica) e).getCpf());
                resMessage = "CPF já existe!";
            } else {
                aux = mgt.getDetalheByCNPJ(((PessoaJuridica) e).getCnpj());
                resMessage = "CNPJ já existe!";

            }
            if (aux == null) {
                e = mgt.insert(e);

                if (e != null) {
                    resp = mgt.notificaAfiliado(e.getEmail(), "Validação da Conta",
                            "Para ativar a sua conta, <a href='http://192.168.0.17:8080/PortalWeb/FrontControllerServlet?control=Afiliacao&action=validacao&token=" + e.getState().getToken() + "&id=" + e.getId() + "'>Clique aqui</a>");
                } else {
                    resp = false;
                }

                if (resp) {
                    setResponse("msg", "/index.jsp", "Cadastrado com sucesso! Um email de confirmação foi enviado. Verifique seu email.");
                } else {
                    setResponse("error", "/cadastro.jsp", "Falha no envio de email para confirmação. Favor clicar no botão 'reenviar email'.");
                }

            } else {
                setResponse("error", "/cadastro.jsp", resMessage);
            }
        } else {
            setResponse("error", "/cadastro.jsp", "Email já existe!.");
        }
    }

    private void atualizar() {
//        Entidade e = getRequestParams();
//
//        mgtAfiliacao mgt = new mgtAfiliacaoImpl();
//        boolean resp = mgt.update(e);
//        if (resp) {
//            setResponse("msg", "index.jsp", "Atualizado com sucesso!");
//        } else {
//            setResponse("error", "cadastro.jsp", "Falha na atualização do perfil do usuário.");
//        }
    }

    private Entidade getRequestParams() {
        nome = this.getRequest().getParameter("nome");
        email = this.getRequest().getParameter("email");
        senha = this.getRequest().getParameter("senha");
        confirmSenha = this.getRequest().getParameter("confirmSenha");
        habilidades = this.getRequest().getParameter("habilidades");
        cpf = this.getRequest().getParameter("cpf");
        cnpj = this.getRequest().getParameter("cnpj");
        razaoSocial = this.getRequest().getParameter("razaoSocial");
        dtaNasc = this.getRequest().getParameter("dtaNasc");
        objetivo = this.getRequest().getParameter("objetivo");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fmtDtaNasc = new Date();
        try {
            fmtDtaNasc = sdf.parse(dtaNasc);
        } catch (ParseException ex) {
            Logger.getLogger(AfiliacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Definir para cada campo adicionado na web um objeto no array correspondente
        especialidadesObj = new ArrayList();
        //Javascript deve incrementar um contador para enviar essas quantidades via url
        //Se tiver por exemplo um campo de nome "especialidade1", outro "especialidade2", etc,
        //passa-se pela url a qtdEspecialidades

        int qtdEspecialidades = Integer.parseInt(this.getRequest().getParameter("qtdEspecialidades"));
        for (int i = 0; i < qtdEspecialidades; i++) {
            Especialidade esp = new Especialidade();
            esp.setAreaEspecialidade(this.getRequest().getParameter("especialidade" + (i + 1)));
            especialidadesObj.add(esp);
        }

        telefonesObj = new ArrayList();
        //Se tiver por exemplo um campo de nome "telefone1", outro "telefone2", etc,
        //passa-se pela url a qtdTelefones

        int qtdTelefones = Integer.parseInt(this.getRequest().getParameter("qtdTelefones"));
        for (int i = 0; i < qtdTelefones; i++) {
            Telefone telefone = new Telefone();
            String telefoneCompleto = this.getRequest().getParameter("telefone" + (i + 1));
            telefone.setDdd(telefoneCompleto.split(" ")[0]); //Na máscara jquery do telefone foi colocado um espaço
            telefone.setNumero(telefoneCompleto.split(" ")[1]);
            telefonesObj.add(telefone);
        }

        enderecosObj = new ArrayList();

        int qtdEnderecos = Integer.parseInt(this.getRequest().getParameter("qtdEnderecos"));
        for (int i = 0; i < qtdEnderecos; i++) {
            Endereco end = new Endereco();
            end.setCep(this.getRequest().getParameter("cep" + (i + 1)));
            end.setCidade(this.getRequest().getParameter("cidade" + (i + 1)));
            end.setEstado(this.getRequest().getParameter("estado" + (i + 1)));
            end.setRua(this.getRequest().getParameter("rua" + (i + 1)));
            enderecosObj.add(end);
        }

        servicosObj = new ArrayList();

        int qtdServicos = Integer.parseInt(this.getRequest().getParameter("qtdServicos"));
        for (int i = 0; i < qtdServicos; i++) {
            Servico servico = new Servico();
            servico.setDescricao(this.getRequest().getParameter("descricaoServico" + (i + 1)));
            servico.setNome(this.getRequest().getParameter("nomeServico" + (i + 1)));
            servicosObj.add(servico);
        }

        Promoter promoter = new Promoter();
        promoter.setEspecialidades(especialidadesObj);
        promoter.setObjetivo(objetivo);
        promoter.setServicos(servicosObj);

        Entidade e;
        if (cnpj.equals("") || cnpj == null) {
            e = new PessoaFisica();
        } else {
            e = new PessoaJuridica();
        }
        e.setEmail(email);
        e.setNome(nome);
        e.setSenha(senha);
        e.setHabilidades(habilidades);
        e.setEnderecos(enderecosObj);
        e.setTelefones(telefonesObj);

        State state = new State();
        state.seTokenAndDate();
        e.setState(state);
        e.setPapel(promoter);

//
        if (e instanceof PessoaFisica) {
            ((PessoaFisica) e).setCpf(cpf);
            ((PessoaFisica) e).setDtaNasc(fmtDtaNasc);
        } else if (e instanceof PessoaJuridica) {
            ((PessoaJuridica) e).setCnpj(cnpj);
            ((PessoaJuridica) e).setRazaoSocial(razaoSocial);
        }
        return e;
    }

}
