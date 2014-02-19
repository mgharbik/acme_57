package isw2.domain.technical;

import java.util.List;

import isw2.domain.incidence.IIncidence;
import isw2.domain.procedure.IProcedure;

public interface ITechnicalRepository {
	
	public void storeTechnical(ITechnical technical);
	
	public void modifyTechnical(Technical technical);
	
	public void removeTechnical(Technical technical);
	
	public Technical findTechnical(String usr);
	
	public List<Technical> findAll();
	
	public boolean logIn(String user, String password);
	
	public void logOut(String user);
	
	public void assignProcedure(ITechnical technical, IProcedure procedure);

	public void untieProcedure(ITechnical technical, IProcedure procedure);
	
	public List<IIncidence> incidencesResolvedBy(String user); 
}
