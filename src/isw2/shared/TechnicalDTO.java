package isw2.shared;


import java.io.Serializable;
//import java.util.Calendar;

public class TechnicalDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String password;
	private String credentials;
	
	private String dni;
	private String first_name;
	private String sur_name;
	//private Calendar birthday;
	private String email;
	private String address;
	private String phone;

	
	public String getDNI() {
		return dni;
	}

	public void setDNI(String dni) {		
		this.dni = dni;
	}

	public String getFistName() {
		return first_name;
	}

	public void setFistName(String fname) {		
		this.first_name = fname;
	}

	public String getSurName() {
		return sur_name;
	}

	public void setSurName(String sname) {		
		this.sur_name = sname;
	}

//	public Calendar getBirthDay() {
//		return birthday;
//	}
//
//	public void setBirthDay(Calendar bday) {
//		this.birthday = bday;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String usr) {
		this.user = usr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String psw) {
		this.password = psw;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String c) {		
		this.credentials = c;
	}

		
}
