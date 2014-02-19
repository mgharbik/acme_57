package isw2.defensa;

import isw2.domain.incidence.IIncidenceRepository;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea9reclama1 {

	public static void main(String[] args) {
		
		// Entrar en el navegador del técnico1 y reclamar la incidencia #6.
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		IIncidenceRepository ir = new IncidenceRepository(em);
		
		ir.asignIncidenceToTechnical("técnico1", 6);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
