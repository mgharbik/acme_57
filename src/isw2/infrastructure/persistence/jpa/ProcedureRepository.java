package isw2.infrastructure.persistence.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.procedure.Proceduree;

public class ProcedureRepository extends JPARepository 
									implements IProcedureRepository{

	public ProcedureRepository(EntityManager em) {
		super(em);
	}

	@Override
	public List<Proceduree> findAll() {
		return getEntityManager().createQuery("from Proceduree", Proceduree.class).getResultList();
	}

	@Override
	public Proceduree findProcedure(Integer id) {
		return getEntityManager().find(Proceduree.class, id);
	}

	@Override
	public void modifyProcedure(IProcedure procedure) {
		getEntityManager().refresh(procedure);		
	}

	@Override
	public void removeProcedure(IProcedure procedure) {
		getEntityManager().remove(procedure);				
	}

	@Override
	public void storeProcedure(IProcedure procedure) {
		getEntityManager().persist(procedure);		
	}

}
