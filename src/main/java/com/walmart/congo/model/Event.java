package com.walmart.congo.model;

import java.time.LocalDateTime;
import java.util.List;

import com.walmart.congo.AppConstants;

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

	public Event(String eventName, String beginDateTime, String endDateTime) {
		super();
		this.eventName = eventName;
		this.beginDateTime = LocalDateTime.parse(beginDateTime, AppConstants.EVENT_DATETIME_FORMATTER);
		this.endDateTime = LocalDateTime.parse(endDateTime, AppConstants.EVENT_DATETIME_FORMATTER);
	}

	public Event(List<String> fields) {
		this(fields.get(0), fields.get(1), fields.get(2));
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
