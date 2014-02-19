package isw2.domain.procedure;

import java.util.Set;

import isw2.domain.incidence.IIncidence;
import isw2.domain.product.IProduct;
import isw2.domain.technical.ITechnical;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({"getProducts().isEmpty()", "getTechnicals().isEmpty()", "getIncidences().isEmpty()"})
@Inv({"getProducts().size()>=0", 
		"getTechnicals().size()>=0", 
		"getIncidences().size()>=0"})

public interface IProcedure {

	@Query
	@Pre({"true"})
	Integer getID();
	
	@Pre({"id != null # IllegalArgumentException"})
	@Pos({"getID().equals(id)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(des)",
		"getProducts().equals(getProducts()@pre)",
		"getIncidences().equals(getIncidences()@pre)",
		"getTechnicals().equals(technicals)"})
	void setID(Integer id);
	
	@Query
	@Pre({"true"})
	String getName();
	
	@Pre({"name != null # IllegalArgumentException" , "!name.equals(\"\") # IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(name)",
		"getDescription().equals(getDescription()@pre)",
		"getProducts().equals(getProducts()@pre)",
		"getIncidences().equals(getIncidences()@pre)",
		"getTechnicals().equals(technicals)"})
	void setName(String name);
	
	@Query
	@Pre({"true"})
	String getDescription();
	
	@Pre({"des != null # IllegalArgumentException" , "!des.equals(\"\") # IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(des)",
		"getProducts().equals(getProducts()@pre)",
		"getIncidences().equals(getIncidences()@pre)",
		"getTechnicals().equals(technicals)"})
	void setDescription(String des);
	
	// this method returns all the products which has that procedure
	@Query
	@Pre({"true"})
	Set<IProduct> getProducts();
	
	@Pre({"products != null # IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getProducts().equals(products)",
		"getIncidences().equals(getIncidences()@pre)",
		"getTechnicals().equals(getTechnicals()@pre)"})
	void setProducts(Set<IProduct> products);
	
	// this method returns all the incidences which has that procedure
	@Query
	@Pre({"true"})
	Set<IIncidence> getIncidences();
	
	@Pre({"incidences != null # IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getProducts().equals(getProducts()@pre)",
		"getIncidences().equals(incidences)",
		"getTechnicals().equals(getTechnicals()@pre)"})
	void setIncidences(Set<IIncidence> incidences);
	
	// this method returns all the technical who can answer to incidence which has that procedure
	@Query
	@Pre({"true"})
	Set<ITechnical> getTechnicals();
	
	@Pre({"technicals != null #IllegalArgumentException"})
	@Pos({"getID().equals(getID()@pre)", 
		"getName().equals(getName()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getProducts().equals(getProducts()@pre)",
		"getIncidences().equals(getIncidences()@pre)",
		"getTechnicals().equals(technicals)"})
	void setTechnicals(Set<ITechnical> technicals);
}
