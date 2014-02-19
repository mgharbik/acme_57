package isw2.domain.technical;

import java.util.Calendar;

import tdg.contract.semanticAnnotations.Pre;
import tdg.contract.semanticAnnotations.Pos;
import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;
import tdg.contract.semanticAnnotations.Query;

@Init({"getProcedures().isEmpty()", "getResponses().isEmpty()", 
		"isLogged()==false", "getResponses().size()==0"})
@Inv({"getProcedures().size()>=0", 
		"getResponses().size()>=0",
		"getProcedures().size()<=INTEGER.MAX_VALUE",
		"getResponses().size()<=INTEGER.MAX_VALUE"})

public interface IPerson {
	

	@Query
	@Pre({"true"})
	String getDNI();
	
	@Pre({"dni != null # IllegalArgumentException", "!dni.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(getUser()@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(dni)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setDNI(String dni);
	
	@Query
	@Pre({"true"})
	String getFistName();
	
	@Pre({"fname != null  # IllegalArgumentException",
			"!fname.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(getUser()@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(fname)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setFistName(String fname);
	
	@Query
	@Pre({"true"})
	String getSurName();
	
	@Pre({"sname != null # IllegalArgumentException", "!sname.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(getUser()@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(sname)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setSurName(String sname);
	
	@Query
	@Pre({"true"})
	Calendar getBirthDay();
	
	@Pre({"dbay != null # IllegalArgumentException"})
	@Pos({"getUser().equals(getUser()@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(dbay)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setBirthDay(Calendar dbay);
	
	@Query
	@Pre({"true"})
	String getEmail();
	
	@Pre({"email != null # IllegalArgumentException", "!email.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(getUser()@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(email)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setEmail(String email);
	
	@Query
	@Pre({"true"})
	String getAddress();
	
	@Pre({"address != null # IllegalArgumentException", "!address.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(getUser()@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(address)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setAddress(String address);
	
	@Query
	@Pre({"true"})
	String getPhone();
	
	@Pre({"phone != null # IllegalArgumentException", "!phone.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(getUser()@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(phone)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setPhone(String phone);

}
