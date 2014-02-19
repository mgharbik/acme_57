package isw2.domain.technical;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import isw2.domain.incidence.IIncidence;
import isw2.domain.incidence.Incidence;
import isw2.domain.procedure.IProcedure;
import isw2.domain.procedure.Proceduree;

@Entity
@DiscriminatorValue("TECHNICAL")
public class Technical extends Person implements ITechnical {

	//@Id
	private String user;
	private String password;
	private String credentials;
	
	@ManyToMany(targetEntity = Proceduree.class)
	@Column(length = 10)
	private Set<IProcedure> procedures = new HashSet<IProcedure>();
	
	@OneToMany(mappedBy = "technical", targetEntity = Incidence.class)
	private Set<IIncidence> incidences = new HashSet<IIncidence>();
	
	@ManyToOne(targetEntity = Boss.class)
	private IBoss boss;
	
	private boolean logged;
	
	
	public Technical(String user, String password, String credentials,
						String dni, String first_name, String sur_name,
						Calendar birthday, String email, String address,
						String phone, Set<IProcedure> procedures){
		super(dni, first_name, sur_name, birthday, email, address, phone);
		
		if (user == null || password == null || credentials == null 
			|| dni == null || first_name == null || sur_name == null 
			|| birthday == null || email == null || address == null 
			|| phone == null) {
				throw new IllegalArgumentException("Null arguments are not allowed");
		}
		if (user.equals("") || password.equals("") || credentials.equals("")
			|| dni.equals("") || first_name.equals("") || sur_name.equals("")
			|| email.equals("") || address.equals("") || phone.equals("")) {
				throw new IllegalArgumentException("Empty arguments are not allowed");
		}
		
		this.user = user;
		this.password = password;  
		this.credentials = credentials;
		//this.procedures = procedures;
		this.logged = false;
		
	}
	
	public Technical() {
	}

	@Override
	public String getUser() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public void setUser(String usr) {
		// TODO Auto-generated method stub
		if (usr == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (usr.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.user = usr;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public void setPassword(String psw) {
		// TODO Auto-generated method stub
		if (psw == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (psw.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.password = psw;
	}

	@Override
	public String getCredentials() {
		// TODO Auto-generated method stub
		return credentials;
	}

	@Override
	public void setCredentials(String c) {
		// TODO Auto-generated method stub
		if (c == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (c.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.user = c;
	}

	
	@Override
	public Set<IProcedure> getProcedures() {
		// TODO Auto-generated method stub
		return procedures;
	}

	@Override
	public void setProcedures(Set<IProcedure> procedures) {
		// TODO Auto-generated method stub
		if (procedures == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		this.procedures = procedures;
	}

	@Override
	public boolean isLogged() {
		// TODO Auto-generated method stub
		return logged;
	}

	@Override
	public void setLogged(boolean logged) {
		// TODO Auto-generated method stub
		this.logged =logged;
	}

	@Override
	public Set<IIncidence> getIncidences() {
		// TODO Auto-generated method stub
		return incidences;
	}

	@Override
	public void setIncidences(Set<IIncidence> incidences) {
		// TODO Auto-generated method stub
		this.incidences = incidences;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Technical))
			return false;
		Technical other = (Technical) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public IBoss getBoss() {
		// TODO Auto-generated method stub
		return boss;
	}

	@Override
	public void setBoss(IBoss b) {
		this.boss = b;
	}


}
