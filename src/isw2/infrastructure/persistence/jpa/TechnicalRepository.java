package isw2.infrastructure.persistence.jpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import isw2.domain.incidence.IIncidence;
import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.IProcedureRepository;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.ITechnicalRepository;
import isw2.domain.technical.Technical;

import javax.persistence.Query;

public class TechnicalRepository extends JPARepository 
							implements ITechnicalRepository{

	public TechnicalRepository(EntityManager em) {
		super(em);
	}

	@Override
	public void assignProcedure(ITechnical technical, IProcedure procedure) {
		boolean res=true;
		Set<ITechnical> lts = new HashSet<ITechnical>();
		Set<IProcedure> lps = new HashSet<IProcedure>();
		
		ITechnical t = findTechnical(technical.getUser());
		if(t==null){
			res=false;
			System.out.print("The techncail: "+ technical.getUser() +"dosn't exist in the db");
		}
		IProcedureRepository pdr = new ProcedureRepository(getEntityManager());
		IProcedure p = pdr.findProcedure(procedure.getID());
		if(p==null){
			res=false;
			System.out.print("The procedure: "+ procedure.getName() +"dosn't exist in the db");
		}
		
		if(res){
			lps = t.getProcedures();
			lps.add(procedure);
			t.setProcedures(lps);
			
			lps = t.getProcedures();
			lps.add(p);
			p.setTechnicals(lts);
		}
	}

	@Override
	public void untieProcedure(ITechnical technical, IProcedure procedure) {		
//		technical.getProcedures().removeAll(procedures);
//		technical.setProcedures(technical.getProcedures());
//		modifyTechnical(technical);
	}

	@Override
	public List<Technical> findAll() {
		return getEntityManager().createQuery("from Technical", Technical.class).getResultList();
	}

	@Override
	public Technical findTechnical(String usr) {
		//return getEntityManager().find(Technical.class, usr);
//		Query q = getEntityManager().createQuery("select t from Technical t where " +
//				"t.user = :nombre");
//		q.setParameter("nombre", usr);
//		q.setMaxResults(1);
//		Technical t =(Technical) q.getSingleResult();
//		return t;
		Technical t;
		try{
			Query q = getEntityManager().createQuery("select t from Technical t where " +
					"t.user = :nombre");
			q.setParameter("nombre", usr);
			q.setMaxResults(1);
			t =(Technical) q.getSingleResult();
		}catch(Exception e) {
			return null;
		}
		return t;
	}

	@Override
	public boolean logIn(String user, String password) {
		boolean res=false;
		Technical t = findTechnical(user);
		if(t==null){
			System.out.print("The user: "+ user +"dosn't exist in the db");
		}else{
			if(t.getPassword().equals(password))
				res=true;
		}
		return res;
	}

	@Override
	public void logOut(String user) {
		Technical t = findTechnical(user);
			t.setLogged(false);
			modifyTechnical(t);
	}

	@Override
	public void modifyTechnical(Technical technical) {
		Technical t = findTechnical(technical.getUser());
		t.setPassword(technical.getPassword());
		t.setDNI(technical.getDNI());
		t.setFistName(technical.getFistName());
		t.setSurName(technical.getSurName());
		t.setEmail(technical.getEmail());
		t.setPhone(technical.getPhone());
	}

	@Override
	public void removeTechnical(Technical technical) {
		getEntityManager().remove(technical);			
	}

	@Override
	public void storeTechnical(ITechnical technical) {
		getEntityManager().persist(technical);
	}

	@Override
	public List<IIncidence> incidencesResolvedBy(String user) {
		// TODO Auto-generated method stub
		List<IIncidence> l = new ArrayList<IIncidence>(findTechnical(user).getIncidences());
		List<IIncidence>  result = new ArrayList<IIncidence>();
		for(IIncidence i:l)
			if(i.getReplayDescription()!=null)
				result.add(i);
		return result;
	}

}
