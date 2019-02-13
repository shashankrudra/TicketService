package com.walmart.congo.model;

public final class Seat extends AbstractEntity {
	private final int rowNumber; // 1 to n
	private final char seatNumber; // A to X
	private boolean isOccupied;

	public Seat(int rowNumber, char seatNumber) {
		super();
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
		this.isOccupied = false;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public char getSeatNumber() {
		return seatNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

}
