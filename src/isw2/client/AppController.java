package isw2.client;

import isw2.client.event.AddIncidenceEvent;
import isw2.client.event.AddIncidenceEventHandler;
import isw2.client.event.AddTechnicalEvent;
import isw2.client.event.AddTechnicalEventHandler;
import isw2.client.event.BossViewEvent;
import isw2.client.event.BossViewEventHandler;
import isw2.client.event.ClientViewEvent;
import isw2.client.event.ClientViewEventHandler;
import isw2.client.event.EditTechnicalEvent;
import isw2.client.event.EditTechnicalEventHandler;
import isw2.client.event.LoginEvent;
import isw2.client.event.LoginEventHandler;
import isw2.client.event.TechnicalUpdatedEvent;
import isw2.client.event.TechnicalUpdatedEventHandler;
import isw2.client.event.TechnicalViewEvent;
import isw2.client.event.TechnicalViewEventHandler;
import isw2.client.presenter.*;
import isw2.client.view.*;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.History;
//import com.google.gwt.user.client.Window;

public class AppController implements Presenter, ValueChangeHandler<String> {

	private final HandlerManager eventBus;
	private final UseCaseServiceAsync rpcService; 
	private HasWidgets container;
	 
	public AppController(UseCaseServiceAsync rpcService, HandlerManager eventBus) {
	    this.eventBus = eventBus;
	    this.rpcService = rpcService;
	    bind();
	}
	  
	private void bind() {
	    History.addValueChangeHandler(this);
	    
	    eventBus.addHandler(ClientViewEvent.TYPE,
		        new ClientViewEventHandler() {
					public void onClientView(ClientViewEvent event) {
						doCientView();
					}
		        });  
	    
	    eventBus.addHandler(TechnicalViewEvent.TYPE,
	        new TechnicalViewEventHandler() {
				public void onTechnicalView(TechnicalViewEvent event) {
					doLogin();
				}
	        }); 
	    
	    eventBus.addHandler(BossViewEvent.TYPE,
		        new BossViewEventHandler() {
		          public void onBossView(BossViewEvent event) {
		        	  doBossView();
		          }
		        }); 
	    
	    eventBus.addHandler(AddTechnicalEvent.TYPE,
		        new AddTechnicalEventHandler() {
		          public void onAddTechnical(AddTechnicalEvent event) {
		        	  doAddTechnicalView();
		          }
		        });
	    eventBus.addHandler(EditTechnicalEvent.TYPE,
		        new EditTechnicalEventHandler() {
		          public void onEditTechnical(EditTechnicalEvent event) {
		        	  doEditTechnicalView(event.getId());
		          }
		        }); 
	    
	    eventBus.addHandler(TechnicalUpdatedEvent.TYPE,
		        new TechnicalUpdatedEventHandler() {
		          public void onTechnicalUpdated(TechnicalUpdatedEvent event) {
		        	  doTechnicalupdated();
		          }
		        }); 
	    
	    eventBus.addHandler(LoginEvent.TYPE,
		        new LoginEventHandler() {
		          public void onLogin(LoginEvent event) {
		            doLoginOk();
		          }
		        }); 
	    
	    eventBus.addHandler(AddIncidenceEvent.TYPE,
		        new AddIncidenceEventHandler() {
		          public void onAddIncidence(AddIncidenceEvent event) {
		            doAddIncidenceView();
		          }
		        }); 
	 }
	  
	private void doLogin() {
	    History.newItem("login");
	}
	private void doCientView() {
	    History.newItem("client");
	}
	private void doBossView() {
	    History.newItem("boss");
	}
	private void doAddTechnicalView() {
	    History.newItem("addtechnical");
	}
	private void doEditTechnicalView(String id) {
	    History.newItem("edittechnical", false);
	    Presenter presenter = new EditTechnicalPresenter(rpcService, eventBus, new EditTechnicalView(), id);
	    presenter.go(container);
	}
	private void doTechnicalupdated() {
	    History.newItem("boss");
	}
	private void doLoginOk() {
	    History.newItem("technical");
	}
	private void doAddIncidenceView() {
	    History.newItem("addincidence");
	}
	
	public void go(final HasWidgets container) {
	    this.container = container;
	    
	    if ("".equals(History.getToken())) {
	      History.newItem("index");
	    }
	    else {
	      History.fireCurrentHistoryState();
	    }
	}

	public void onValueChange(ValueChangeEvent<String> event) {
	    String token = event.getValue();
	    
	    if (token != null) {
		      Presenter presenter = null;
		      
		      if (token.equals("login")) {
		    	presenter = new LoginPresenter(rpcService, eventBus, new LoginView());
		      }
		      else if (token.equals("index")) {
		    	presenter = new IndexPresenter(rpcService, eventBus, new IndexView());
		      }
		      else if (token.equals("boss")) {
			    	presenter = new BossPresenter(rpcService, eventBus, new BossView());
			  }
		      else if (token.equals("client")) {
			    	presenter = new ClientPresenter(rpcService, eventBus, new ClientView());
			  }
		      else if (token.equals("addtechnical")) {
			    	presenter = new AddTechnicalPresenter(rpcService, eventBus, new AddTechnicalView());
			  }
		      else if (token.equals("edittechnical")) {
			    	presenter = new EditTechnicalPresenter(rpcService, eventBus, new EditTechnicalView());
			  }
		      else if (token.equals("technical")) {
			    	presenter = new TechnicalPresenter(rpcService, eventBus, new TechnicalView());
			  }
		      else if (token.equals("addincidence")) {
			    	presenter = new AddIncidencePresenter(rpcService, eventBus, new AddIncidenceView());
			  }
		      
		      if (presenter != null) {
		    	  presenter.go(container);
		      }
	    }
	} 

}
