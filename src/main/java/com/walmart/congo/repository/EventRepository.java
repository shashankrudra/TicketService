package com.walmart.congo.repository;

import java.util.ArrayList;
import java.util.List;

import com.walmart.congo.AppConstants;
import com.walmart.congo.exception.InvalidUserInputException;
import com.walmart.congo.model.AbstractEntity;
import com.walmart.congo.model.Event;

public class EventRepository implements IRepository {
	private List<Event> events;

	public EventRepository() {
		events = new ArrayList<>();
	}

	@Override
	public synchronized void registerEntity(AbstractEntity event) {
		try {
			events.add((Event) event);
		} catch (ClassCastException ex) {
			throw new InvalidUserInputException(String.format(AppConstants.INVALID_ENTITY_MESSAGE, "Event"));
		}
	}

	@Override
	public synchronized boolean isRegistered(AbstractEntity event) {
		try {
			return events.contains(event);
		} catch (ClassCastException ex) {
			throw new InvalidUserInputException(String.format(AppConstants.INVALID_ENTITY_MESSAGE, "Event"));
		}
	}

}
