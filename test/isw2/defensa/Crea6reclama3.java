package isw2.defensa;

import isw2.domain.incidence.IIncidenceRepository;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea6reclama3 {

	public static void main(String[] args) {
		
		// En el navegador de técnico3, reclamar la incidencia #2. 
		// El sistema debe de responder indicando que ya no esta disponible.
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		IIncidenceRepository ir = new IncidenceRepository(em);
		
		ir.asignIncidenceToTechnical("técnico3", 2);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
