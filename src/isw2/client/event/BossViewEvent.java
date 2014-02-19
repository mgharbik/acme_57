package isw2.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class BossViewEvent extends GwtEvent<BossViewEventHandler>{

	public static Type<BossViewEventHandler> TYPE = new Type<BossViewEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<BossViewEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(BossViewEventHandler handler) {
		handler.onBossView(this);
	}

}
