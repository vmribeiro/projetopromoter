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
import apd3.negocios.mgtAfiliado.entities.Papel;
import apd3.negocios.mgtAfiliado.entities.PessoaFisica;
import apd3.negocios.mgtAfiliado.entities.PessoaJuridica;
import apd3.negocios.mgtAfiliado.entities.Promoter;
import apd3.negocios.mgtAfiliado.entities.Servico;
import apd3.negocios.mgtAfiliado.entities.Telefone;
import apd3.negocios.mgtAfiliado.mgtAfiliacao;
import apd3.negocios.mgtAfiliado.mgtAfiliacaoImpl;
import apd3.negocios.mgtAcesso.mtgAcessoImpl;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author vmrib
 */
public class AfiliacaoController extends AbstractController {

    String email, senha, habilidades, cpf, cnpj, dtaNasc;// Implementar na página web
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
        }
    }
    
    private void getDetalhe(){
        int id = Integer.parseInt(this.getRequest().getParameter("id"));
        mgtAfiliacao mgt = new mgtAfiliacaoImpl();
        Entidade e = mgt.getDetalhe(id);
        if (e != null) {
            setResponse("user", "index.jsp", e);
        } else {
            //Criar página de erro
            setResponse("error", "login.jsp", "Não foi possível encontrar o usuário de id = " + id);
        }
    }

    private void inserir() {
        Entidade e = getRequestParams();

        mgtAfiliacao mgt = new mgtAfiliacaoImpl();
        boolean resp = mgt.insert(e);

        if (resp) {
            e = mgt.getDetalhe(email);

            if (e != null) {
                resp = mgt.notificaAfiliado(mgt.getDetalhe(email).getId(), cpf);
            } else {
                resp = false;
            }

            if (resp) {
                setResponse("msg", "index.jsp", "Cadastrado com sucesso! Um email de confirmação foi enviado. Verifique seu email.");
            } else {
                setResponse("error", "cadastro.jsp", "Falha no envio de email para confirmação. Favor clicar no botão 'reenviar email'.");
            }
        } else {
            setResponse("error", "cadastro.jsp", "Falha no cadastro do usuário.");
        }
    }

    private void atualizar() {
        Entidade e = getRequestParams();

        mgtAfiliacao mgt = new mgtAfiliacaoImpl();
        boolean resp = mgt.update(e);
        if (resp) {
            setResponse("msg", "index.jsp", "Atualizado com sucesso!");
        } else {
            setResponse("error", "cadastro.jsp", "Falha na atualização do perfil do usuário.");
        }
    }

    private Entidade getRequestParams() {
        email = this.getRequest().getParameter("email");
        senha = this.getRequest().getParameter("senha");
        habilidades = this.getRequest().getParameter("habilidades");
        cpf = this.getRequest().getParameter("cpf");
        cnpj = this.getRequest().getParameter("cnpj");
        dtaNasc = this.getRequest().getParameter("dtaNasc");

        //Definir para cada campo adicionado na web um objeto no array correspondente
        especialidadesObj = new ArrayList();
        //Javascript deve incrementar um contador para enviar essas quantidades via url
        //Se tiver por exemplo um campo de nome "especialidade1", outro "especialidade2", etc,
        //passa-se pela url a qtdEspecialidades
        Especialidade esp = new Especialidade();
        for (int i = 1; i < Integer.parseInt(this.getRequest().getParameter("qtdEspecialidades")); i++) {
            if (i==0) {
                continue;
            }
            esp.setAreaEspecialidade(this.getRequest().getParameter("especialidade" + i));
            especialidadesObj.add(esp);
        }

        telefonesObj = new ArrayList();
        //Se tiver por exemplo um campo de nome "telefone1", outro "telefone2", etc,
        //passa-se pela url a qtdTelefones
        Telefone telefone = new Telefone();
        for (int i = 0; i < Integer.parseInt(this.getRequest().getParameter("qtdTelefones")); i++) {
            if (i==0) {
                continue;
            }
            String telefoneCompleto = this.getRequest().getParameter("telefone" + i);
            telefone.setDdd(telefoneCompleto.split(" ")[0]); //Na máscara jquery do telefone foi colocado um espaço
            telefone.setNumero(telefoneCompleto.split(" ")[2]);
            telefonesObj.add(telefone);
        }

        enderecosObj = new ArrayList();
        Endereco end = new Endereco();
        for (int i = 0; i < Integer.parseInt(this.getRequest().getParameter("qtdEnderecos")); i++) {
            if (i==0) {
                continue;
            }
            end.setCep(this.getRequest().getParameter("cep" + i));
            end.setCidade(this.getRequest().getParameter("cidade" + i));
            end.setEstado(this.getRequest().getParameter("estado" + i));
            end.setRua(this.getRequest().getParameter("rua" + i));
            enderecosObj.add(end);
        }

        Papel promoter = new Promoter(especialidadesObj);
        Entidade e;
        if (cnpj.equals("")) {
            e = new PessoaJuridica(promoter);
        } else {
            e = new PessoaFisica(promoter);
        }

        servicosObj = new ArrayList();
        Servico servico = new Servico((Promoter) promoter);
        Promoter p = (Promoter) e.getPapel();
        for (int i = 0; i < Integer.parseInt(this.getRequest().getParameter("qtdServicos")); i++) {
            if (i==0) {
                continue;
            }
            servico.setDescricao(this.getRequest().getParameter("descricaoServico" + i));
            servico.setNome(this.getRequest().getParameter("nomeServico" + i));
            servicosObj.add(servico);
        }

        p.setServicos(servicosObj);
        p.setEspecialidades(especialidadesObj);
        e.setPapel(p);
        e.setEnderecos(enderecosObj);
        e.setTelefones(telefonesObj);

        return e;
    }

}
