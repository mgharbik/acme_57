package isw2.infrastructure.persistence.repository;

import java.util.List;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.procedure.Proceduree;
import isw2.domain.product.IProduct;
import isw2.domain.product.IProductRepository;
import isw2.domain.product.Product;
import isw2.infrastructure.persistence.jpa.ProcedureRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestProcedureRepository {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//assignProduct
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//        EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		IProcedureRepository pcdr = new ProcedureRepository(em);
//		IProductRepository pr = new ProductRepository(em);
//		
//		IProduct p = pr.findProduct(1);
//		IProcedure pcd2 = pcdr.findProcedure(2);
//		
//		pr.assignProcedure(p, pcd2);
//		
//		em.getTransaction().commit();
//		em.close();
//		
//		emf.close();
		
		
//		// findAll
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		IProcedureRepository pr = new ProcedureRepository(em);
//		
//		List<Proceduree> pcds = pr.findAll();
//		System.out.println("Número de procedimientos: "+pcds.size());
//		System.out.println("1er procedure: "+pcds.get(0).getID());
//		
//		em.getTransaction().commit();
//		em.close();
//		
//		em = emf.createEntityManager();
//	}
		

//		// findProcedure
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//				
//		IProcedureRepository pr = new ProcedureRepository(em);
//				
//		Proceduree pcd = pr.findProcedure(1);
//		System.out.println("Nombre del procedimiento: "+ pcd.getName());
//		System.out.println("Descripción del procedimiento: "+ pcd.getDescription());
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
		
		
		
//		//storeProcedure	
//		Proceduree pcd2 = new Proceduree();
//		pcd2.setName("Clavija");
//		pcd2.setDescription("Trata problemas derivados de la clavija");
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//				
//		IProcedureRepository pr = new ProcedureRepository(em);
//				
//		pr.storeProcedure(pcd2);
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
//		
//		
//	 	//modifyProcedure
//		Proceduree pcd = new Proceduree();
//		pcd.setID(1);
//		pcd.setName("Sonido");
//		pcd.setDescription("Trata problemas derivados del sonido");
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//				
//		IProcedureRepository pr = new ProcedureRepository(em);
//		pr.modifyProcedure(pcd);
//
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
		
		
		//removeProduct
        Proceduree p = new Proceduree();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		IProcedureRepository pr = new ProcedureRepository(em);
		p = pr.findProcedure(2);
		pr.removeProcedure(p);
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}