package isw2.infrastructure.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import isw2.domain.product.Product;


/**
 * Unit test for simple App.
 */
public class AppTestProductIncidence 
{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private Product p;
	private Product p1;
	
	@Before
	public void setup() {
		emf = Persistence.createEntityManagerFactory("acme");

		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		p = new Product();
		p.setName("auriculares");
		p.setDescription("auriculares");
		
		p1 = new Product();
		p1.setName("raton");
		p1.setDescription("raton");
	
		em.persist(p);
		em.persist(p1);
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


