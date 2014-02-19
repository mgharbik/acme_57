package isw2.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class TechnicalViewEvent extends GwtEvent<TechnicalViewEventHandler>{

	public static Type<TechnicalViewEventHandler> TYPE = new Type<TechnicalViewEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<TechnicalViewEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(TechnicalViewEventHandler handler) {
		handler.onTechnicalView(this);
	}

}
