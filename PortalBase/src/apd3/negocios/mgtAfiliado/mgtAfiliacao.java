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
    public Entidade getDetalheByEmail(String email);
    public Entidade getDetalheByCPF(String CPF);
    public Entidade getDetalheById(int id);
    public Entidade getDetalheByCNPJ(String cnpj);
    public boolean notificaAfiliado(String email,String subject, String msg);
    public Entidade update(Entidade e);
    public Entidade insert(Entidade e);
}
