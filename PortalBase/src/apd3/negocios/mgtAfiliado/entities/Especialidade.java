/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtAfiliado.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author vmrib
 */
@Entity
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String areaEspecialidade;
    
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false, updatable = false)
    private Promoter promoter;

    public Especialidade() {
    }

    
    
    public String getAreaEspecialidade() {
        return areaEspecialidade;
    }

    public void setAreaEspecialidade(String areaEspecialidade) {
        this.areaEspecialidade = areaEspecialidade;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Promoter getPromoter() {
        return promoter;
    }

    public void setPromoter(Promoter promoter) {
        this.promoter = promoter;
    }
    
    
    
}
