package com.walmart.congo.repository;

import java.util.ArrayList;
import java.util.List;

import com.walmart.congo.model.EventSeat;

public class EventSeatRepository {
	private List<EventSeat> eventSeats;

	public EventSeatRepository() {
		eventSeats = new ArrayList<>();
	}

	public synchronized void registerEntity(EventSeat eventSeat) {
		eventSeats.add((EventSeat) eventSeat);
	}

	public synchronized boolean isRegistered(EventSeat event) {
		return eventSeats.contains(event);
	}

}
