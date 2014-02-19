package isw2.domain.procedure;

import java.util.List;


public interface IProcedureRepository {

	public void storeProcedure(IProcedure procedure);
	
	public void modifyProcedure(IProcedure procedure);

	public void removeProcedure(IProcedure procedure);
	
	public Proceduree findProcedure(Integer id);
	
	public List<Proceduree> findAll();

}
