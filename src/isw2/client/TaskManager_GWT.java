package isw2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import isw2.client.AppController;
import isw2.client.UseCaseService;
import isw2.client.UseCaseServiceAsync;

import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TaskManager_GWT implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		UseCaseServiceAsync rpcService = GWT.create(UseCaseService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(rpcService, eventBus);
		appViewer.go(RootPanel.get());
		
	}
}
