package com.walmart.congo;

import java.time.format.DateTimeFormatter;

public final class AppConstants {
	// stop from instantiation
	private AppConstants() {
	}

	// ticket hold time in seconds
	public static final int HOLD_TIME_SEC = 120;

	public static final String SEAT_STRING_DELIM = "-";
	public static final int MAX_SEAT_NUMBER = 3;// T 20
	public static final int MAX_ROW_NUMBER = 5;
	public static final String SEAT_RANGE_MSG = "Valid seat range is A1 to C5";
	public static final String INVALID_SEAT_INPUT_MSG = "Seat input is not correct. It is beyond supported range.";

	public static final String DATA_SEPARATOR_COMMA = ",";
	public static final String INVALID_ENTITY_MESSAGE = "Invalid entity sent. %s was expected.";

	public static final String VALIDATE_EMPTY = "  Please enter a non-empty value";
	public static final String INVALID_INT_ARG = "  Please enter a valid integer value";

	public static final DateTimeFormatter EVENT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");

	public static final char OCCUPIED_MARKER = 'X';

}
