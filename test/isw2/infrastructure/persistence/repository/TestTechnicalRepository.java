package isw2.infrastructure.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import isw2.client.UseCaseService;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.ITechnicalRepository;
import isw2.domain.technical.Technical;
import isw2.server.UseCaseServiceImpl;
import isw2.shared.TechnicalDTO;

public class TestTechnicalRepository {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		
		/*
		 // findAll
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		ITechnicalRepository tr = new TechnicalRepository(em);
		
		List<Technical> ts = tr.findAll();
		System.out.println("numero de tecnicos: "+ts.size());
		System.out.println("1er user: "+ts.get(0).getUser());
		
		em.getTransaction().commit();
		em.close();
		
		em = emf.createEntityManager();
		*/
		
		
		/*
		// findTechnical
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		ITechnicalRepository tr = new TechnicalRepository(em);
				
		Technical t = tr.findTechnical("simo163");
		System.out.println("user: "+ t.getUser());
		System.out.println("pass: "+ t.getPassword());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		*/
		
		/*
		// logIn
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		ITechnicalRepository tr = new TechnicalRepository(em);
				
		boolean b = tr.logIn("simo163", "545fsbvvcb");
		System.out.println("logeado "+ b);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		*/
		
		/*
		// storeTechnical
		
		Technical totro = new Technical();
		totro.setDNI("qwerty");
		totro.setUser("ale");
		totro.setPassword("0000");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		ITechnicalRepository tr = new TechnicalRepository(em);
				
		tr.storeTechnical(totro);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		*/
		
		/*
		// modifyTechnical
		Technical totro1 = new Technical();
		totro1.setDNI("hola");
		totro1.setUser("anass");
		totro1.setPassword("1111");
		totro1.setEmail("anas@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		ITechnicalRepository tr = new TechnicalRepository(em);
		tr.storeTechnical(totro1);

		totro1 = tr.findTechnical("anass");
		totro1.setEmail("anas111@gmail.com");
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		*/
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//				
//		ITechnicalRepository tr = new TechnicalRepository(em);
//
//		Technical totro1 = tr.findTechnical("anass");
//		totro1.setEmail("anas2222@gmail.com");
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
	}

}
