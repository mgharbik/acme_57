package isw2.client.presenter;

import isw2.client.UseCaseServiceAsync;
import isw2.client.event.BossViewEvent;
import isw2.client.event.ClientViewEvent;
import isw2.client.event.TechnicalViewEvent;
import isw2.client.view.IndexView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class IndexPresenter implements Presenter{

	private final UseCaseServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	
	public interface Display {
		Widget asWidget();
		public HasClickHandlers getClientView();
		public HasClickHandlers getTechnicalView();
		public HasClickHandlers getBossView();
	}
	
	public IndexPresenter(UseCaseServiceAsync rpcService, HandlerManager eventBus, IndexView indexView) {
		this.rpcService = rpcService;
	    this.eventBus = eventBus;
	    this.display = indexView;
	}
	
	public void bind(){
		display.getClientView().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		    	  eventBus.fireEvent(new ClientViewEvent());
		      }
		    });
		
		display.getTechnicalView().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		    	  eventBus.fireEvent(new TechnicalViewEvent());
		      }
		    });
		
		display.getBossView().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		    	  eventBus.fireEvent(new BossViewEvent());
		      }
		    });
	}
	
	
	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		bind();
	    container.clear();
	    container.add(display.asWidget());
	}

}
