package isw2.infrastructure.persistence.repository;


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

public class TestProductRepository {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
        EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		IProcedureRepository pcdr = new ProcedureRepository(em);
		IProductRepository pr = new ProductRepository(em);
		
		IProduct p = pr.findProduct(1);
		IProcedure pcd2 = pcdr.findProcedure(2);
		
		pr.assignProcedure(p, pcd2);
		
		em.getTransaction().commit();
		em.close();
		
		emf.close();
		
		
//		// findAll
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		IProductRepository pr = new ProductRepository(em);
//		
//		List<Product> ps = pr.findAll();
//		System.out.println("Número de productos: "+ps.size());
//		System.out.println("1er product: "+ps.get(0).getID());
//		
//		em.getTransaction().commit();
//		em.close();
//		
//		em = emf.createEntityManager();
//	}
		

//		// findProduct
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//				
//		IProductRepository pr = new ProductRepository(em);
//				
//		Product p = pr.findProduct(1);
//		System.out.println("Nombre del producto: "+ p.getName());
//		System.out.println("Descripción del producto: "+ p.getDescription());
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
		
		
		
//		//storeProduct	
//		Product p2 = new Product();
//		p2.setName("Auriculares");
//		p2.setDescription("Auriculares de gran calidad");
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//				
//		IProductRepository pr = new ProductRepository(em);
//				
//		pr.storeProduct(p2);
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
//		
		
		
	 	//modifyProduct
//		Product p = new Product();
//		p.setID(2);
//		p.setName("Altavoces");
//		p.setDescription("Altavoces de gran calidad");
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//				
//		IProductRepository pr = new ProductRepository(em);
//		pr.modifyProduct(p);
//
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
//		
		
		
//		//removeProduct
//		Product p = new Product();
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		IProductRepository pr = new ProductRepository(em);
//		p = pr.findProduct(2);
//		pr.removeProduct(p);
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();

	}
	
}

