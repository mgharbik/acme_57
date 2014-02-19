package isw2.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import isw2.client.presenter.IndexPresenter;

public class IndexView extends Composite implements IndexPresenter.Display{

	private Button clientViewButton;
	private Button TechnicalViewButton;
	private Button BossViewButton;
	
	public IndexView(){
		DecoratorPanel contentTableDecorator = new DecoratorPanel();
		initWidget(contentTableDecorator);
		contentTableDecorator.setSize("", "");
	    
	    VerticalPanel contentPanel = new VerticalPanel();
	    Label label = new Label("ACME");
	    
	    HorizontalPanel menuPanel = new HorizontalPanel();
	    clientViewButton = new Button("Client View");
	    menuPanel.add(clientViewButton);	    
	    clientViewButton.setWidth("206px");
	    TechnicalViewButton = new Button("Technical View");
	    menuPanel.add(TechnicalViewButton);
	    TechnicalViewButton.setWidth("192px");
	    BossViewButton = new Button("Boss View");
	    menuPanel.add(BossViewButton);
	    BossViewButton.setWidth("175px");
	    
	    
	    contentPanel.add(label);
	    label.setWidth("568px");
	    contentPanel.add(menuPanel);
	    
	    
	    contentTableDecorator.add(contentPanel);
	    contentPanel.setHeight("88px");
	}

	@Override
	public HasClickHandlers getClientView() {
		// TODO Auto-generated method stub
		return clientViewButton;
	}

	@Override
	public HasClickHandlers getTechnicalView() {
		// TODO Auto-generated method stub
		return TechnicalViewButton;
	}

	@Override
	public HasClickHandlers getBossView() {
		// TODO Auto-generated method stub
		return BossViewButton;
	}	
	
	public Widget asWidget() {
	    return this;
	  }
	
	
}
