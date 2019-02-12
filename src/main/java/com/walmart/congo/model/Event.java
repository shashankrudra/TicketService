package com.walmart.congo.model;

import java.time.LocalDateTime;

// immutable class
public final class Event extends AbstractEntity {
	private final String eventName;
	private final LocalDateTime beginDateTime;
	private final LocalDateTime endDateTime;

	// we may create a constructor with String date time in addition to the
	// below constructor
	public Event(String eventName, LocalDateTime beginDateTime, LocalDateTime endDateTime) {
		super();
		this.eventName = eventName;
		this.beginDateTime = beginDateTime;
		this.endDateTime = endDateTime;
	}

	// if it is a database based entity
	// should consider 3 fields as Unique Key
	public void validate() {

	}

	public String getEventName() {
		return eventName;
	}

	public LocalDateTime getBeginDateTime() {
		return beginDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginDateTime == null) ? 0 : beginDateTime.hashCode());
		result = prime * result + ((endDateTime == null) ? 0 : endDateTime.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
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
		Event other = (Event) obj;
		if (beginDateTime == null) {
			if (other.beginDateTime != null)
				return false;
		} else if (!beginDateTime.equals(other.beginDateTime))
			return false;
		if (endDateTime == null) {
			if (other.endDateTime != null)
				return false;
		} else if (!endDateTime.equals(other.endDateTime))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		return true;
	}

}
