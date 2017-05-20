/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.afiliar.controllers;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe que indica uma interface relacionada ao padrão controller.
 * @author Victor Ribeiro
 */
public interface IController {

    /**
     * Executa uma ação de acordo com a necessidade.
     */
    public void execute(String action);

    /**
     * Inicializa a(s) variável(is) de um controller.
     * @param request 
     */
    public void init(HttpServletRequest request);

    /**
     * Retorna uma String com a página de resposta que será usada para exibir os resultados.
     * @return 
     */
    public String getReturnPage();
}
