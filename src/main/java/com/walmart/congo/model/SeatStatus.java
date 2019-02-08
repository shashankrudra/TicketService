package com.walmart.congo.model;

public enum SeatStatus {

	AVAILABLE("S"), HOLD("H"), RESERVED("R");

	private String statusString;

	SeatStatus(String statusString) {
		this.statusString = statusString;
	}

	public String getStatusString() {
		return statusString;
	}
}
