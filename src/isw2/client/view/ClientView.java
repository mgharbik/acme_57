package isw2.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

import isw2.client.presenter.ClientPresenter;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.ListBox;

public class ClientView extends Composite implements ClientPresenter.Display{
	
	private final Button btnStoreNewIncidence;
	private final Button btnDetailsIncidence;
	private final Button btnevaluate;
	private final FlexTable listIncidences;
	
	public ClientView(){
		
		DecoratorPanel contentTableDecorator = new DecoratorPanel();
		initWidget(contentTableDecorator);
		contentTableDecorator.setSize("823px", "");
		
		VerticalPanel mainPanel = new VerticalPanel();
		mainPanel.setSize("896px", "467px");
		
		btnStoreNewIncidence = new Button("Store New Incidence");
		mainPanel.add(btnStoreNewIncidence);
		
		Label lblAllTheIncidences = new Label("Incidences' List :");
		mainPanel.add(lblAllTheIncidences);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		mainPanel.add(horizontalPanel);
		horizontalPanel.setWidth("585px");
		
		listIncidences = new FlexTable();
		horizontalPanel.add(listIncidences);
		listIncidences.setSize("937px", "55px");
		
		contentTableDecorator.add(mainPanel);
		
		btnDetailsIncidence = new Button("details");
		btnevaluate = new Button("Evaluate");
	}

	
	public Widget asWidget() {
	    return this;
	  }


	@Override
	public HasClickHandlers getAddButton() {
		// TODO Auto-generated method stub
		return btnStoreNewIncidence;
	}


	@Override
	public HasClickHandlers getDetailsButton() {
		// TODO Auto-generated method stub
		return btnDetailsIncidence;
	}
	
	@Override
	public HasClickHandlers getEvaluateButton() {
		// TODO Auto-generated method stub
		return btnevaluate;
	}

	@Override
	public HasClickHandlers getList() {
		// TODO Auto-generated method stub
		return listIncidences;
	}


	@Override
	public void setData(ArrayList<ArrayList<String>> data) {
		// TODO Auto-generated method stub
		listIncidences.removeAllRows();
	    
		listIncidences.setText(0, 0, "Codigo");
		listIncidences.setText(0, 1, "Client Name");
		listIncidences.setText(0, 2, "Client E-mail");
		listIncidences.setText(0, 3, "Date");
		listIncidences.setText(0, 4, "Product");
		listIncidences.setText(0, 5, "Procedure");
		listIncidences.setText(0, 6, "Mark");
		listIncidences.setText(0, 7, "Details");
		
	    for (int i = 0; i < data.size(); ++i) {
	    	listIncidences.setText(i+1, 0, data.get(i).get(0));
	    	listIncidences.setText(i+1, 1, data.get(i).get(1));
	    	listIncidences.setText(i+1, 2, data.get(i).get(2));
	    	listIncidences.setText(i+1, 3, data.get(i).get(3));
	    	listIncidences.setText(i+1, 4, data.get(i).get(4));
	    	listIncidences.setText(i+1, 5, data.get(i).get(5));
	    	if (data.get(i).size()==7){
	    		listIncidences.setText(i, 6, data.get(i).get(6));
	    	}else{
	    		HorizontalPanel hp = new HorizontalPanel();
	    		
	    		ListBox c = new ListBox();
	    		c.addItem("-5");
	    		c.addItem("-4");
	    		c.addItem("-3");
	    		c.addItem("-2");
	    		c.addItem("-1");
	    		c.addItem("0");
	    		c.addItem("1");
	    		c.addItem("2");
	    		c.addItem("3");
	    		c.addItem("4");
	    		c.addItem("5");
	    		hp.add(c);
	    		
	    		hp.add(btnevaluate);
	    		// hp.setSize("200px", "50px");
	    		listIncidences.setWidget(i+1, 6, hp);
	    	}
	    	listIncidences.setWidget(i+1, 7, btnDetailsIncidence);
	    }
	}


	@Override
	public int getClickedRow(ClickEvent event) {
		int selectedRow = -1;
	    HTMLTable.Cell cell = listIncidences.getCellForEvent(event);
	    
	    if (cell != null) {
	      // Suppress clicks if the user is actually selecting the 
	      //  check box
	      //
	      if (cell.getCellIndex() > 0) {
	        selectedRow = cell.getRowIndex();
	      }
	    }
	    return selectedRow;
	}

	
}
