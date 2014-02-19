package isw2.domain.technical;

import java.util.Set;

import isw2.domain.incidence.IIncidence;
import isw2.domain.procedure.IProcedure;

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

public interface ITechnical extends IPerson {
	
	@Query
	@Pre({"true"})
	String getUser();
	
	@Pre({"usr != null # IllegalArgumentException", 
			"!usr.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(usr)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setUser(String usr);
	
	@Query
	@Pre({"true"})
	String getPassword();
	
	@Pre({"psw != null # IllegalArgumentException", 
			"!psw.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(getUser()@pre)", 
			"getPassword().equals(psw)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setPassword(String psw);
	
	@Query
	@Pre({"true"})
	String getCredentials();
	
	@Pre({"c != null # IllegalArgumentException", "!c.equals(\"\") # IllegalArgumentException"})
	@Pos({"getUser().equals(usr@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(c)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	void setCredentials(String c);
	
	// getProcedures() returns all the procedures assigned to this technical.
	@Query
	@Pre({"true"})
	public Set<IProcedure> getProcedures();

	@Pre({"procedures != null # IllegalArgumentException"})
	@Pos({ "getUser().equals(getUser()@pre)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"isLogged() == isLogged()@pre",
			"getProcedures().equals(procedures)", 
			"getResponses().equals(getResponses()@pre)"})
	public void setProcedures(Set<IProcedure> procedures);

	public IBoss getBoss();
	public void setBoss(IBoss b);
	
	public Set<IIncidence> getIncidences();
	public void setIncidences(Set<IIncidence> incidences);
	
	
	// this method return a boolean if the technical is logged or not
	@Query
	@Pre({"true"})
	public boolean isLogged();

	@Pre({"logged != null # IllegalArgumentException"})
	@Pos({"isLogged() == logged",
			"getUser().equals(usr)", 
			"getPassword().equals(getPassword()@pre)",
			"getCredentials().equals(getCredentials()@pre)",
			"getDNI().equals(getDNI()@pre)",
			"getFistName().equals(getFistName()@pre)",
			"getSurName().equals(getSurName()@pre)",
			"getBirthDay().equals(getBirthDay()@pre)",
			"getEmail().equals(getEmail()@pre)",
			"getAddress().equals(getAddress()@pre)",
			"getPhone().equals(getPhone()@pre)",
			"getProcedures().equals(getProcedures()@pre)",
			"getResponses().equals(getResponses()@pre)"})
	public void setLogged(boolean logged);

}
