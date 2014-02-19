package isw2.defensa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.procedure.Proceduree;
import isw2.domain.product.IProduct;
import isw2.domain.product.IProductRepository;
import isw2.domain.product.Product;
import isw2.infrastructure.persistence.jpa.ProcedureRepository;
import isw2.infrastructure.persistence.jpa.ProductRepository;

public class Crea2Producto1 {

	public static void main(String[] args) {
		
		// Anadir el producto “Web Cam” con los procedimientos de mantenimiento WC1, WC2 y WC3.
		
		Set<IProcedure> lpd = new HashSet<IProcedure>();
		
		IProcedure WC1 = new Proceduree("WC1", "WC1");
		IProcedure WC2 = new Proceduree("WC2", "WC2");
		IProcedure WC3 = new Proceduree("WC3", "WC3");
		
		lpd.add(WC1);
		lpd.add(WC2);
		lpd.add(WC3);
		
		//Store Product
		IProduct pwc = new Product("Web Cam", "Web Cam", lpd);
		
		Set<IProduct> lp = new HashSet<IProduct>();
		lp.add(pwc);
		WC1.setProducts(lp);
		WC2.setProducts(lp);
		WC3.setProducts(lp);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		IProductRepository pr = new ProductRepository(em);
		IProcedureRepository pdr = new ProcedureRepository(em);
		
		pdr.storeProcedure(WC1);
		pdr.storeProcedure(WC2);
		pdr.storeProcedure(WC3);
		
		pr.storeProduct(pwc);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
}
