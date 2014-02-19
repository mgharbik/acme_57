package isw2.domain.incidence;

import java.util.Date;

import isw2.domain.procedure.IProcedure;
import isw2.domain.product.IProduct;
import isw2.domain.technical.ITechnical;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Query;

@Init({"getDate==Calendar.getInstance()", "getReply()==null", "getIncidence()==null"})
@Inv({"getDate==Calendar.getInstance()"})

public interface IIncidence {
	
	@Query
	@Pre({"true"})
	Integer getID();
	
	@Pre({"id != null # IllegalArgumentException"})
	@Pos({"getID().equals(id)", 
			"getClientName().equals(getClientName()@pre)", 
			"getClientEmail().equals(getClientEmail()@pre)",
			"getDescription().equals(getDescription()@pre)",
			"getDate().equals(getDate()@pre)",
			"getProduct().equals(getProduct()@pre)",
			"getProcedure().equals(getProcedure()@pre)",
			"getReply().equals(getReply()@pre",
			"getIncidence().equals(getIncidence()@pre"})
	void setID(Integer id);
	
	@Query
	@Pre({"true"})
	String getClientName();
	
	@Pre({"cname != null # IllegalArgumentException" , "!cname.equals(\"\") # IllegalArgumentException"})
	@Pos({"getClientName().equals(cname)", 
			"getClientEmail().equals(getClientEmail()@pre)",
			"getDescription().equals(getDescription()@pre)",
			"getDate().equals(getDate()@pre)",
			"getProduct().equals(getProduct()@pre)",
			"getProcedure().equals(getProcedure()@pre)",
			"getReply().equals(getReply()@pre",
			"getIncidence().equals(getIncidence()@pre)"})
	void setClientName(String cname);
	
	@Query
	@Pre({"true"})
	String getClientEmail();
	
	@Pre({"cemail != null # IllegalArgumentException" , "!cemail.equals(\"\") # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
			"getClientEmail().equals(cemail)",
			"getDescription().equals(getDescription()@pre)",
			"getDate().equals(getDate()@pre)",
			"getProduct().equals(getProduct()@pre)",
			"getProcedure().equals(getProcedure()@pre)",
			"getReply().equals(getReply()@pre",
			"getIncidence().equals(getIncidence()@pre)"})
	void setClientEmail(String cemail);
	
	@Query
	@Pre({"true"})
	String getDescription();
	
	@Pre({"des != null # IllegalArgumentException" , "!des.equals(\"\") # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
			"getClientEmail().equals(getClientEmail()@pre)",
			"getDescription().equals(des)",
			"getDate().equals(getDate()@pre)",
			"getProduct().equals(getProduct()@pre)",
			"getProcedure().equals(getProcedure()@pre)",
			"getReply().equals(getReply()@pre",		
			"getIncidence().equals(getIncidence()@pre)"})
	void setDescription(String des);
	
	@Query
	@Pre({"true"})
	Date getDate();
	
	@Pre({"date != null # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
		"getClientEmail().equals(getClientEmail()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getDate().equals(date)",
		"getProduct().equals(getProduct()@pre)",
		"getProcedure().equals(getProcedure()@pre)",
		"getReply().equals(getReply()@pre",
		"getIncidence().equals(getIncidence()@pre)"})
	void setDate(Date date);
	
	// this method returns the product associated to that incidence
	@Query
	@Pre({"true"})
	IProduct getProduct();
	
	@Pre({"product != null # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
		"getClientEmail().equals(getClientEmail()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getDate().equals(getDate()@pre)",
		"getProduct().equals(product)",
		"getProcedure().equals(getProcedure()@pre)",
		"getReply().equals(getReply()@pre)",
		"getIncidence().equals(getIncidence()@pre)"})
	void setProduct(IProduct product);	
	
	// this method returns the procedure associated to that incidence
	@Query
	@Pre({"true"})
	IProcedure getProcedure();
	
	@Pre({"procedure != null # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
		"getClientEmail().equals(getClientEmail()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getDate().equals(getDate()@pre)",
		"getProduct().equals(getProduct()@pre)",
		"getProcedure().equals(procedure)",
		"getReply().equals(getReply()@pre)",
		"getIncidence().equals(getIncidence()@pre)"})
	void setProcedure(IProcedure procedure);
	
	
	// this method returns the date of the replay
	@Query
	@Pre({"true"})
	Date getReplayDate();
	
	@Pre({"date != null # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
		"getClientEmail().equals(getClientEmail()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getDate().equals(getDate()@pre)",
		"getProduct().equals(getProduct()@pre)",
		"getProcedure().equals(getProcedure()@pre)",
		"getReplayDate().equals(date)",
		"getIncidence().equals(getIncidence()@pre)"})
	void setReplayDate(Date date);
	
	
	// this method returns the description of the replay
	@Query
	@Pre({"true"})
	String getReplayDescription();
	
	@Pre({"des != null # IllegalArgumentException", "des != \"\" # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
		"getClientEmail().equals(getClientEmail()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getDate().equals(getDate()@pre)",
		"getProduct().equals(getProduct()@pre)",
		"getProcedure().equals(getProcedure()@pre)",
		"getReplayDescription().equals(des)",
		"getIncidence().equals(getIncidence()@pre)"})
	void setReplayDescription(String des);
	
	// this method returns the mark of the incidence voted by the client
	@Query
	@Pre({"true"})
	Integer getReplayMark();
	
	@Pre({"note != null # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
		"getClientEmail().equals(getClientEmail()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getDate().equals(getDate()@pre)",
		"getProduct().equals(getProduct()@pre)",
		"getProcedure().equals(getProcedure()@pre)",
		"getReplayMark().equals(note)",
		"getIncidence().equals(getIncidence()@pre)"})
	void setReplayMark(Integer note);
	
	// this method returns the incidence associated to that incidence
	@Query
	@Pre({"true"})
	IIncidence getIncidence();
	
	@Pre({"incidence != null # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
		"getClientEmail().equals(getClientEmail()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getDate().equals(getDate()@pre)",
		"getProduct().equals(getProduct()@pre)",
		"getProcedure().equals(getProcedure()@pre)",
		"getReply().equals(getReply()@pre",
		"getIncidence().equals(incidence)"})
	void setIncidence(IIncidence incidence);
	
	// this method returns the incidence associated to that incidence
	@Query
	@Pre({"true"})
	ITechnical getTechncail();
	
	@Pre({"technical != null # IllegalArgumentException"})
	@Pos({"getClientName().equals(getClientName()@pre)", 
		"getClientEmail().equals(getClientEmail()@pre)",
		"getDescription().equals(getDescription()@pre)",
		"getDate().equals(getDate()@pre)",
		"getProduct().equals(getProduct()@pre)",
		"getProcedure().equals(getProcedure()@pre)",
		"getReply().equals(getReply()@pre",
		"getTechnical().equals(technical)"})
	void setTechnical(ITechnical technical);
}
