/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.dataAcess;

import apd3.negocios.mgtAfiliado.entities.Papel;
import apd3.negocios.mgtAfiliado.entities.Promoter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vmrib
 */
class PapelDAO implements IPapelDAO{

    @Override
    public Papel findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Papel> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Papel update(Papel e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Papel e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Papel insert(Papel e) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        try{
        em.getTransaction().begin();
        em.persist(e);
        em.flush();
        em.refresh(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return e;
        }catch(Exception ex){
            System.out.println("Erro na insercao do papel : "+ex);
            return null;
        }
    }

  

    
}
