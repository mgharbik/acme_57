package isw2.infrastructure.persistence.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.Incidence;
import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.Proceduree;


/**
 * Unit test for simple App.
 */
public class AppTestProcedureIncidence 
{
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private IProcedure p;
	private IIncidence i;
	
	@Before
	public void setup() {
		emf = Persistence.createEntityManagerFactory("acme");

		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		p = new Proceduree();
		p.setName("voz");
		
		i = new Incidence();
		i.setClientName("simo");
		i.setProcedure(p);
		
		em.persist(p);
		em.persist(i);
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


