package isw2.domain.product;

import java.util.Set;

import isw2.domain.incidence.IIncidence;
import isw2.domain.procedure.IProcedure;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({"getProcedures().isEmpty()", "getIncidences().isEmpty()"})
@Inv({"getProcedures().size()>=0", 
		"getIncidences().size()>=0"})

public interface IProduct {

	@Query
	@Pre({"true"})
	Integer getID();
	
	@Pre({"id != null # IllegalArgumentException"})
	@Pos({"getID().equals(id)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getProcedures().equals(getProcedures()@pre)",
		"getIncidences().equals(getIncidences()@pre)"})
	void setID(Integer id);
	
	@Query
	@Pre({"true"})
	String getName();
	
	@Pre({"name != null # IllegalArgumentException" , "!name.equals('') # IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(name)",
		"getDescription().equals(getDescription()@pre)",
		"getProcedures().equals(getProcedures()@pre)",
		"getIncidences().equals(getIncidences()@pre)"})
	void setName(String name);
	
	@Query
	@Pre({"true"})
	String getDescription();
	
	@Pre({"des != null # IllegalArgumentException" , "!des.equals('') # IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(des)",
		"getProcedures().equals(getProcedures()@pre)",
		"getIncidences().equals(getIncidences()@pre)"})
	void setDescription(String des);
	
	// getProcedures() returns all the procedures assigned to this product.
	@Query
	@Pre({"true"})
	public Set<IProcedure> getProcedures();
	
	@Pre({"procedures != null # IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getProcedures().equals(procedures)",
		"getIncidences().equals(getIncidences()@pre)"})
	public void setProcedures(Set<IProcedure> procedures);

	
	// getIncidences() returns all the incidences returns which are related to this product.
	@Query
	@Pre({"true"})
	public Set<IIncidence> getIncidences();
	
	@Pre({"incidences != null # IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getProcedures().equals(getProcedures()@pre)",
		"getIncidences().equals(incidences)"})
	public void setIncidences(Set<IIncidence> incidences);
	
}
