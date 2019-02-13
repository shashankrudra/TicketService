package com.walmart.congo.service;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.walmart.congo.AppConstants;
import com.walmart.congo.repository.TicketRecordBook;

public class TicketBookingRunner {
	private static final Logger LOG = LoggerFactory.getLogger("ResponseLogger");
	private static final Scanner console = new Scanner(System.in);

	static {
		BasicConfigurator.configure();
	}

	public static void main(String[] args) {
		new TicketBookingRunner().doIt();
	}

	public void doIt() {
		LOG.info("Welcome to the seat reservation system!");
		int filled = 0;
		printSeats();
		LOG.info("Enter seat (e.g. 1A) or zero to quit the program.");
		String input = getAndValidateInput();
		while (shallContinue(input, filled)) {
			int row = input.charAt(0) - '1';
			int col = input.charAt(1) - 'A';
			if (row < 0 || row > AppConstants.MAX_ROW_NUMBER || col < 0 || col > AppConstants.MAX_SEAT_NUMBER) {
				LOG.info("Input error. Enter seat to assign (e.g., '1A'), " + "or zero to quit.");
				input = console.nextLine();
			} else {
				int seatAvailable = isSeatAvailable(row, col);
				if (seatAvailable == 0) {
					bookSeats(row, col);
					filled++;
				} else if (seatAvailable > 0) {
					LOG.info("Seat already taken");
				}
				printSeats();
				if (filled < TicketRecordBook.SEAT_MATRIX_SIZE) {
					LOG.info("Enter seat to assign (e.g., '1A'), " + "or 0 to quit:");
					input = console.nextLine();
				}
			}
		}
		LOG.info("Final seat assignments: ");
		printSeats();
	}

	private boolean shallContinue(String input, int filled) {
		return !input.equals("-1") && (filled < TicketRecordBook.SEAT_MATRIX_SIZE) && (input.length() > 0);
	}

	// if user inputs 0, that is an exit condition
	public String getAndValidateInput() {
		String input = console.nextLine();
		if (input.length() == 1) {
			try {
				if (Integer.parseInt(input) == 0)// this is exit condition
					return "-1";
			} catch (Exception ex) {

			}
		}
		return input;
	}

	/**
	 * 0 if it seat is available, 1 if not available, -1 if there is an invalid
	 * input
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private int isSeatAvailable(int row, int col) {
		try {
			if (TicketRecordBook.isSeatAvailable(row, col)) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception ex) {
			LOG.error("Invalid input. " + ex.getMessage());
			return -1;
		}
	}

	private void bookSeats(int row, int col) {
		TicketRecordBook.bookSeats(row, col);
	}

	private void printSeats() {
		TicketRecordBook.printSeats();
	}

}