package isw2.shared;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.Incidence;
import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.Proceduree;


public class ProductDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String des;
	
	private Set<IProcedure> procedures = new HashSet<IProcedure>();
	
	private Set<IIncidence> incidences = new HashSet<IIncidence>();
	
	public ProductDTO(String name, String des, Set<IProcedure> procedures){
		this.name = name;
		this.des = des;
		this.procedures = procedures;
	}
	
	public ProductDTO(String name, String des){
		this.name = name;
		this.des = des;
	}
	
	public ProductDTO() {
	}

	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return des;
	}

	public void setDescription(String des) {
		this.des = des;
	}

	public Set<IProcedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(Set<IProcedure> procedures) {
		this.procedures = procedures;
	}

	public Set<IIncidence> getIncidences() {
		return incidences;
	}

	public void setIncidences(Set<IIncidence> incidences) {
		this.incidences = incidences;
	}

}
