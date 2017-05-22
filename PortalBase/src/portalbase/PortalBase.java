/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalbase;

import apd3.negocios.dataAcess.DAOFactory;
import apd3.negocios.dataAcess.IEntidadeDAO;
import apd3.negocios.dataAcess.IPapelDAO;
import apd3.negocios.mgtAfiliado.entities.Endereco;
import apd3.negocios.mgtAfiliado.entities.Entidade;
import apd3.negocios.mgtAfiliado.entities.PessoaFisica;
import apd3.negocios.mgtAfiliado.entities.Promoter;
import apd3.negocios.mgtAfiliado.entities.State;
import apd3.negocios.mgtAfiliado.entities.Telefone;

/**
 *
 * @author vmrib
 */
public class PortalBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IEntidadeDAO entidadeDAO = (IEntidadeDAO) DAOFactory.getDAOByFullClassName("Entidade");
        
//        Promoter promoter = new Promoter();
//        promoter.setObjetivo("Se fuder");
//        
//        if (promoter != null) {
//            System.out.println("Promoter id: " + promoter.getId());
//            Entidade e = new PessoaFisica();
//            e.setEmail("asd@asd.com");
//            e.setHabilidades("Comer cu");
//            e.setNome("Rabah Zeineddine");
//            e.setSenha("asd");
//            
//            State state = new State();
//            state.seTokenAndDate();
//            e.setState(state);
//            e.setPapel(promoter);
//            
//            Endereco endereco = new Endereco();
//            endereco.setCep("02348-050");
//            endereco.setCidade("Sao Paulo");
//            endereco.setEstado("SP");
//            endereco.setRua("Verona");
//            
//            e.addEndereco(endereco);
//            Telefone telefone = new Telefone();
//            
//            telefone.setDdd("(11)");
//            telefone.setNumero("94996-6817");
//            
//            e.addTelefone(telefone);
//            
//            e = entidadeDAO.insert(e);
//            if (e != null) {
//                System.out.println("Entidade id: " + e.getId());
//            }
//            
//        } else {
//            System.out.println("Erro");
//        }
        
        
        
        
        
    Entidade ent = entidadeDAO.findById(1);
    ent.getState().setState("Valid");
    entidadeDAO.update(ent);
        
    }
    
}
