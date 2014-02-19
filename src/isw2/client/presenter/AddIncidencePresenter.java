package isw2.client.presenter;

import isw2.client.UseCaseServiceAsync;
import isw2.client.event.BossViewEvent;
import isw2.client.view.AddIncidenceView;
import isw2.client.view.AddTechnicalView;
import isw2.shared.TechnicalDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class AddIncidencePresenter implements Presenter{

	private final UseCaseServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	
	public interface Display {
		Widget asWidget();
		HasClickHandlers getSave();
	    String			getDniToSave();
	    String			getFirstNameToSave();
	    String			getLastNameToSave();
	    String			getUserNameToSave();
	    String			getPasswordToSave();
	    String			getEmailToSave();
	    String			getPhoneToSave();
	}
	
	public AddIncidencePresenter(UseCaseServiceAsync rpcService, HandlerManager eventBus, AddIncidenceView addView) {
		this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.display = addView;	    
	}
	
	public void bind(){
		display.getSave().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        addTechnical();
		      }
		    });		
	}
	
	protected void addTechnical() {
		String dni = display.getDniToSave();
		String fn = display.getFirstNameToSave();
		String ln = display.getLastNameToSave();
		String u = display.getUserNameToSave();
		String p = display.getPasswordToSave();
		String e = display.getEmailToSave();
		String t = display.getPhoneToSave();
		
		TechnicalDTO tec = new TechnicalDTO();
		
		tec.setUser(u);
		tec.setPassword(p);
		tec.setDNI(dni);
		tec.setFistName(fn);
		tec.setSurName(ln);
		tec.setEmail(e);
		tec.setPhone(t);
		
		rpcService.addTechnical(tec, new AsyncCallback<TechnicalDTO>() {
		      public void onSuccess(TechnicalDTO result) {
		    	  eventBus.fireEvent(new BossViewEvent());		    	  
		      }
		      public void onFailure(Throwable caught) {
		        Window.alert("Error fetching technicals details ("+caught.getMessage()+")");
		      }
		    });
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		bind();
	    container.clear();
	    container.add(display.asWidget());
	}

}
