package com.walmart.congo.repository;

import java.util.ArrayList;
import java.util.List;

import com.walmart.congo.model.Event;

public class EvenRepository {
	private List<Event> events;

	public EvenRepository() {
		events = new ArrayList<>();
	}

	public synchronized void registerEvent(Event event) {
		events.add(event);
	}

	public synchronized boolean isRegistered(Event event) {
		return events.contains(event);
	}
}
