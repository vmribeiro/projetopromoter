/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtAfiliado.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author vmrib
 */
@Entity
public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private Promoter promoter;
    private String nome;
    private String descricao;

    public Servico(Promoter promoter) {
        this.promoter = promoter;
    }

    public Promoter getPromoter() {
        return promoter;
    }

    public void setPromoter(Promoter promoter) {
        this.promoter = promoter;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }    

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
