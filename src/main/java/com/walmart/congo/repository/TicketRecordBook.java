package com.walmart.congo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.walmart.congo.AppConstants;
import com.walmart.congo.model.Seat;

public class TicketRecordBook {
	private static final Logger LOG = LoggerFactory.getLogger("ResponseLogger");
	public static final int SEAT_MATRIX_SIZE = AppConstants.MAX_ROW_NUMBER * AppConstants.MAX_SEAT_NUMBER;
	private static final Seat[][] seats = new Seat[AppConstants.MAX_ROW_NUMBER][AppConstants.MAX_SEAT_NUMBER];

	static {
		for (int i = 0; i < AppConstants.MAX_ROW_NUMBER; i++) {
			for (int j = 0; j < AppConstants.MAX_SEAT_NUMBER; j++) {
				int t = 'A' + j;
				char tC = (char) t;
				seats[i][j] = new Seat(i, tC);
			}
		}
	}

	public static void printSeats() {
		int count = AppConstants.MAX_ROW_NUMBER * AppConstants.MAX_SEAT_NUMBER;
		for (int i = 0; i < seats.length; i++) {
			StringBuilder sb = new StringBuilder(i + 1 + "");
			sb.append(" ");

			for (int j = 0; j < AppConstants.MAX_SEAT_NUMBER; j++) {
				if (seats[i][j].isOccupied()) {
					sb.append(AppConstants.OCCUPIED_MARKER);
					count--;
				} else {
					sb.append(seats[i][j].getSeatNumber());
				}
			}
			LOG.info(sb.toString());
		}

		LOG.info(String.format("There are %d number of seats available.", count));
	}

	public static boolean isSeatAvailable(int row, int col) {
		return !seats[row][col].isOccupied();
	}

	public static void bookSeats(int row, int col) {
		seats[row][col].setOccupied(true);
	}

}
