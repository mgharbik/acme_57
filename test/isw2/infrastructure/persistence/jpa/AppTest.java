package isw2.infrastructure.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import isw2.domain.technical.ITechnical;
import isw2.domain.technical.Technical;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	@Before
	public void setup() {
		emf = Persistence.createEntityManagerFactory("acme");

		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		ITechnical t = new Technical();
		t.setDNI("0000");
		t.setUser("SYSTEM");
	
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


