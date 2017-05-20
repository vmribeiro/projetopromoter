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
import apd3.negocios.mgtAcesso.mtgAcessoImpl;
import apd3.negocios.mgtAcesso.mgtAcesso;

/**
 *
 * @author vmrib
 */
public class AcessoController extends AbstractController {

    @Override
    public void execute(String action) {
        switch (action) {
            case "login":
                login();
                break;
            case "logoff":
                logoff();
                break;
        }
    }

    private void login() {
        String email = this.getRequest().getParameter("email");
        String senha = this.getRequest().getParameter("password");

        mgtAcesso mgt = new mtgAcessoImpl();
        Entidade e = mgt.autentica(email, senha);

        if (e != null) {
            setResponse("user", "index.jsp", e);
        } else {
            //Criar página de erro
            setResponse("error", "login.jsp", "Senha ou email não corresponde.");
        }
    }

    private void logoff() {
        this.getRequest().getSession().invalidate();
    }
}
