package badhabits.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import badhabits.entity.Lamp;

public class RepositoryLamp {
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositoryLamp() {
		emf = Persistence.createEntityManagerFactory("badhabits");
		em = emf.createEntityManager();
	}
	
	public Lamp consultaPorId(int id){
		EntityManager em = emf.createEntityManager();
		try {
	        em.getTransaction().begin();
	        Lamp lamp = em.find(Lamp.class, id);
	        em.getTransaction().commit();
	        return lamp;
	    } catch (Exception e) {
	    	if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        throw new RuntimeException("Erro ao buscar a lâmpada por id", e);
	    } finally {
	        if (em.isOpen()) {
	            em.close();
	        }
	    }
	}
	
	@SuppressWarnings("unchecked")
	public List<Lamp> listarTodos() throws Exception {
		try {
	        em.getTransaction().begin();
	        Query consulta = em.createQuery("select cliente from Clientes cliente");
	        List<Lamp> lamp = consulta.getResultList();
	        em.getTransaction().commit();
	        return lamp;
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        throw e;
	    } finally {
	        em.close();
	    }
	}
	
	public Integer maxId() throws Exception {
	    try {
	        em.getTransaction().begin();
	        Query consulta = em.createQuery("select MAX(id) from Lamp lamp");
	        Integer maxId = (Integer) consulta.getSingleResult();
	        em.getTransaction().commit();
	        return maxId;
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        throw e;
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}
	
}
