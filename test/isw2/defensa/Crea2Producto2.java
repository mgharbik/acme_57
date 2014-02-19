package isw2.defensa;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.procedure.Proceduree;
import isw2.domain.product.IProduct;
import isw2.domain.product.IProductRepository;
import isw2.domain.product.Product;
import isw2.infrastructure.persistence.jpa.ProcedureRepository;
import isw2.infrastructure.persistence.jpa.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea2Producto2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Anadir el producto -Pen drive 16GB- con el procedimiento de mantenimiento PD1.
			
		IProcedure PD1 = new Proceduree("PD1", "PD1");
		
		//Store Product
		IProduct p = new Product("Pen drive 16GB", "Pen drive 16GB");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		IProductRepository pr = new ProductRepository(em);
		IProcedureRepository dr = new ProcedureRepository(em);
	
		pr.storeProduct(p);
		dr.storeProcedure(PD1);
		
		pr.assignProcedure(p, PD1);
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}

}
