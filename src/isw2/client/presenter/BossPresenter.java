package isw2.client.presenter;

import java.util.ArrayList;
import java.util.List;

import isw2.client.UseCaseServiceAsync;
import isw2.client.event.AddTechnicalEvent;
import isw2.client.event.EditTechnicalEvent;
import isw2.client.view.BossView;
import isw2.shared.TechnicalDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class BossPresenter implements Presenter{

	private List<TechnicalDTO> technicalsDetails;
	
	private final UseCaseServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	
	public interface Display {
		HasClickHandlers getAddButton();
	    HasClickHandlers getDeleteButton();
	    HasClickHandlers getList();
	    void setData(List<String> data);
	    int getClickedRow(ClickEvent event);
	    List<Integer> getSelectedRows();
	    Widget asWidget();
	}
	
	public BossPresenter(UseCaseServiceAsync rpcService, HandlerManager eventBus, BossView bossView) {
		this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.display = bossView;
	}
	
	public void bind(){
	    display.getAddButton().addClickHandler(new ClickHandler() {   
	        public void onClick(ClickEvent event) {
	          eventBus.fireEvent(new AddTechnicalEvent());
	        }
	      });

	      display.getDeleteButton().addClickHandler(new ClickHandler() {   
	        public void onClick(ClickEvent event) {
	          deleteSelectedTechnicals();
	        }
	      });
	      
	      display.getList().addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	          int selectedRow = display.getClickedRow(event);
	          
	          if (selectedRow >= 0) {
	            String user = technicalsDetails.get(selectedRow).getUser();
	            eventBus.fireEvent(new EditTechnicalEvent(user));
	          }
	        }
	      });
	}
	
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		bind();
	    container.clear();
	    container.add(display.asWidget());
	    fetchTechnicalsDetails();
	}
	
	  private void fetchTechnicalsDetails() {
		    rpcService.getTechnicals(new AsyncCallback<ArrayList<TechnicalDTO>>() {
		      public void onSuccess(ArrayList<TechnicalDTO> result) {
		    	  technicalsDetails = result;
		          sortTechnicalDetails();
		          List<String> data = new ArrayList<String>();

		          for (int i = 0; i < result.size(); ++i) {
		            data.add(technicalsDetails.get(i).getUser());
		          }
		          display.setData(data);
		      }
		      
		      public void onFailure(Throwable caught) {
		        Window.alert("Error fetching technical details");
		      }
		    });
	  }
	  
	  public void sortTechnicalDetails() {
		    
		    for (int i = 0; i < technicalsDetails.size(); ++i) {
		      for (int j = 0; j < technicalsDetails.size() - 1; ++j) {
		        if (technicalsDetails.get(j).getUser().compareToIgnoreCase(technicalsDetails.get(j + 1).getUser()) >= 0) {
		        	TechnicalDTO tmp = technicalsDetails.get(j);
		          technicalsDetails.set(j, technicalsDetails.get(j + 1));
		          technicalsDetails.set(j + 1, tmp);
		        }
		      }
		    }
	  }
	  
	  private void deleteSelectedTechnicals() {
		  List<Integer> selectedRows = display.getSelectedRows();
		  if(selectedRows.size()==0)
			  Window.alert("no technical is selected");
		  
		  ArrayList<String> ids = new ArrayList<String>();
		    
		  for (int i = 0; i < selectedRows.size(); ++i) {
			  ids.add(technicalsDetails.get(selectedRows.get(i)).getUser());
		  }
		  
		  rpcService.deleteTechnicals(ids, new AsyncCallback<ArrayList<TechnicalDTO>>() {
			  public void onSuccess(ArrayList<TechnicalDTO> result) {
				  technicalsDetails = result;
				  sortTechnicalDetails();
			      List<String> data = new ArrayList<String>();
	
			      for (int i = 0; i < result.size(); ++i) {
			    	  data.add(technicalsDetails.get(i).getUser());
			      }
			        
			      display.setData(data);
			  }
			      
			  public void onFailure(Throwable caught) {
				  Window.alert("Error deleting selected technicals");
			  }
		  });
	}
	  
}
