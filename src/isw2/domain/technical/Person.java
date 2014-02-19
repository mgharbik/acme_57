package isw2.domain.technical;

import java.util.Calendar;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Inheritance
@DiscriminatorColumn(name="PERS_TYPE")
public class Person implements IPerson {

	@Id
	private String dni;
	private String first_name;
	private String sur_name;
	private Calendar birthday;
	private String email;
	private String address;
	private String phone;

	
	public Person(String dni, String first_name, String sur_name,
						Calendar birthday, String email, String address,
						String phone){
		if (dni == null || first_name == null || sur_name == null 
			|| birthday == null || email == null || address == null 
			|| phone == null) {
				throw new IllegalArgumentException("Null arguments are not allowed");
		}
		if (dni.equals("") || first_name.equals("") || sur_name.equals("")
			|| email.equals("") || address.equals("") || phone.equals("")) {
				throw new IllegalArgumentException("Empty arguments are not allowed");
		}
		
		this.dni = dni;
		this.first_name = first_name;
		this.sur_name = sur_name;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.phone = phone; 		
	}
	
	public Person() {
	}

	@Override
	public String getDNI() {
		// TODO Auto-generated method stub
		return dni;
	}

	@Override
	public void setDNI(String dni) {
		// TODO Auto-generated method stub
		if (dni == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (dni.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.dni = dni;
	}

	@Override
	public String getFistName() {
		// TODO Auto-generated method stub
		return first_name;
	}

	@Override
	public void setFistName(String fname) {
		// TODO Auto-generated method stub
		if (fname == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (fname.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.first_name = fname;
	}

	@Override
	public String getSurName() {
		// TODO Auto-generated method stub
		return sur_name;
	}

	@Override
	public void setSurName(String sname) {
		// TODO Auto-generated method stub
		if (sname == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (sname.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.sur_name = sname;
	}

	@Override
	public Calendar getBirthDay() {
		// TODO Auto-generated method stub
		return birthday;
	}

	@Override
	public void setBirthDay(Calendar bday) {
		// TODO Auto-generated method stub
		if (bday == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (bday.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.birthday = bday;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		if (email == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (email.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.email = email;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		if (address == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (address.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.address = address;
	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		if (phone == null) {
			throw new IllegalArgumentException("Null argument is not allowed");
		}
		if (phone.equals("")) {
			throw new IllegalArgumentException("Empty argument is not allowed");
		}
		this.phone = phone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
