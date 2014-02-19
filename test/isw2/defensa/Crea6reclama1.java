package isw2.defensa;

import isw2.domain.incidence.IIncidenceRepository;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea6reclama1 {

	public static void main(String[] args) {
		
		// En el navegador de t�cnico1, reclamar las incidencias #1 y #2
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		IIncidenceRepository ir = new IncidenceRepository(em);
		
		ir.asignIncidenceToTechnical("t�cnico1", 1);
		ir.asignIncidenceToTechnical("t�cnico1", 2);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
