package isw2.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import isw2.client.presenter.AddTechnicalPresenter;
import com.google.gwt.user.client.ui.TextBox;

public class AddTechnicalView extends Composite implements AddTechnicalPresenter.Display{
	
	private Button saveButton;
	private TextBox dniTextBox;
	private TextBox first_nameTextBox;
	private TextBox sur_nameTextBox;
	private TextBox userTextBox;
	private TextBox passwordTextBox;
	private TextBox emailTextBox;
	private TextBox phoneTextBox;
	
	public AddTechnicalView(){
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setHeight("492px");
		
		Label lblStoreATechnical = new Label("Store a Technical");
		verticalPanel.add(lblStoreATechnical);
		lblStoreATechnical.setHeight("27px");
		
		HorizontalPanel dnihorizontalPanel = new HorizontalPanel();
		verticalPanel.add(dnihorizontalPanel);
		dnihorizontalPanel.setWidth("450px");
		
		Label lblDni = new Label("DNI:");
		lblDni.setStyleName("gwt-DialogBox");
		dnihorizontalPanel.add(lblDni);
		lblDni.setSize("167px", "31px");
		
		dniTextBox = new TextBox();
		dnihorizontalPanel.add(dniTextBox);
		dniTextBox.setWidth("274px");
		
		
		
		HorizontalPanel first_namehorizontalPanel = new HorizontalPanel();
		verticalPanel.add(first_namehorizontalPanel);
		first_namehorizontalPanel.setWidth("450px");
		
		Label lblfirst_name = new Label("First Name:");
		lblfirst_name.setStyleName("gwt-DialogBox");
		first_namehorizontalPanel.add(lblfirst_name);
		lblfirst_name.setSize("167px", "31px");
		
		first_nameTextBox = new TextBox();
		first_namehorizontalPanel.add(first_nameTextBox);
		first_nameTextBox.setWidth("274px");
		
		
		HorizontalPanel sur_namehorizontalPanel = new HorizontalPanel();
		verticalPanel.add(sur_namehorizontalPanel);
		sur_namehorizontalPanel.setWidth("450px");
		
		Label lblsur_name = new Label("Last Name:");
		lblsur_name.setStyleName("gwt-DialogBox");
		sur_namehorizontalPanel.add(lblsur_name);
		lblsur_name.setSize("167px", "31px");
		
		sur_nameTextBox = new TextBox();
		sur_namehorizontalPanel.add(sur_nameTextBox);
		sur_nameTextBox.setWidth("274px");
		
		
		HorizontalPanel userhorizontalPanel = new HorizontalPanel();
		verticalPanel.add(userhorizontalPanel);
		userhorizontalPanel.setWidth("450px");
		
		Label lbluser = new Label("User Name:");
		lbluser.setStyleName("gwt-DialogBox");
		userhorizontalPanel.add(lbluser);
		lbluser.setSize("167px", "31px");
		
		userTextBox = new TextBox();
		userhorizontalPanel.add(userTextBox);
		userTextBox.setWidth("274px");
		
		
		HorizontalPanel passwordhorizontalPanel = new HorizontalPanel();
		verticalPanel.add(passwordhorizontalPanel);
		passwordhorizontalPanel.setWidth("450px");
		
		Label lblpassword = new Label("Password:");
		lblpassword.setStyleName("gwt-DialogBox");
		passwordhorizontalPanel.add(lblpassword);
		lblpassword.setSize("167px", "31px");
		
		passwordTextBox = new TextBox();
		passwordhorizontalPanel.add(passwordTextBox);
		passwordTextBox.setWidth("274px");
		
		
		HorizontalPanel emailhorizontalPanel = new HorizontalPanel();
		verticalPanel.add(emailhorizontalPanel);
		emailhorizontalPanel.setWidth("450px");
		
		Label lblemail = new Label("Email:");
		lblemail.setStyleName("gwt-DialogBox");
		emailhorizontalPanel.add(lblemail);
		lblemail.setSize("167px", "31px");
		
		emailTextBox = new TextBox();
		emailhorizontalPanel.add(emailTextBox);
		emailTextBox.setWidth("274px");
		

		HorizontalPanel phonehorizontalPanel = new HorizontalPanel();
		verticalPanel.add(phonehorizontalPanel);
		phonehorizontalPanel.setWidth("450px");
		
		Label lblphone = new Label("Phone:");
		lblphone.setStyleName("gwt-DialogBox");
		phonehorizontalPanel.add(lblphone);
		lblphone.setSize("167px", "31px");
		
		phoneTextBox = new TextBox();
		phonehorizontalPanel.add(phoneTextBox);
		phoneTextBox.setWidth("274px");
		
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
		return dniTextBox.getText();
	}


	@Override
	public String getFirstNameToSave() {
		// TODO Auto-generated method stub
		return first_nameTextBox.getText();
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


	@Override
	public String getPasswordToSave() {
		// TODO Auto-generated method stub
		return passwordTextBox.getText();
	}


	@Override
	public String getEmailToSave() {
		// TODO Auto-generated method stub
		return emailTextBox.getText();
	}


	@Override
	public String getPhoneToSave() {
		// TODO Auto-generated method stub
		return phoneTextBox.getText();
	}
	
	
}
