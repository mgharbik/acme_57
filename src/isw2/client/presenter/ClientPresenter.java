package isw2.client.presenter;

import java.util.ArrayList;

import isw2.client.UseCaseServiceAsync;
import isw2.client.event.AddIncidenceEvent;
import isw2.client.event.DetailsIncidenceEvent;
import isw2.client.view.ClientView;
import isw2.shared.IncidenceDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ClientPresenter implements Presenter{

	private ArrayList<IncidenceDTO> incidencesDetails;
	
	private final UseCaseServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	
	public interface Display {
		HasClickHandlers getAddButton();
		HasClickHandlers getDetailsButton();
		HasClickHandlers getEvaluateButton();
	    HasClickHandlers getList();
	    void setData(ArrayList<ArrayList<String>> data);
	    int getClickedRow(ClickEvent event);
	    Widget asWidget();
	}
	
	public ClientPresenter(UseCaseServiceAsync rpcService, HandlerManager eventBus, ClientView clientView) {
		this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.display = clientView;
	}
	
	public void bind(){
	    display.getAddButton().addClickHandler(new ClickHandler() {   
	        public void onClick(ClickEvent event) {
	          eventBus.fireEvent(new AddIncidenceEvent());
	        }
	      });

	    display.getDetailsButton().addClickHandler(new ClickHandler() {   
	        public void onClick(ClickEvent event) {
	          eventBus.fireEvent(new DetailsIncidenceEvent());
	        }
	      });
	    
//	    display.getEvaluateButton().addClickHandler(new ClickHandler() {   
//	        public void onClick(ClickEvent event) {
//	          eventBus.fireEvent(new EvaluateIncidenceEvent());
//	        }
//	      });
	}
	
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		bind();
	    container.clear();
	    container.add(display.asWidget());
	    fetchIncidences();
	}
	
	  private void fetchIncidences() {
		    rpcService.getIncidences(new AsyncCallback<ArrayList<IncidenceDTO>>() {
		      public void onSuccess(ArrayList<IncidenceDTO> result) {
		    	  incidencesDetails = result;
		          sortIncidenceDetails();
		          ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

		          for (int i = 0; i < result.size(); ++i) {
		        	  ArrayList<String> unai = new ArrayList<String>();
		        	  unai.add(incidencesDetails.get(i).getID().toString());
		        	  unai.add(incidencesDetails.get(i).getClientName());
		        	  unai.add(incidencesDetails.get(i).getClientEmail());
		        	  unai.add(incidencesDetails.get(i).getDate().toString());
		        	  unai.add(incidencesDetails.get(i).getProduct());
		        	  unai.add(incidencesDetails.get(i).getProcedure());
		        	  
		        	  Integer mark = incidencesDetails.get(i).getReplayMark();
		        	  if(mark!=null)
		        		  unai.add(mark.toString());
		        	  
		            data.add(unai);
		          }
		          display.setData(data);
		      }
		      
		      public void onFailure(Throwable caught) {
		        Window.alert("Error fetching incidences details");
		      }
		    });
	  }
	  
	  public void sortIncidenceDetails() {
		    
		    for (int i = 0; i < incidencesDetails.size(); ++i) {
		      for (int j = 0; j < incidencesDetails.size() - 1; ++j) {
		        if (incidencesDetails.get(j).getID().toString().compareToIgnoreCase(incidencesDetails.get(j + 1).getID().toString()) >= 0) {
		        	IncidenceDTO tmp = incidencesDetails.get(j);
		        	incidencesDetails.set(j, incidencesDetails.get(j + 1));
		        	incidencesDetails.set(j + 1, tmp);
		        }
		      }
		    }
	  }
	  
	  
	  
}
