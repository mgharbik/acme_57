package isw2.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class TechnicalUpdatedEvent extends GwtEvent<TechnicalUpdatedEventHandler>{
  public static Type<TechnicalUpdatedEventHandler> TYPE = new Type<TechnicalUpdatedEventHandler>();

  @Override
  public Type<TechnicalUpdatedEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(TechnicalUpdatedEventHandler handler) {
    handler.onTechnicalUpdated(this);
  }
}
