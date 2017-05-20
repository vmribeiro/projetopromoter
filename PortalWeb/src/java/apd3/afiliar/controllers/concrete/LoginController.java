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
import apd3.negocios.mgtLoggar.mgtLoggar;
import apd3.negocios.mgtLoggar.mgtLoggarImpl;

/**
 *
 * @author vmrib
 */
public class LoginController extends AbstractController {

    @Override
    public void execute() {
        String email = this.getRequest().getParameter("email");
        String senha = this.getRequest().getParameter("password");
        
        mgtLoggar mgt = new mgtLoggarImpl();
        Entidade e = mgt.autentica(email, senha);
        
        if (e != null) {
            setResponse("user", "index.jsp", e);
        }else{
            //Criar página de erro
            setResponse("error", "error.jsp", "Senha ou email não corresponde.");
        }
    }
}
