package isw2.domain.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.Incidence;
import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.Proceduree;

@Entity
public class Product implements IProduct {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String des;
	
	@ManyToMany(mappedBy = "products", targetEntity = Proceduree.class)
	private Set<IProcedure> procedures = new HashSet<IProcedure>();
	
	@OneToMany(mappedBy = "product", targetEntity = Incidence.class)
	private Set<IIncidence> incidences = new HashSet<IIncidence>();
	
	
	public Product(String name, String des, Set<IProcedure> procedures){
		if(name == null || des == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(name == "" || des == "")
			throw new IllegalArgumentException("Empty arguments are not allowed");
		
		this.name = name;
		this.des = des;
		this.procedures = procedures;
	}
	
	public Product(String name, String des){
		if(name == null || des == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(name == "" || des == "")
			throw new IllegalArgumentException("Empty arguments are not allowed");
		
		this.name = name;
		this.des = des;
	}
	
	public Product() {
	}

	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		if(id == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(name == "")
			throw new IllegalArgumentException("Empty arguments are not allowed");
		
		this.name = name;
	}

	public String getDescription() {
		return des;
	}

	public void setDescription(String des) {
		if(des == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(des == "")
			throw new IllegalArgumentException("Empty arguments are not allowed");
		
		this.des = des;
	}

	public Set<IProcedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(Set<IProcedure> procedures) {
		if(procedures == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		this.procedures = procedures;
	}

	public Set<IIncidence> getIncidences() {
		return incidences;
	}

	public void setIncidences(Set<IIncidence> incidences) {
		if(incidences == null )
			throw new IllegalArgumentException("Null arguments are not allowed");		
		this.incidences = incidences;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
