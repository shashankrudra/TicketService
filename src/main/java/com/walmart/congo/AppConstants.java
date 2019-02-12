package com.walmart.congo;

public final class AppConstants {
	// stop from instantiation
	private AppConstants() {
	}

	// ticket hold time in seconds
	public static final int HOLD_TIME_SEC = 120;

	public static final String SEAT_STRING_DELIM = "-";
	public static final char MAX_CHAR_ROW = 'T';// 20
	public static final int MAX_COL_NUM = 40;
	public static final String SEAT_RANGE_MSG = "Valid seat range is A1 to T40";
	public static final String INVALID_SEAT_INPUT_MSG = "Seat input is not correct. It is beyond supported range.";

	public static final String DATA_SEPARATOR_COMMA = ",";
	public static final String INVALID_ENTITY_MESSAGE = "Invalid entity sent. %s was expected.";

	public static final String VALIDATE_EMPTY = "  Please enter a non-empty value";
	public static final String INVALID_INT_ARG = "  Please enter a valid integer value";

}
