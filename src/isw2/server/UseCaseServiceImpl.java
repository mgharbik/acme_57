package isw2.server;

import java.util.ArrayList;

import javax.persistence.*;

import isw2.client.UseCaseService;
import isw2.domain.incidence.IIncidenceRepository;
import isw2.domain.incidence.Incidence;
import isw2.domain.technical.ITechnicalRepository;
import isw2.domain.technical.Technical;
import isw2.infrastructure.persistence.jpa.IncidenceRepository;
import isw2.infrastructure.persistence.jpa.TechnicalRepository;
import isw2.shared.IncidenceDTO;
import isw2.shared.TechnicalDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UseCaseServiceImpl extends RemoteServiceServlet implements
    UseCaseService {

  
@Override
public ArrayList<TechnicalDTO> getTechnicals() throws IllegalArgumentException {
	// TODO Auto-generated method stub
	ArrayList<TechnicalDTO> result = new ArrayList<TechnicalDTO>();
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
	EntityManager em = emf.createEntityManager();
	ITechnicalRepository ur = new TechnicalRepository(em);
	
	try{
		for(Technical t:ur.findAll()){
			TechnicalDTO technicalDto = new TechnicalDTO();		
			technicalDto.setUser(t.getUser());
			technicalDto.setPassword(t.getPassword());
			technicalDto.setDNI(t.getDNI());
			technicalDto.setCredentials(t.getCredentials());
			technicalDto.setFistName(t.getFistName());
			technicalDto.setSurName(t.getSurName());
			//technicalDto.setBirthDay(t.getBirthDay());
			technicalDto.setEmail(t.getEmail());
			technicalDto.setAddress(t.getAddress());
			technicalDto.setPhone(t.getPhone());
			result.add(technicalDto);
		}
	}finally{
		em.close();
		emf.close();
	}
	
	return result;
}

@Override
public Boolean validateUser(String user, String password)
		throws IllegalArgumentException {	
	boolean res;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
	EntityManager em = emf.createEntityManager();
	TechnicalRepository tr = new TechnicalRepository(em);
	res=tr.logIn(user, password);
	em.close();
	emf.close();
	return res;
	
}

@Override
public ArrayList<TechnicalDTO> deleteTechnicals(ArrayList<String> users)
		throws IllegalArgumentException {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ITechnicalRepository ur = new TechnicalRepository(em);
		for(String user:users){
			Technical t = ur.findTechnical(user);
			ur.removeTechnical(t);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
		return getTechnicals();
	}

@Override
public TechnicalDTO addTechnical(TechnicalDTO t)
		throws IllegalArgumentException {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
	EntityManager em = emf.createEntityManager();
	ITechnicalRepository ur = new TechnicalRepository(em);
	
	try{		
		Technical tec = new Technical();
		tec.setUser(t.getUser());
		tec.setPassword(t.getPassword());
		tec.setDNI(t.getDNI());
		//tec.setCredentials(t.getCredentials());
		tec.setFistName(t.getFistName());
		tec.setSurName(t.getSurName());
		//tec.setBirthDay(t.getBirthDay());
		tec.setEmail(t.getEmail());
		//tec.setAddress(t.getAddress());
		tec.setPhone(t.getPhone());
		
		em.getTransaction().begin();
		ur.storeTechnical(tec);
		em.getTransaction().commit();
	}finally{
		em.close();
		emf.close();
	}
	
	return t;
}

@Override
public TechnicalDTO getTechnical(String usr) throws IllegalArgumentException {
	// TODO Auto-generated method stub
	TechnicalDTO result = new TechnicalDTO();
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
	EntityManager em = emf.createEntityManager();
	ITechnicalRepository ur = new TechnicalRepository(em);

	
	try{
		Technical t = ur.findTechnical(usr);
		result.setUser(t.getUser());
		result.setPassword(t.getPassword());
		result.setDNI(t.getDNI());
		//result.setCredentials(t.getCredentials());
		result.setFistName(t.getFistName());
		result.setSurName(t.getSurName());
		//tec.setBirthDay(t.getBirthDay());
		result.setEmail(t.getEmail());
		//tec.setAddress(t.getAddress());
		result.setPhone(t.getPhone());
		
	}finally{
		em.close();
		emf.close();
	}
	return result;
}

@Override
public TechnicalDTO updateTechncial(TechnicalDTO t)
		throws IllegalArgumentException {
	// TODO Auto-generated method stub
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
	EntityManager em = emf.createEntityManager();
	ITechnicalRepository ur = new TechnicalRepository(em);

	
	try{
		Technical result = ur.findTechnical(t.getUser());
		//result.setUser(t.getUser());
		result.setPassword(t.getPassword());
		result.setDNI(t.getDNI());
		//result.setCredentials(t.getCredentials());
		result.setFistName(t.getFistName());
		result.setSurName(t.getSurName());
		//tec.setBirthDay(t.getBirthDay());
		result.setEmail(t.getEmail());
		//tec.setAddress(t.getAddress());
		result.setPhone(t.getPhone());
		
		em.getTransaction().begin();
		ur.modifyTechnical(result);
		em.getTransaction().commit();
	}finally{
		em.close();
		emf.close();
	}
	return t;
}

@Override
public ArrayList<IncidenceDTO> getIncidences() throws IllegalArgumentException {
	
	ArrayList<IncidenceDTO> result = new ArrayList<IncidenceDTO>();
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("acme");
	EntityManager em = emf.createEntityManager();
	IIncidenceRepository ir = new IncidenceRepository(em);
	
	try{
		for(Incidence i:ir.findAll()){
			if(i.getProcedure()!=null){
				IncidenceDTO incidenceDto = new IncidenceDTO();		
				incidenceDto.setID(i.getID());
				incidenceDto.setClientName(i.getClientName());
				incidenceDto.setClientEmail(i.getClientEmail());
				incidenceDto.setDescription(i.getDescription());
				incidenceDto.setDate(i.getDate());
				incidenceDto.setProduct(i.getProduct().getDescription());
				incidenceDto.setProcedure(i.getProcedure().getDescription());
				incidenceDto.setReplayMark(i.getReplayMark());
				//incidenceDto.setReplayDescription(i.getReplayDescription());
				//incidenceDto.setReplayDate(i.getReplayDate());
				//incidenceDto.setTechnical(i.getTechncail().getUser());
				result.add(incidenceDto);
			}
		}
	}finally{
		em.close();
		emf.close();
	}
	return result;
}

@Override
public IncidenceDTO addIncidence(IncidenceDTO i)
		throws IllegalArgumentException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<String> getIncidenceDetails(Integer id)
		throws IllegalArgumentException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void evaluateReply(Integer id, Integer mark)
		throws IllegalArgumentException {
	// TODO Auto-generated method stub
	
}


}
