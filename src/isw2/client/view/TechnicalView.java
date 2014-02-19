package isw2.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

import isw2.client.presenter.TechnicalPresenter;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;

public class TechnicalView extends Composite implements TechnicalPresenter.Display{
	private TabLayoutPanel tlp;
	
	public TechnicalView(){
		
		tlp = new TabLayoutPanel(1.5, Unit.EM);
		tlp.add(new HTML("this"), "this");
		tlp.add(new HTML("that content"));
		tlp.add(new HTML("the other content"));
		
		initWidget(tlp);
	}

	
	public Widget asWidget() {
	    return this;
	  }

	@Override
	public void setData(List<String> data) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getClickedRow(ClickEvent event) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Integer> getSelectedRows() {
		// TODO Auto-generated method stub
		return null;
	}
}
