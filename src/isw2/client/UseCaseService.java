package isw2.client;

import isw2.shared.IncidenceDTO;
import isw2.shared.TechnicalDTO;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface UseCaseService extends RemoteService {
	
	ArrayList<TechnicalDTO> getTechnicals() throws IllegalArgumentException;
	ArrayList<TechnicalDTO> deleteTechnicals(ArrayList<String> users) throws IllegalArgumentException;
	Boolean validateUser(String user, String password) throws IllegalArgumentException;
	
	TechnicalDTO addTechnical(TechnicalDTO t)throws IllegalArgumentException;
	TechnicalDTO getTechnical(String id)throws IllegalArgumentException;
	TechnicalDTO updateTechncial(TechnicalDTO contact)throws IllegalArgumentException;

	ArrayList<IncidenceDTO> getIncidences() throws IllegalArgumentException;
	IncidenceDTO addIncidence(IncidenceDTO i)throws IllegalArgumentException;	
	ArrayList<String> getIncidenceDetails(Integer id) throws IllegalArgumentException;
	void evaluateReply(Integer id, Integer mark) throws IllegalArgumentException;
	
	
	
}
