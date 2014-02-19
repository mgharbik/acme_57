package isw2.defensa;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.IIncidenceRepository;
import isw2.domain.incidence.Incidence;
import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.product.IProduct;
import isw2.domain.product.IProductRepository;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;
import isw2.infrastructure.persistence.jpa.ProcedureRepository;
import isw2.infrastructure.persistence.jpa.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea4incidencia1 {

	public static void main(String[] args) {
		
		// Dar de alta una incidencia para una “Web Cam” 
		// usando el procedimiento WC1. (#1)
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		IProductRepository pr = new ProductRepository(em);
		IProcedureRepository pdr = new ProcedureRepository(em);
		IIncidenceRepository ir = new IncidenceRepository(em);
		
		IProduct p =pr.findProduct(1);
		IProcedure d = pdr.findProcedure(1);
		
		IIncidence i = new Incidence();
		i.setClientName("cliente");
		i.setClientEmail("email@email");
		i.setProcedure(d);
		i.setProduct(p);
				
		ir.storeIncidence(i);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
