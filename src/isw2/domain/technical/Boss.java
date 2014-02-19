package isw2.domain.technical;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("BOSS")
public class Boss extends Person implements IBoss {
	
	@OneToMany(mappedBy = "boss", targetEntity = Technical.class)
	private Set<ITechnical> technicals;
	
	public Boss() {
		super();
	}

	@Override
	public Set<ITechnical> getTechnicals() {
		// TODO Auto-generated method stub
		return technicals;
	}

	@Override
	public void setTechnicals(Set<ITechnical> ts) {
		this.technicals = ts;
	}
	
}
