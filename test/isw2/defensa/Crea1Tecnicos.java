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
		t1.setDNI("t�cnico1");
		t1.setUser("t�cnico1");
		t1.setPassword("t�cnico1");
		t1.setFistName("t�cnico1");
		t1.setSurName("t�cnico1");
		t1.setPhone("t�cnico1");
		t1.setAddress("t�cnico1");
		t1.setCredentials("t�cnico1");
		
		ITechnical t2 = new Technical();
		t2.setDNI("t�cnico2");
		t2.setUser("t�cnico2");
		t2.setPassword("t�cnico2");
		t2.setFistName("t�cnico2");
		t2.setSurName("t�cnico2");
		t2.setPhone("t�cnico2");
		t2.setAddress("t�cnico2");
		t2.setCredentials("t�cnico2");
		
		ITechnical t3 = new Technical();
		t3.setDNI("t�cnico3");
		t3.setUser("t�cnico3");
		t3.setPassword("t�cnico3");
		t3.setFistName("t�cnico3");
		t3.setSurName("t�cnico3");
		t3.setPhone("t�cnico3");
		t3.setAddress("t�cnico3");
		t3.setCredentials("t�cnico3");
		
		
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
