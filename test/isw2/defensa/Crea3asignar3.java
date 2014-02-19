package isw2.defensa;

import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.procedure.Proceduree;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.ITechnicalRepository;
import isw2.infrastructure.persistence.jpa.ProcedureRepository;
import isw2.infrastructure.persistence.jpa.TechnicalRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea3asignar3 {

	public static void main(String[] args) {
		
		// Asignar a técnico1 la posibilidad de trabajar en los procedimientos 
		// de mantenimiento WC1, WC2 y WC3.
		
		List<Proceduree> lpd;	
		
		ITechnical t3;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		ITechnicalRepository tr = new TechnicalRepository(em);
		IProcedureRepository pdr = new ProcedureRepository(em);
		
		t3 = tr.findTechnical("técnico3");
		lpd = pdr.findAll();
		for(Proceduree p:lpd){
			tr.assignProcedure(t3, p);
		}
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
