package isw2.defensa;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.ITechnicalRepository;
import isw2.infrastructure.persistence.jpa.ProcedureRepository;
import isw2.infrastructure.persistence.jpa.TechnicalRepository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea3asignar2 {

	public static void main(String[] args) {
		
		// Asignar a técnico3 la posibilidad de trabajar en cualquier 
		// procedimiento de mantenimiento.
			
		IProcedure M1;
		IProcedure M2;
		IProcedure M3;
		IProcedure PD1;
		
		
		ITechnical t2;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		ITechnicalRepository tr = new TechnicalRepository(em);
		IProcedureRepository pdr = new ProcedureRepository(em);
		
		M1= pdr.findProcedure(1);
		M2= pdr.findProcedure(2);
		M3= pdr.findProcedure(3);
		PD1= pdr.findProcedure(4);
		
		t2 = tr.findTechnical("técnico2");
		
		tr.assignProcedure(t2, M1);
		tr.assignProcedure(t2, M2);
		tr.assignProcedure(t2, M3);
		tr.assignProcedure(t2, PD1);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
