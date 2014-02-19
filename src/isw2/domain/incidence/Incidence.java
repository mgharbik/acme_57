package isw2.domain.incidence;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.Proceduree;
import isw2.domain.product.IProduct;
import isw2.domain.product.Product;
import isw2.domain.technical.ITechnical;
import isw2.domain.technical.Technical;

@Entity
public class Incidence implements IIncidence {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String cname;
	private String cemail;
	private String des;
	private Date date;
	
	@ManyToOne(targetEntity = Product.class)
	private IProduct product;
	
	@ManyToOne(targetEntity = Proceduree.class)
	private IProcedure procedure;
	
	@ManyToOne(targetEntity = Technical.class)
	private ITechnical technical;

	@ManyToOne(targetEntity = Incidence.class)
	private IIncidence incidence;
	
//	@OneToMany(mappedBy = "incidence",targetEntity = Incidence.class)
//	private Set<IIncidence> incidences = new HashSet<IIncidence>();
	
	private Date replayDate;
	private String replayDescription;
	private Integer replayMark;
	
	public Incidence(String cname, String cemail, String des, 
			IIncidence incidence, IProcedure procedure, IProduct product){
		if(cname == null || cemail == null || des == null || product == null || procedure == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(cname == "" || cemail == "" || des == "")
			throw new IllegalArgumentException("Empty arguments are not allowed");
		
		this.cname = cname;
		this.cemail = cemail;
		this.des = des;
		this.date = new Date();
		this.incidence = incidence;
		this.product = product;
		this.procedure = procedure;
	}
	
	public Incidence() {
		this.date = new Date();
	}

	public Integer getID() {
		return id;
	}
	
	public void setID(Integer id) {
		if(id == null)
			throw new IllegalArgumentException("Null arguments are not allowed");
		this.id = id;
	}
	
	public String getClientName() {
		return cname;
	}

	public void setClientName(String cname) {
		if(cname == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(cname == "")
			throw new IllegalArgumentException("Empty arguments are not allowed");
		this.cname = cname;
	}

	public String getClientEmail() {
		return cemail;
	}

	public void setClientEmail(String cemail) {
		if(cemail == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		if(cemail == "")
			throw new IllegalArgumentException("Empty arguments are not allowed");
		
		this.cemail = cemail;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		if(date == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		this.date = date;
	}

	public IProduct getProduct() {
		return product;
	}

	public void setProduct(IProduct product) {
		if(product == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		this.product = product;
	}

	public IProcedure getProcedure() {
		return procedure;
	}

	public void setProcedure(IProcedure procedure) {
		if(procedure == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		this.procedure = procedure;
	}

	public IIncidence getIncidence() {
		return incidence;
	}

	public void setIncidence(IIncidence incidence) {
		if(incidence == null )
			throw new IllegalArgumentException("Null arguments are not allowed");
		this.incidence = incidence;
	}
	
	@Override
	public Integer getReplayMark() {
		// TODO Auto-generated method stub
		return replayMark;
	}

	@Override
	public void setReplayMark(Integer note) {
		// TODO Auto-generated method stub
		if (note == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (note <-5 || note>5) {
			throw new IllegalArgumentException("Mark should be between -5 and 5");
		}
		this.replayMark = note;
	}

	@Override
	public String getReplayDescription() {
		// TODO Auto-generated method stub
		return replayDescription;
	}

	@Override
	public void setReplayDescription(String des) {
		// TODO Auto-generated method stub
		if (des == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (des.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.replayDescription = des;
	}

	@Override
	public Date getReplayDate() {
		// TODO Auto-generated method stub
		return replayDate;
	}

	@Override
	public void setReplayDate(Date date) {
		// TODO Auto-generated method stub
		if (date == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		this.replayDate = date;
	}
	
	@Override
	public ITechnical getTechncail() {
		// TODO Auto-generated method stub
		return technical;
	}

	@Override
	public void setTechnical(ITechnical technical) {
		// TODO Auto-generated method stub
		if (technical == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		this.technical = technical;
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
		if (!(obj instanceof Incidence))
			return false;
		Incidence other = (Incidence) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString(){
		return "i" + id + "# cliente: " + cname+ ", descripcion: " + des;
	}
	
}
