package com.walmart.congo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.walmart.congo.model.SeatHold;
import com.walmart.congo.model.SeatStatus;

public class TicketServiceImpl implements TicketService {

	// move this map to a dedicated class - decouple
	Map<String, SeatStatus> map = new ConcurrentHashMap<>();

	@Override
	public int numSeatsAvailable() {
		return 0;
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {

		return null;
	}

	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		return null;
	}

}
