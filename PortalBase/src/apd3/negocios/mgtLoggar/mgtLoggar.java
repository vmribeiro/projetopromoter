/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtLoggar;

import apd3.negocios.mgtAfiliado.entities.Entidade;

/**
 *
 * @author vmrib
 */
public interface mgtLoggar {
    public Entidade autentica(String email, String senha);
}
