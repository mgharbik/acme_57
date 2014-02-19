package isw2.defensa;

import isw2.domain.incidence.IIncidenceRepository;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea7resolver1 {

	public static void main(String[] args) {
		
		// En el navegador de técnico1, resolver la incidencia #1.
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		IIncidenceRepository ir = new IncidenceRepository(em);
		
		ir.storeReply(1, "resuelta1");
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
