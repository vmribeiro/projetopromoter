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
public class Promoter extends Papel implements Serializable {
    
    private List<Especialidade> especialidades;
    private List<Servico> servicos;

    public Promoter() {
        this.especialidades = new ArrayList();
        this.servicos = new ArrayList();
    }

    public Promoter(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }
    
    public void addEspecialidade(Especialidade e){
        this.especialidades.add(e);
    }
    
    public void addServico(Servico e){
        this.servicos.add(e);
    }
    
    public void removeEspecialidade(Especialidade e){
        this.especialidades.remove(e);
    }
    
    public void removeServico(Servico e){
        this.servicos.remove(e);
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }    
}
