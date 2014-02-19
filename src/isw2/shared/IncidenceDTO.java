package isw2.shared;

import java.io.Serializable;
import java.util.Date;


public class IncidenceDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String cname;
	private String cemail;
	private String des;
	private Date date;
	
	private String product;
	
	private String procedure;
	
	private String technical;

	private String incidence;
	
	
	private Date replayDate;
	private String replayDescription;
	private Integer replayMark;
	
	public IncidenceDTO(String cname, String cemail, String des, 
			String incidence, String procedure, String product){
		
		this.cname = cname;
		this.cemail = cemail;
		this.des = des;
		this.date = new Date();
		this.incidence = incidence;
		this.product = product;
		this.procedure = procedure;
	}
	
	public IncidenceDTO() {
		this.date = new Date();
	}

	public Integer getID() {
		return id;
	}
	
	public void setID(Integer id) {
		this.id = id;
	}
	
	public String getClientName() {
		return cname;
	}

	public void setClientName(String cname) {
		this.cname = cname;
	}

	public String getClientEmail() {
		return cemail;
	}

	public void setClientEmail(String cemail) {
		this.cemail = cemail;
	}

	public String getDescription() {
		return des;
	}

	public void setDescription(String des) {
		this.des = des;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getIncidence() {
		return incidence;
	}

	public void setIncidence(String incidence) {
		this.incidence = incidence;
	}
	
	
	public Integer getReplayMark() {
		return replayMark;
	}

	
	public void setReplayMark(Integer note) {
		this.replayMark = note;
	}

	
	public String getReplayDescription() {
		return replayDescription;
	}

	
	public void setReplayDescription(String des) {
		this.replayDescription = des;
	}

	
	public Date getReplayDate() {
		return replayDate;
	}

	
	public void setReplayDate(Date date) {
		this.replayDate = date;
	}
	
	
	public String getTechncail() {
		return technical;
	}

	
	public void setTechnical(String technical) {
		this.technical = technical;
	}
	
	public String toString(){
		return "i" + id + "# cliente: " + cname+ ", descripcion: " + des;
	}
	
}
