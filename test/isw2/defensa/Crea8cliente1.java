package isw2.defensa;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.IIncidenceRepository;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea8cliente1 {

	public static void main(String[] args) {
		
		// Visualizar como cliente la resolucion de la incidencia #1. 
		// Valorarla con un -5 
		// y colocar una nueva incidencia (#6) que haga referencia a la anterior.
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		IIncidenceRepository ir = new IncidenceRepository(em);
		
		IIncidence i = ir.findIncidence(1);
		System.out.println("incidencia 1 => descripcion: "+i.getReplayDescription());
		
		i.setReplayMark(-5);
		
		ir.storeIncidenceReferencedTo(1, "pregunta 2");
		
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
