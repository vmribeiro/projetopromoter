/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtAfiliado.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author vmrib
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
    @NamedQuery(name = "Entidade.findByEmail", query = "SELECT e FROM Entidade e WHERE email= :email")
    ,@NamedQuery(name = "Entidade.findByCPF", query = "SELECT e FROM Entidade e WHERE cpf= :cpf")
    ,@NamedQuery(name = "Entidade.findByCNPJ", query = "SELECT e from Entidade e WHERE cnpj= :cnpj")})
public class Entidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String nome;
    protected String email;
    protected String senha;
    protected String habilidades;

    
    @OneToOne
    protected State state;

    @OneToOne
    protected Papel papel;

    @Column(insertable = false, updatable = false)
    private String tipo;

    //Dinamizar essas coisas na parte web
    @Transient
    protected List<Endereco> enderecos;
    @Transient
    protected List<Telefone> telefones;

    public Entidade() {
        enderecos = new ArrayList<>();
        telefones = new ArrayList<>();

    }

//    public Entidade(Papel papel) {
//        this.papel = papel;
//        this.status = "invalid";
//        this.enderecos = new ArrayList();
//        this.telefones = new ArrayList();
//    }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
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

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public void addEndereco(Endereco e) {
        this.enderecos.add(e);
    }

    public void addTelefone(Telefone t) {
        this.telefones.add(t);
    }

    public void removeEndereco(Endereco e) {
        this.enderecos.remove(e);
    }

    public void removeTelefone(Telefone t) {
        this.telefones.remove(t);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

   

}
