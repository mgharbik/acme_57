package isw2.domain.technical;

import java.util.Set;

import tdg.contract.semanticAnnotations.Init;
import tdg.contract.semanticAnnotations.Inv;

@Init({"true"})
@Inv({"true"})

public interface IBoss extends IPerson{
	
	public Set<ITechnical> getTechnicals();
	public void setTechnicals(Set<ITechnical> ts);
	
}
