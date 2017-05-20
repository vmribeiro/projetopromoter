/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtLoggar;

import apd3.negocios.dataAcess.DAOFactory;
import apd3.negocios.dataAcess.IEntidadeDAO;
import apd3.negocios.mgtAfiliado.entities.Entidade;

/**
 *
 * @author vmrib
 */
public class mgtLoggarImpl implements mgtLoggar {

    @Override
    public Entidade autentica(String email, String senha) {
        IEntidadeDAO edao = (IEntidadeDAO) DAOFactory.getDAOByFullClassName("Entidade");
        Entidade e = edao.findByEmail(email);
        if (e != null && e.getSenha().equals(senha)) {
            return e;
        } else {
            return null;
        }
    }

}
