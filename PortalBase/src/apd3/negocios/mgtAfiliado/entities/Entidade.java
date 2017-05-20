/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtAfiliado.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vmrib
 */
public abstract class Entidade implements Serializable {

    protected String nome;
    protected String email;
    protected String senha;
    protected String habilidades;
    protected State status;
    
    protected Papel papel;
    
    //Dinamizar essas coisas na parte web
    protected List<Endereco> enderecos;
    protected List<Telefone> telefones;

    public Entidade(Papel papel) {
        this.papel = papel;
        this.status = new StateNaoValidado();
        this.enderecos = new ArrayList();
        this.telefones = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public boolean getStatus() {
        return status.getValidado();
    }

    public Papel getPapel() {
        return papel;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
    
    public void addEndereco(Endereco e){
        this.enderecos.add(e);
    }
    
    public void addTelefone(Telefone t){
        this.telefones.add(t);
    }
    
    public void removeEndereco(Endereco e){
        this.enderecos.remove(e);
    }
    
    public void removeTelefone(Telefone t){
        this.telefones.remove(t);
    }
    
    /**
     * Valida o status 
     * @return 
     */
    public void validarEntidade() {
        this.status = new StateValidado();
    }
}
