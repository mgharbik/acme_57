package isw2.infrastructure.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import isw2.domain.technical.Boss;
import isw2.domain.technical.IBoss;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.Technical;


/**
 * Unit test for simple App.
 */
public class AppTestTechnical 
{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private ITechnical t;
	private IBoss b;
	
	@Before
	public void setup() {
		emf = Persistence.createEntityManagerFactory("acme");
//		emf = Persistence.createEntityManagerFactory("isw2.tasks");

		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		b = new Boss();
		b.setDNI("54453");
		
		t = new Technical();
		t.setDNI("32321");
		t.setFistName("Simo");
		t.setSurName("Gharbi");
		
		t.setUser("simo163");
		t.setPassword("545fsbvvcb");
	
		t.setBoss(b);
		
		em.persist(b);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		
		em = emf.createEntityManager();
	}
	
	@After
	public void cleanup() {
		em.close();
		emf.close();
	}
	
	@Test
	public void testPersitence() {
	
	}

	
}


