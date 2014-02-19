package isw2.defensa;

import java.util.ArrayList;
import java.util.List;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.IIncidenceRepository;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea5naviga3 {

	public static void main(String[] args) {
		
		// En el navegador de técnico3, consultar la lista de incidencias. 
		// Deberan verse las incidencias #1, #2, #3 y #4.
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<IIncidence> l = new ArrayList<IIncidence>();
		
		IIncidenceRepository ir = new IncidenceRepository(em);
//		
		l = ir.findIncidencesOfTechnical("técnico3");
		for(IIncidence i : l)
			System.out.println(i.toString());
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
