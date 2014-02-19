package isw2.infrastructure.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.IIncidenceRepository;
import isw2.domain.incidence.Incidence;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.product.IProductRepository;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;
import isw2.infrastructure.persistence.jpa.ProcedureRepository;
import isw2.infrastructure.persistence.jpa.ProductRepository;

public class TestIncidenceRepository {

	public static void main(String[] args) {
		
		// storeIncidence
		IIncidence i = new Incidence();
		i.setClientEmail("email@email.com");
		i.setClientName("email");
		i.setDescription("tengo problemas en el discoduro, me hace mucho ruido");
						
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
						

		IProcedureRepository pr = new ProcedureRepository(em);
		IProductRepository dr = new ProductRepository(em);
		
		IIncidenceRepository ir = new IncidenceRepository(em);
		ir.storeIncidence(i);
				
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
