package isw2.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import isw2.client.presenter.AddIncidencePresenter;
import com.google.gwt.user.client.ui.TextBox;

public class AddIncidenceView extends Composite implements AddIncidencePresenter.Display{
	
	private Button saveButton;
	private TextBox clientNameTextBox;
	private TextBox client_emailTextBox;
	private TextBox sur_nameTextBox;
	private TextBox userTextBox;
	
	public AddIncidenceView(){
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setHeight("492px");
		
		Label lblStoreATechnical = new Label("Store an Incidence");
		verticalPanel.add(lblStoreATechnical);
		lblStoreATechnical.setHeight("27px");
		
		HorizontalPanel dnihorizontalPanel = new HorizontalPanel();
		verticalPanel.add(dnihorizontalPanel);
		dnihorizontalPanel.setWidth("450px");
		
		Label lblClientName = new Label("Client Name:");
		lblClientName.setStyleName("gwt-DialogBox");
		dnihorizontalPanel.add(lblClientName);
		lblClientName.setSize("167px", "31px");
		
		clientNameTextBox = new TextBox();
		dnihorizontalPanel.add(clientNameTextBox);
		clientNameTextBox.setWidth("274px");
		
		
		
		HorizontalPanel first_namehorizontalPanel = new HorizontalPanel();
		verticalPanel.add(first_namehorizontalPanel);
		first_namehorizontalPanel.setWidth("450px");
		
		Label lblclient_email = new Label("Client E-mail:");
		lblclient_email.setStyleName("gwt-DialogBox");
		first_namehorizontalPanel.add(lblclient_email);
		lblclient_email.setSize("167px", "31px");
		
		client_emailTextBox = new TextBox();
		first_namehorizontalPanel.add(client_emailTextBox);
		client_emailTextBox.setWidth("274px");
		
		
		HorizontalPanel sur_namehorizontalPanel = new HorizontalPanel();
		verticalPanel.add(sur_namehorizontalPanel);
		sur_namehorizontalPanel.setWidth("450px");
		
		Label lbldescription = new Label("Description:");
		lbldescription.setStyleName("gwt-DialogBox");
		sur_namehorizontalPanel.add(lbldescription);
		lbldescription.setSize("167px", "31px");
		
		sur_nameTextBox = new TextBox();
		sur_namehorizontalPanel.add(sur_nameTextBox);
		sur_nameTextBox.setWidth("274px");
		
		
		HorizontalPanel userhorizontalPanel = new HorizontalPanel();
		verticalPanel.add(userhorizontalPanel);
		userhorizontalPanel.setWidth("450px");
		
		Label lblproduct = new Label("Product:");
		lblproduct.setStyleName("gwt-DialogBox");
		userhorizontalPanel.add(lblproduct);
		lblproduct.setSize("167px", "31px");
		
		userTextBox = new TextBox();
		userhorizontalPanel.add(userTextBox);
		userTextBox.setWidth("274px");
		
		saveButton = new Button("Save");
		verticalPanel.add(saveButton);
		
		
		/*
			private String credentials;
			private String address;
		 */
	}

	
	public Widget asWidget() {
	    return this;
	  }


	@Override
	public HasClickHandlers getSave() {
		// TODO Auto-generated method stub
		return saveButton;
	}


	@Override
	public String getDniToSave() {
		// TODO Auto-generated method stub
		return clientNameTextBox.getText();
	}


	@Override
	public String getFirstNameToSave() {
		// TODO Auto-generated method stub
		return client_emailTextBox.getText();
	}


	@Override
	public String getLastNameToSave() {
		// TODO Auto-generated method stub
		return sur_nameTextBox.getText();
	}


	@Override
	public String getUserNameToSave() {
		// TODO Auto-generated method stub
		return userTextBox.getText();
	}



	
}
