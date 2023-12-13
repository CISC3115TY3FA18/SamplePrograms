package edu.cuny.brooklyn.gui;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class TravelerEvent extends Event {
	private static final long serialVersionUID = 5218391810645141761L;

	public static final EventType<TravelerEvent> TRAVELER = new EventType<TravelerEvent>("TRAVELER");

	public static final EventType<TravelerEvent> ANY = TRAVELER;

	public TravelerEvent(Object source, EventTarget target) {
		super(source, target, TRAVELER);
	}

	@Override
	public TravelerEvent copyFor(Object newSource, EventTarget newTarget) {
		return (TravelerEvent) super.copyFor(newSource, newTarget);
	}

    @SuppressWarnings("unchecked")
	@Override
    public EventType<? extends TravelerEvent> getEventType() {
        return (EventType<? extends TravelerEvent>) super.getEventType();
    }
}
