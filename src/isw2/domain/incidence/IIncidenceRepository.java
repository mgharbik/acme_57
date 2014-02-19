package isw2.domain.incidence;

import java.util.List;


public interface IIncidenceRepository {

	public void storeIncidence(IIncidence incidence);
	
	public List<Incidence> findAll();
	
	public Incidence findIncidence(Integer id);
	
	public void storeReply(Integer id, String des);
	
	public void evaluateReply(Integer id, Integer mark);
	
	public List<String> getIncidenceDetails(Integer id);
	
	public List<IIncidence> findIncidencesOfTechnical(String user);				

	public List<IIncidence> findIncidencesOfProcedure(Integer id);				
	
	public void asignIncidenceToTechnical(String user, Integer id);
	
	public void storeIncidenceReferencedTo(Integer id_incidencia, String des);
	
}