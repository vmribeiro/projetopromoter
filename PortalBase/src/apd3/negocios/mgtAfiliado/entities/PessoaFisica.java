/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtAfiliado.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vmrib
 */
public class PessoaFisica extends Entidade implements Serializable {

    private String cpf;
    private Date dtaNasc;
    
    public PessoaFisica(Papel papel) {
        super(papel);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtaNasc() {
        return dtaNasc;
    }

    public void setDtaNasc(Date dtaNasc) {
        this.dtaNasc = dtaNasc;
    }
}
