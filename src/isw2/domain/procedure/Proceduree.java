package isw2.domain.procedure;

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
import isw2.domain.product.IProduct;
import isw2.domain.product.Product;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.Technical;

@Entity
public class Proceduree implements IProcedure {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	
	@ManyToMany(targetEntity = Product.class)
	private Set<IProduct> products = new HashSet<IProduct>();
	
	
	@OneToMany(mappedBy = "procedure", targetEntity = Incidence.class)
	private Set<IIncidence> incidences = new HashSet<IIncidence>();
	
	@ManyToMany(mappedBy = "procedures", targetEntity = Technical.class)
	private Set<ITechnical> technicals = new HashSet<ITechnical>();
	

	public Proceduree(String name, String description){
		if(name == null || description == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(name == "" || description == "")
			throw new IllegalArgumentException("Empty arguments are not allowed");

		this.name = name;
		this.description = description;
	}
	
	public Proceduree() {
	}

	public Integer getID() {
		return id;
	}
	
	public void setID(Integer id) {
		if(id == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(name == "" )
			throw new IllegalArgumentException("Empty arguments are not allowed");
		
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if(description == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(description == "" )
			throw new IllegalArgumentException("Empty arguments are not allowed");
		
		this.description = description;
	}
	
	public Set<IProduct> getProducts() {
		return products;
	}
	
	public void setProducts(Set<IProduct> products) {
		if(products == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		this.products = products;
	}
	
	public Set<IIncidence> getIncidences() {
		return incidences;
	}
	
	public void setIncidences(Set<IIncidence> incidences) {
		if(incidences == null)
			throw new IllegalArgumentException("Null arguments are not allowed");

		this.incidences = incidences;
	}
	
	public Set<ITechnical> getTechnicals() {
		return technicals;
	}
	
	public void setTechnicals(Set<ITechnical> technicals) {
		if(technicals == null)
			throw new IllegalArgumentException("Null arguments are not allowed");

		this.technicals = technicals;
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
		if (!(obj instanceof Proceduree))
			return false;
		Proceduree other = (Proceduree) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}