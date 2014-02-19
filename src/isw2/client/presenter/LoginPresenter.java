package isw2.client.presenter;

import isw2.client.UseCaseServiceAsync;
import isw2.client.event.LoginEvent;
import isw2.client.view.LoginView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class LoginPresenter implements Presenter {

	private final UseCaseServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	
	public interface Display {
		Widget asWidget();
	    HasClickHandlers getLogin();
	    String getLoginName();
	    String getLoginPass();	    
	  }
	
	public LoginPresenter(UseCaseServiceAsync rpcService, HandlerManager eventBus, LoginView loginView) {
		this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.display = loginView;
	    
		// TODO Auto-generated constructor stub
	}
	
	public void bind(){
		display.getLogin().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        checkLogin();
		      }
		    });
	}

	protected void checkLogin() {
		String user = display.getLoginName();
		String pass = display.getLoginPass();
		rpcService.validateUser(user, pass, new AsyncCallback<Boolean>() {
		      public void onSuccess(Boolean result) {
		    	  if (result){
		    		  eventBus.fireEvent(new LoginEvent());
		    	  }else{
		    		  Window.alert("User not permitted");  
		    	  }
		          //users = result;   
		          //display.setData(result);
		      }
		      public void onFailure(Throwable caught) {
		        Window.alert("Error fetching contact details ("+caught.getMessage()+")");
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
