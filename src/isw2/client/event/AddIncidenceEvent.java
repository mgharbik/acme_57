package isw2.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddIncidenceEvent extends GwtEvent<AddIncidenceEventHandler>{

	public static Type<AddIncidenceEventHandler> TYPE = new Type<AddIncidenceEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddIncidenceEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AddIncidenceEventHandler handler) {
		handler.onAddIncidence(this);
	}

}
