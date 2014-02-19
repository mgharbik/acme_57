package isw2.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddTechnicalEvent extends GwtEvent<AddTechnicalEventHandler>{

	public static Type<AddTechnicalEventHandler> TYPE = new Type<AddTechnicalEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddTechnicalEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AddTechnicalEventHandler handler) {
		handler.onAddTechnical(this);
	}

}
