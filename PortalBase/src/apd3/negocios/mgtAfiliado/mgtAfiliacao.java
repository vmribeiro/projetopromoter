/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtAfiliado;

import apd3.negocios.mgtAfiliado.entities.Entidade;

/**
 *
 * @author vmrib
 */
public interface mgtAfiliacao {
    
    //Verificar se os métodos conferem
    
    public Entidade getDetalhe(int id);
    public boolean notificaAfiliado(int id, String msg);
    public boolean update(Entidade e);
    public boolean insert(Entidade e);
}
