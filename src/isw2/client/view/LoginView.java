package isw2.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import isw2.client.presenter.LoginPresenter;

public class LoginView extends Composite implements LoginPresenter.Display{

	private Button loginButton;
	private TextBox loginName;
	private PasswordTextBox loginPass;
	
	public LoginView(){
		DecoratorPanel contentTableDecorator = new DecoratorPanel();

		initWidget(contentTableDecorator);
		
		contentTableDecorator.setWidth("100%");
	    contentTableDecorator.setWidth("18em");
	    
	    FlexTable loginTable = new FlexTable();
	    loginTable.setCellSpacing(0);
	    loginTable.setWidth("100%");
	    loginTable.addStyleName("contacts-ListContainer");
	    loginTable.getColumnFormatter().addStyleName(1, "add-contact-input");
	    loginName = new TextBox();
	    loginPass = new PasswordTextBox();
	    
	    VerticalPanel contentDetailsPanel = new VerticalPanel();
	    loginTable.setWidget(0, 0, new Label("Login"));
	    loginTable.setWidget(0, 1, loginName);
	    loginTable.setWidget(1, 0, new Label("Pass"));
	    loginTable.setWidget(1, 1, loginPass);
	    loginName.setFocus(true);
	    contentDetailsPanel.add(loginTable);
	    
	    HorizontalPanel menuPanel = new HorizontalPanel();
	    loginButton = new Button("Login");
	    menuPanel.add(loginButton);
	    
	    // Create the contacts list
	    //	    
	    contentDetailsPanel.add(menuPanel);
	    
	    contentTableDecorator.add(contentDetailsPanel);

	}

	@Override
	public HasClickHandlers getLogin() {
		return loginButton;
	}

	@Override
	public String getLoginName() {
		// TODO Auto-generated method stub
		return loginName.getText();
		
	}

	@Override
	public String getLoginPass() {
		// TODO Auto-generated method stub
		return loginPass.getText();
	}
	
	
	
	
}
