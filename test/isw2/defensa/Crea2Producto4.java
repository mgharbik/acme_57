package isw2.defensa;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.procedure.Proceduree;
import isw2.domain.product.IProduct;
import isw2.domain.product.IProductRepository;
import isw2.domain.product.Product;
import isw2.infrastructure.persistence.jpa.ProcedureRepository;
import isw2.infrastructure.persistence.jpa.ProductRepository;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea2Producto4 {
public static void main(String[] args) {
		
	// Anadir el producto -Monitor 24in- con los procedimientos de mantenimiento M1, M2, M3 y M4.
		
		Set<IProcedure> lpd = new HashSet<IProcedure>();	
		IProcedure M1 = new Proceduree("M1", "M1");
		IProcedure M2 = new Proceduree("M2", "M2");
		IProcedure M3 = new Proceduree("M3", "M3");
		lpd.add(M1);
		lpd.add(M2);
		lpd.add(M3);
		
		//Store Product
		IProduct p = new Product("Monitor 24in", "Monitor 24in");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		IProductRepository pr = new ProductRepository(em);
		IProcedureRepository pdr = new ProcedureRepository(em);
		
		pdr.storeProcedure(M1);
		pdr.storeProcedure(M2);
		pdr.storeProcedure(M3);
		
		pr.storeProduct(p);
		
		pr.assignProcedure(p, M1);
		pr.assignProcedure(p, M2);
		pr.assignProcedure(p, M3);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
