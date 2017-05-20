/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.afiliar.controllers;

import apd3.negocios.mgtAfiliado.entities.Entidade;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Victor Ribeiro
 */
public abstract class AbstractController implements IController {

    private HttpServletRequest request;
    protected String returnPage;

    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }

    /**
     * Define a página de resposta
     * @param page 
     */
    public void setReturnPage(String page) {
        returnPage = page;
    }

    public String getReturnPage() {
        return returnPage;
    }

    /**
     * Retorna um objeto com as requisições HTTP
     * @return 
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * Inicializa a variável relacionada às requisições com as requisições passadas por parâmetro
     * @param request 
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    protected void setResponse(String sessionName, String returnPage, Object value){
        if (value instanceof Entidade) {
            this.setReturnPage(returnPage);
            this.getRequest().setAttribute(sessionName, (Entidade) value);
        }else{
            this.setReturnPage(returnPage);
            this.getRequest().setAttribute(sessionName, (String) value);
        }
    }

}
