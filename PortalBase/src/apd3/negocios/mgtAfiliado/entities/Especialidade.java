/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtAfiliado.entities;

/**
 *
 * @author vmrib
 */
public class Especialidade {
    private int Id;
    private String areaEspecialidade;

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
    
}
