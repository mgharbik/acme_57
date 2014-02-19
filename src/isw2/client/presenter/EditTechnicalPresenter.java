package isw2.client.presenter;


import isw2.client.UseCaseServiceAsync;
import isw2.client.event.TechnicalUpdatedEvent;
import isw2.client.view.EditTechnicalView;
import isw2.shared.TechnicalDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class EditTechnicalPresenter implements Presenter{

	private final UseCaseServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	TechnicalDTO t;
	
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
	    
	    void			setDniToSave(String d);
	    void			setFirstNameToSave(String fn);
	    void			setLastNameToSave(String ls);
	    void			setUserNameToSave(String u);
	    void			setPasswordToSave(String p);
	    void			setEmailToSave(String e);
	    void			setPhoneToSave(String t);
	}
	
	public EditTechnicalPresenter(UseCaseServiceAsync rpcService, HandlerManager eventBus, EditTechnicalView editView) {
		this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.display = editView;
	    t = new TechnicalDTO();
	    bind();
	}
	
	public EditTechnicalPresenter(UseCaseServiceAsync rpcService, HandlerManager eventBus, EditTechnicalView editView, String user) {
		this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.display = editView;	
	    bind();
	    
	    rpcService.getTechnical(user, new AsyncCallback<TechnicalDTO>(){
	        public void onSuccess(TechnicalDTO result) {
	          t = result;
//	          EditTechnicalPresenter.this.display.getDniToSave().setValue(t.getDNI());
//	          EditTechnicalPresenter.this.display.getDniToSave().setValue(t.getDNI());
//	          EditTechnicalPresenter.this.display.getDniToSave().setValue(t.getDNI());
//	          EditTechnicalPresenter.this.display.getDniToSave().setValue(t.getDNI());
//	          EditTechnicalPresenter.this.display.getDniToSave().setValue(t.getDNI());
//	          EditTechnicalPresenter.this.display.getDniToSave().setValue(t.getDNI());
//	          EditTechnicalPresenter.this.display.getDniToSave().setValue(t.getDNI());
	          
	          EditTechnicalPresenter.this.display.setDniToSave(t.getDNI());
	          EditTechnicalPresenter.this.display.setFirstNameToSave(t.getFistName());
	          EditTechnicalPresenter.this.display.setLastNameToSave(t.getSurName());
	          EditTechnicalPresenter.this.display.setUserNameToSave(t.getUser());
	          EditTechnicalPresenter.this.display.setPasswordToSave(t.getPassword());
	          EditTechnicalPresenter.this.display.setEmailToSave(t.getEmail());
	          EditTechnicalPresenter.this.display.setPhoneToSave(t.getPhone());
	        }
	        
	        public void onFailure(Throwable caught) {
	          Window.alert("Error retrieving technical");
	        }
	      });
	}
	
	public void bind(){
		display.getSave().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        updateTechnical();
		      }
		    });		
	}
	
	protected void updateTechnical() {
		    t.setDNI(display.getDniToSave());
		    t.setFistName(display.getFirstNameToSave());
		    t.setSurName(display.getLastNameToSave());
		    t.setUser(display.getUserNameToSave());
		    t.setPassword(display.getPasswordToSave());
		    t.setEmail(display.getEmailToSave());
		    t.setPhone(display.getPhoneToSave());
		    
		    rpcService.updateTechncial(t, new AsyncCallback<TechnicalDTO>() {
		        public void onSuccess(TechnicalDTO result) {
		          eventBus.fireEvent(new TechnicalUpdatedEvent());
		        }
		        public void onFailure(Throwable caught) {
		          Window.alert("Error updating contact");
		        }
		    });
	}
	
	
	@Override
	public void go(HasWidgets container) {
	    container.clear();
	    container.add(display.asWidget());
	}

}
