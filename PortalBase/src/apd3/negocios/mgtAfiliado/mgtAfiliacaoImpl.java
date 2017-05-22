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
 * @author Rabah Zeineddine, Victor Moraes , Jessica Yumi
 */
public class mgtAfiliacaoImpl implements mgtAfiliacao{
    
    private final IEntidadeDAO edao = (IEntidadeDAO) DAOFactory.getDAOByFullClassName("Entidade");;

    @Override
    public Entidade getDetalheById(int id) {
        Entidade entidade = edao.findById(id);
        return entidade;
    }

    @Override
    public boolean notificaAfiliado(String email,String subject, String msg) {
        boolean resp = EmailUtil.sendEmail(email, subject, msg);
        return resp;
    }

    @Override
    public Entidade update(Entidade e) {
         return edao.update(e);
    }

    @Override
    public Entidade insert(Entidade e) {
        e = edao.insert(e);
        return e;
    }

    @Override
    public Entidade getDetalheByEmail(String email) {
        Entidade entidade = edao.findByEmail(email);
        return entidade;
    }

    @Override
    public Entidade getDetalheByCPF(String CPF) {
        Entidade entidade = edao.findByCPF(CPF);
        return entidade;
    }

    @Override
    public Entidade getDetalheByCNPJ(String cnpj) {
        Entidade entidade = edao.findByCNPJ(cnpj);
        return entidade;
    }

    
    
    
}
