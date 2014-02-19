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

public class Crea2Producto3 {
	
	public static void main(String[] args) {
		
		// Anadir el producto “Pen drive 32GB” con el procedimiento de mantenimiento PD1.
		
		Set<IProcedure> lpd = new HashSet<IProcedure>();	
		IProcedure PD1;
		
		//Store Product
		IProduct p = new Product("Pen drive 32GB", "Pen drive 32GB");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		IProductRepository pr = new ProductRepository(em);
		IProcedureRepository pdr = new ProcedureRepository(em);
		
		PD1 = pdr.findProcedure(4);
		lpd.add(PD1);
		pr.storeProduct(p);
		pr.assignProcedure(p, PD1);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}
