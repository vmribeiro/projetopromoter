/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.afiliar.controllers;

/**
 *
 * @author Victor Ribeiro
 */
public class ControllerFactory {

    public static final IController getControllerByClass(Class actionClass) {
        try {
            //Cria uma instância de uma classe que implemente a interface Controller a partir de uma classe
            IController controller = (IController) actionClass.newInstance();
            return (IController) actionClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final IController getControllerByFullClassName(String className) {
        try {
            //Cria uma string contendo o endereço da classe
            String name = "apd3.afiliar.controllers.concrete." + className + "Controller";
            //Faz o carregamento de uma classe de acordo com a string que foi passada por parâmetro contendo o endereço da classe
            Class actionClass = Class.forName(name);
            //Utiliza um método para retornar uma instância da classe que foi carregada com o Class.forName(name)
            return getControllerByClass(actionClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}