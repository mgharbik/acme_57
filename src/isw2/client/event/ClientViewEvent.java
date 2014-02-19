package isw2.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ClientViewEvent extends GwtEvent<ClientViewEventHandler>{

	public static Type<ClientViewEventHandler> TYPE = new Type<ClientViewEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ClientViewEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ClientViewEventHandler handler) {
		handler.onClientView(this);
	}

}
