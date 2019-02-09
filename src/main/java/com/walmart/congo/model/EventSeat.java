package com.walmart.congo.model;

// immutable class
public final class EventSeat {
	private final Event event;
	private final Seat seat;

	public EventSeat(Event event, Seat seat) {
		super();
		this.event = event;
		this.seat = seat;
	}

	// if these classes are not immutable - use safe copy for getters
	public Event getEvent() {
		return event;
	}

	public Seat getSeat() {
		return seat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventSeat other = (EventSeat) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		return true;
	}

}
