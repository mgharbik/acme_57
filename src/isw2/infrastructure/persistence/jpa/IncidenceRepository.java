package isw2.infrastructure.persistence.jpa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.IIncidenceRepository;
import isw2.domain.incidence.Incidence;
import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.ITechnicalRepository;
import isw2.domain.technical.Technical;

public class IncidenceRepository extends JPARepository 
									implements IIncidenceRepository{

	public IncidenceRepository(EntityManager em) {
		super(em);
	}

	@Override
	public void evaluateReply(Integer id, Integer note) {
		Incidence i = findIncidence(id);
		i.setReplayMark(note);
	}

	@Override
	public List<Incidence> findAll() {
		return getEntityManager().createQuery("from Incidence", Incidence.class).getResultList();
	}

	@Override
	public Incidence findIncidence(Integer id) {
		return getEntityManager().find(Incidence.class, id);
	}

	@Override
	public List<IIncidence> findIncidencesOfProcedure(Integer id) {
		List<IIncidence> l = new ArrayList<IIncidence>();
		IProcedureRepository pdr = new ProcedureRepository(getEntityManager());
		IProcedure d = pdr.findProcedure(id);
		for(IIncidence i : d.getIncidences())
			if(i.getTechncail()==null)
				l.add(i);
		return l;
	}

	@Override
	public List<IIncidence> findIncidencesOfTechnical(String usr) {
		//return getEntityManager().createQuery("from User Where user=usr", Incidence.class).getResultList();
		List<IIncidence> l = new ArrayList<IIncidence>();
		ITechnicalRepository tr = new TechnicalRepository(getEntityManager());
		ITechnical t = tr.findTechnical(usr);
		for(IProcedure p : t.getProcedures()){
			l.addAll(findIncidencesOfProcedure(p.getID()));	
		}
		return l;
	}

	@Override
	public List<String> getIncidenceDetails(Integer id) {
		List<String> l = new ArrayList<String>();
		Incidence i = findIncidence(id);
		l.add(i.getID().toString());
		l.add(i.getClientName());
		l.add(i.getClientEmail());
		l.add(i.getDate().toString());
		l.add(i.getDescription());
		l.add(i.getProcedure().getDescription());
		l.add(i.getProduct().getName());
		l.add(i.getReplayDescription());
		l.add(i.getReplayDate().toString());
		return l;
	}

	@Override
	public void storeIncidence(IIncidence incidence) {
		IIncidence i = incidence;
		if(i.getProcedure()==null){
			i.setReplayDescription("System: auto-replay");
			i.setReplayDate(new Date());
			
			ITechnicalRepository it = new TechnicalRepository(getEntityManager());
			Technical t =  it.findTechnical("SYSTEM");
			i.setTechnical(t);
		}
		getEntityManager().persist(i);
	}

	@Override
	public void storeReply(Integer id, String des) {
		Incidence i = findIncidence(id);
		if(i.getTechncail().equals(null)){
			System.out.println("There is a technical taking this incidence");			
		}else{
			i.setReplayDescription(des);
			i.setReplayDate(new Date());
		}
		
	}

	@Override
	public void asignIncidenceToTechnical(String user, Integer id) {
		List<IIncidence> l = new ArrayList<IIncidence>();
		ITechnicalRepository tr = new TechnicalRepository(getEntityManager());
		ITechnical t = tr.findTechnical(user);
		l = findIncidencesOfTechnical(user);
		
		IIncidenceRepository ir = new IncidenceRepository(getEntityManager());
		IIncidence i = ir.findIncidence(id);
		if(l.contains(i)){
			Set<IIncidence> si = t.getIncidences();
			si.add(i);
			t.setIncidences(si);
			
			i.setTechnical(t);
		}else{
			System.out.println("ya no esta disponible la incidencia #"+i.getID());
		}
	}

	@Override
	public void storeIncidenceReferencedTo(Integer id_incidencia, String des) {
		// TODO Auto-generated method stub
		IIncidenceRepository ir = new IncidenceRepository(getEntityManager());
		IIncidence i = ir.findIncidence(id_incidencia);
		IIncidence result = new Incidence();
		result.setClientName(i.getClientName());
		result.setClientEmail(i.getClientEmail());
		result.setDescription(des);
		result.setProcedure(i.getProcedure());
		result.setProduct(i.getProduct());
		result.setIncidence(i);
		result.setDate(new Date());
		storeIncidence(result);
	}
	
}
