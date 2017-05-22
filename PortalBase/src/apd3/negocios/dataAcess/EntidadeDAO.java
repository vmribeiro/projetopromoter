/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apd3.negocios.dataAcess;

import apd3.negocios.mgtAfiliado.entities.Endereco;
import apd3.negocios.mgtAfiliado.entities.Entidade;
import apd3.negocios.mgtAfiliado.entities.Especialidade;
import apd3.negocios.mgtAfiliado.entities.Promoter;
import apd3.negocios.mgtAfiliado.entities.Servico;
import apd3.negocios.mgtAfiliado.entities.State;
import apd3.negocios.mgtAfiliado.entities.Telefone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author vmrib
 */
class EntidadeDAO implements IEntidadeDAO {

    @Override
    public Entidade findByEmail(String email) {
        Entidade e = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createNamedQuery("Entidade.findByEmail").setParameter("email", email);
        e = (query.getResultList().size() > 0) ? (Entidade) query.getResultList().get(0) : null;
        em.getTransaction().commit();
        return e;
    }

    @Override
    public Entidade findById(int id) {
        Entidade e = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        e = em.find(Entidade.class, id);
        em.getTransaction().commit();
        return e;
    }

    @Override
    public List<Entidade> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidade update(Entidade e) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            
            State st = e.getState();
            State ast = em.find(State.class, st.getId());
            ast.setState(st.getState());
            em.merge(e.getState());
            

//            em.merge(e);
            e = em.find(Entidade.class, e.getId());

            em.flush();
            em.getTransaction().commit();
            em.close();
            emf.close();
            return e;
        } catch (Exception ex) {
            System.out.println("Erro ao atualizar: "+ex);
            return null;
        }

    }

    @Override
    public boolean remove(Entidade e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidade insert(Entidade e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.persist(e.getState());
            em.refresh(e.getState());

            //Persist papel
            em.persist(e.getPapel());
            em.refresh(e.getPapel());

            if (e.getPapel() instanceof Promoter) {
                for (Especialidade esp : ((Promoter) e.getPapel()).getEspecialidades()) {
                    esp.setPromoter((Promoter) e.getPapel());
                    em.persist(esp);
                    em.refresh(esp);

                }
                for (Servico servico : ((Promoter) e.getPapel()).getServicos()) {
                    servico.setPromoter((Promoter) e.getPapel());
                    em.persist(servico);
                    em.refresh(servico);
                }

            }

            em.persist(e);
            em.refresh(e);

            for (Endereco end : e.getEnderecos()) {
                end.setEntidade(e);
                em.persist(end);
                em.refresh(end);
            }
//            
            for (Telefone tele : e.getTelefones()) {
                tele.setEntidade(e);
                em.persist(tele);
                em.refresh(tele);
            }
            em.flush();
            em.getTransaction().commit();
            em.close();
            emf.close();
            return e;
        } catch (Exception ex) {
            System.out.println("ERRO NA INSERCAO da entidade: " + ex);
            return null;
        }
    }

    @Override
    public Entidade findByCPF(String cpf) {
        Entidade e = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createNamedQuery("Entidade.findByCPF").setParameter("cpf", cpf);
        e = (query.getResultList().size() > 0) ? (Entidade) query.getResultList().get(0) : null;
        em.getTransaction().commit();
        return e;
    }

    @Override
    public Entidade findByCNPJ(String CNPJ) {
        Entidade e = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createNamedQuery("Entidade.findByCNPJ").setParameter("cnpj", CNPJ);
        e = (query.getResultList().size() > 0) ? (Entidade) query.getResultList().get(0) : null;
        em.getTransaction().commit();
        return e;
    }

}
