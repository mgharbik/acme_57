package isw2.defensa;

import isw2.domain.technical.ITechnical;
import isw2.domain.technical.ITechnicalRepository;
import isw2.domain.technical.Technical;
import isw2.infrastructure.persistence.jpa.TechnicalRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crea1Tecnicos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// storeTechnical
		ITechnical t1 = new Technical();
		t1.setDNI("técnico1");
		t1.setUser("técnico1");
		t1.setPassword("técnico1");
		t1.setFistName("técnico1");
		t1.setSurName("técnico1");
		t1.setPhone("técnico1");
		t1.setAddress("técnico1");
		t1.setCredentials("técnico1");
		
		ITechnical t2 = new Technical();
		t2.setDNI("técnico2");
		t2.setUser("técnico2");
		t2.setPassword("técnico2");
		t2.setFistName("técnico2");
		t2.setSurName("técnico2");
		t2.setPhone("técnico2");
		t2.setAddress("técnico2");
		t2.setCredentials("técnico2");
		
		ITechnical t3 = new Technical();
		t3.setDNI("técnico3");
		t3.setUser("técnico3");
		t3.setPassword("técnico3");
		t3.setFistName("técnico3");
		t3.setSurName("técnico3");
		t3.setPhone("técnico3");
		t3.setAddress("técnico3");
		t3.setCredentials("técnico3");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
				
		ITechnicalRepository tr = new TechnicalRepository(em);
				
		tr.storeTechnical(t1);
		tr.storeTechnical(t2);
		tr.storeTechnical(t3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
