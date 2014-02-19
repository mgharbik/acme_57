package isw2.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class DetailsIncidenceEvent extends GwtEvent<DetailsIncidenceEventHandler>{

	public static Type<DetailsIncidenceEventHandler> TYPE = new Type<DetailsIncidenceEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DetailsIncidenceEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DetailsIncidenceEventHandler handler) {
		handler.onDetailsIncidence(this);
	}

}
