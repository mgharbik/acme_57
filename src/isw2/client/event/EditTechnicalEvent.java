package isw2.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class EditTechnicalEvent extends GwtEvent<EditTechnicalEventHandler>{

	public static Type<EditTechnicalEventHandler> TYPE = new Type<EditTechnicalEventHandler>();
	
	private String user;
	
	public EditTechnicalEvent(String user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	
	public String getId(){
		return user;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<EditTechnicalEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EditTechnicalEventHandler handler) {
		handler.onEditTechnical(this);
	}

}
