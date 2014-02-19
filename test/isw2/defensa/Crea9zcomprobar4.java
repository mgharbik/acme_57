package isw2.defensa;

import java.util.List;

import isw2.domain.incidence.IIncidence;
import isw2.domain.technical.ITechnicalRepository;
import isw2.infrastructure.persistence.jpa.TechnicalRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea9zcomprobar4 {

	public static void main(String[] args) {
		
		// Comprobar que el técnico SYSTEM ha resuelto la incidencia #5.
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		ITechnicalRepository tr = new TechnicalRepository(em);
		List<IIncidence> l = tr.incidencesResolvedBy("SYSTEM");
		
		if(l.size()==0)
			System.out.println("This tecnical didn't resolve anything");
		else{
			for(IIncidence i : l)
				System.out.println(i.toString());
		}
		
		
		em.close();
		emf.close();
	}
}
