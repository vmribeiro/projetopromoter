/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.mgtAfiliado;

import apd3.negocios.dataAcess.DAOFactory;
import apd3.negocios.dataAcess.IEntidadeDAO;
import apd3.negocios.mgtAfiliado.entities.Entidade;

/**
 *
 * @author vmrib
 */
public class mgtAfiliacaoImpl implements mgtAfiliacao{
    
    private final IEntidadeDAO edao = (IEntidadeDAO) DAOFactory.getDAOByFullClassName("Entidade");;

    @Override
    public Entidade getDetalhe(int id) {
        Entidade entidade = edao.findById(id);
        return entidade;
    }

    @Override
    public boolean notificaAfiliado(int id, String msg) {
        boolean resp = EmailUtil.enviarEmail();
        return resp;
    }

    @Override
    public boolean update(Entidade e) {
        boolean resp = edao.update(e);
        return resp;
    }

    @Override
    public boolean insert(Entidade e) {
        boolean resp = edao.insert(e);
        return resp;
    }

    @Override
    public Entidade getDetalhe(String email) {
        Entidade entidade = edao.findByEmail(email);
        return entidade;
    }

    
    
}
