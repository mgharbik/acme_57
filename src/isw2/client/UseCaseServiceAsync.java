package isw2.client;

import isw2.shared.IncidenceDTO;
import isw2.shared.TechnicalDTO;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UseCaseServiceAsync {

	void deleteTechnicals(ArrayList<String> users,
			AsyncCallback<ArrayList<TechnicalDTO>> callback);
	void getTechnicals(AsyncCallback<ArrayList<TechnicalDTO>> callback);	
	void validateUser(String user, String password,
			AsyncCallback<Boolean> callback);
	void addTechnical(TechnicalDTO t, AsyncCallback<TechnicalDTO> callback);
	void getTechnical(String id, AsyncCallback<TechnicalDTO> callback);
	void updateTechncial(TechnicalDTO t,
			AsyncCallback<TechnicalDTO> callback);

	
	void getIncidences(AsyncCallback<ArrayList<IncidenceDTO>> callback);
	void addIncidence(IncidenceDTO i, AsyncCallback<IncidenceDTO> callback);
	void getIncidenceDetails(Integer id,
			AsyncCallback<ArrayList<String>> callback);
	void evaluateReply(Integer id, Integer mark, AsyncCallback<Void> callback);

}
