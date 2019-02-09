package com.walmart.congo.model;

import java.time.LocalDateTime;

import com.walmart.congo.AppConstants;

//immutable class
public final class SeatHold {
	private final Customer customer;
	private final Seat seat;
	private final LocalDateTime holdUntil;

	public SeatHold(Customer customer, Seat seat) {
		super();
		this.customer = customer;
		this.seat = seat;
		LocalDateTime tTime = LocalDateTime.now();
		this.holdUntil = tTime.plusSeconds(AppConstants.HOLD_TIME_SEC);
	}

	public Customer getCustomer() {
		return customer.copy();
	}

	public Seat getSeat() {
		return seat;
	}

	public LocalDateTime getHoldUntil() {
		// LocalDateTime is immutable so safe copy not required
		return holdUntil;
	}

}
