package badhabits.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import badhabits.entity.Sleep;

public class RepositorySleep {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorySleep() {
		emf = Persistence.createEntityManagerFactory("badhabits");
		em = emf.createEntityManager();
	}
	
	public Sleep consultaPorId(int id){
		EntityManager em = emf.createEntityManager();
		try {
	        em.getTransaction().begin();
	        Sleep Sleep = em.find(Sleep.class, id);
	        em.getTransaction().commit();
	        return Sleep;
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
}
