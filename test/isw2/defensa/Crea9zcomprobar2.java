package isw2.defensa;

import java.util.List;

import isw2.domain.incidence.IIncidence;
import isw2.domain.technical.ITechnicalRepository;
import isw2.infrastructure.persistence.jpa.TechnicalRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea9zcomprobar2 {

	public static void main(String[] args) {
		
		// Comprobar que el t�cnico2 no ha resuelto ninguna incidencia.
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		ITechnicalRepository tr = new TechnicalRepository(em);
		List<IIncidence> l = tr.incidencesResolvedBy("t�cnico2");
		
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