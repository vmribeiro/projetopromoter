/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.afiliar.controllers.concrete;

import apd3.afiliar.controllers.AbstractController;
import apd3.negocios.dataAcess.DAOFactory;
import apd3.negocios.dataAcess.IEntidadeDAO;
import apd3.negocios.mgtAfiliado.entities.Entidade;

/**
 *
 * @author vmrib
 */
public class AfiliacaoController extends AbstractController{

    @Override
    public void execute() {
        String email = this.getRequest().getParameter("email");
        String senha = this.getRequest().getParameter("password");
        
        //Autentica
//        IEntidadeDAO edao = (IEntidadeDAO) DAOFactory.getDAOByFullClassName("Entidade");
//        Entidade e = edao.findByEmail(email);
//        if (e != null) {
//            if (e.getSenha().equals(senha)) {
//                setResponse("user", "index.jsp", e);
//            }else{
//                setResponse("error", "error.jsp", "Senha ou email não corresponde.");
//            }
//        }else{
//            //Criar página de erro
//            setResponse("error", "error.jsp", "Senha ou email não corresponde.");
//        }
    }
    
}
