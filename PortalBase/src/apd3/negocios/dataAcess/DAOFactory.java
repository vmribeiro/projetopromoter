/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.dataAcess;

/**
 *
 * @author Rabah Zeineddine, Victor Moraes , Jessica Yumi
 */
public class DAOFactory {
    public static final IGenericDAO getDAOByClass(Class actionClass) {
        try {
            //Cria uma instância de uma classe que implemente a interface Controller a partir de uma classe
            IGenericDAO dao = (IGenericDAO) actionClass.newInstance();
            return (IGenericDAO) actionClass.newInstance();
        } catch (java.lang.InstantiationException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final IGenericDAO getDAOByFullClassName(String className) {
        try {
            //Cria uma string contendo o endereço da classe
            String name = "apd3.negocios.dataAcess." + className + "DAO";
            //Faz o carregamento de uma classe de acordo com a string que foi passada por parâmetro contendo o endereço da classe
            Class actionClass = Class.forName(name);
            //Utiliza um método para retornar uma instância da classe que foi carregada com o Class.forName(name)
            return getDAOByClass(actionClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
