package isw2.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

import isw2.client.presenter.BossPresenter;

public class BossView extends Composite implements BossPresenter.Display{

	  private final Button addButton;
	  private final Button deleteButton;
	  private FlexTable technicalsTable;
	  private final FlexTable contentTable;
	
	public BossView(){
		DecoratorPanel contentTableDecorator = new DecoratorPanel();
	    initWidget(contentTableDecorator);
	    contentTableDecorator.setWidth("100%");
	    contentTableDecorator.setWidth("18em");

	    contentTable = new FlexTable();
	    contentTable.setWidth("100%");
	    contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListContainer");
	    contentTable.getCellFormatter().setWidth(0, 0, "100%");
	    contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0, DockPanel.ALIGN_TOP);
	    
	    // Create the menu
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setBorderWidth(0);
	    hPanel.setSpacing(0);
	    hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
	    addButton = new Button("Add");
	    hPanel.add(addButton);
	    deleteButton = new Button("Delete");
	    hPanel.add(deleteButton);
	    contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListMenu");
	    contentTable.setWidget(0, 0, hPanel);
	    
	    // Create the technical list
	    technicalsTable = new FlexTable();
	    technicalsTable.setCellSpacing(0);
	    technicalsTable.setCellPadding(0);
	    technicalsTable.setWidth("100%");
	    technicalsTable.addStyleName("contacts-ListContents");
	    technicalsTable.getColumnFormatter().setWidth(0, "15px");
	    contentTable.setWidget(1, 0, technicalsTable);
	    
	    contentTableDecorator.add(contentTable);
	}

	
	public Widget asWidget() {
	    return this;
	  }


	@Override
	public HasClickHandlers getAddButton() {
		// TODO Auto-generated method stub
		return addButton;
	}


	@Override
	public HasClickHandlers getDeleteButton() {
		// TODO Auto-generated method stub
		return deleteButton;
	}


	@Override
	public HasClickHandlers getList() {
		// TODO Auto-generated method stub
		return technicalsTable;
	}


	@Override
	public void setData(List<String> data) {
		// TODO Auto-generated method stub
		technicalsTable.removeAllRows();
	    
	    for (int i = 0; i < data.size(); ++i) {
	    	technicalsTable.setWidget(i, 0, new CheckBox());
	    	technicalsTable.setText(i, 1, data.get(i));
	    }
	}


	@Override
	public int getClickedRow(ClickEvent event) {
		// TODO Auto-generated method stub
		int selectedRow = -1;
	    HTMLTable.Cell cell = technicalsTable.getCellForEvent(event);
	    
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


	@Override
	public List<Integer> getSelectedRows() {
		// TODO Auto-generated method stub
		List<Integer> selectedRows = new ArrayList<Integer>();
	    
	    for (int i = 0; i < technicalsTable.getRowCount(); ++i) {
	      CheckBox checkBox = (CheckBox)technicalsTable.getWidget(i, 0);
	      if (checkBox.getValue()) {
	        selectedRows.add(i);
	      }
	    }
	    
	    return selectedRows;
	}
	
	
}
