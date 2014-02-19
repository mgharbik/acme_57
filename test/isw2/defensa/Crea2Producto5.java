package isw2.defensa;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
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

public class Crea2Producto5 {

	public static void main(String[] args) {
		
		// Anadir el producto “Monitor 32in” con los procedimientos 
		// de mantenimiento M1, M2 y M3. 
		// Fijese en que son los mismos procedimientos de mantenimiento 
		// que en el caso del producto anterior.
		
		Set<IProcedure> lpd = new HashSet<IProcedure>();	
		IProcedure M1;
		IProcedure M2;
		IProcedure M3;
		
		
		//Store Product
		IProduct p = new Product("Monitor 32in", "Monitor 32in");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		IProductRepository pr = new ProductRepository(em);
		IProcedureRepository pdr = new ProcedureRepository(em);
		
		M1= pdr.findProcedure(5);
		M2= pdr.findProcedure(6);
		M3= pdr.findProcedure(7);
		lpd.add(M1);
		lpd.add(M2);
		lpd.add(M3);
		p.setProcedures(lpd);
		
		pr.storeProduct(p);
		
		pr.assignProcedure(p, M1);
		pr.assignProcedure(p, M2);
		pr.assignProcedure(p, M3);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
