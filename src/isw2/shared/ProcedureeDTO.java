package isw2.shared;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.Incidence;
import isw2.domain.product.IProduct;
import isw2.domain.product.Product;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.Technical;


public class ProcedureeDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	
	private Set<IProduct> products = new HashSet<IProduct>();
	
	private Set<IIncidence> incidences = new HashSet<IIncidence>();
	
	private Set<ITechnical> technicals = new HashSet<ITechnical>();
	

	public ProcedureeDTO(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public ProcedureeDTO() {
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
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<IProduct> getProducts() {
		return products;
	}
	
	public void setProducts(Set<IProduct> products) {
		this.products = products;
	}
	
	public Set<IIncidence> getIncidences() {
		return incidences;
	}
	
	public void setIncidences(Set<IIncidence> incidences) {
		this.incidences = incidences;
	}
	
	public Set<ITechnical> getTechnicals() {
		return technicals;
	}
	
	public void setTechnicals(Set<ITechnical> technicals) {
		this.technicals = technicals;
	}
	

}