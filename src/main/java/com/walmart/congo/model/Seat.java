package com.walmart.congo.model;

import com.walmart.congo.AppConstants;
import com.walmart.congo.exception.InvalidUserInputException;

// immutable class
public final class Seat extends AbstractEntity {
	private final int row;
	private final char rowChar;
	private final int column;

	public Seat(char rowChar, int column) {
		super();
		validate(rowChar, column);
		this.rowChar = Character.toUpperCase(rowChar);
		this.column = column;
		this.row = rowChar - 'A';
	}

	// seat can be given in the form M-12 ; delimiter is SEAT_STRING_DELIM
	public Seat(String seatString) {
		String[] arr = seatString.split(AppConstants.SEAT_STRING_DELIM);

		valdidateSeatString(seatString);
		this.rowChar = Character.toUpperCase(arr[0].charAt(0));
		this.column = Integer.parseInt(arr[1]);
		this.row = rowChar - 'A';
	}

	private void valdidateSeatString(String seatString) {
		String[] arr = seatString.split(AppConstants.SEAT_STRING_DELIM);
		if (arr.length > 2 || arr[0].length() > 1) {
			throw new InvalidUserInputException(AppConstants.INVALID_SEAT_INPUT_MSG + AppConstants.SEAT_RANGE_MSG);
		}

		validateRowChar(arr[0].charAt(0));

		int nCol = 0;
		try {
			nCol = Integer.parseInt(arr[1]);
			if (nCol > AppConstants.MAX_COL_NUM) {
				throw new InvalidUserInputException(AppConstants.INVALID_SEAT_INPUT_MSG + AppConstants.SEAT_RANGE_MSG);
			}
		} catch (NumberFormatException ex) {
			throw new InvalidUserInputException(AppConstants.INVALID_SEAT_INPUT_MSG + AppConstants.SEAT_RANGE_MSG);
		}

	}

	private void validateRowChar(char tChr) {
		char tChar = Character.toUpperCase(tChr);
		if (tChar > AppConstants.MAX_CHAR_ROW) {
			throw new InvalidUserInputException(AppConstants.INVALID_SEAT_INPUT_MSG + AppConstants.SEAT_RANGE_MSG);
		}
	}

	private void validate(char rowChr, int nCol) {
		validateRowChar(rowChr);
		if (nCol > AppConstants.MAX_COL_NUM) {
			throw new InvalidUserInputException(AppConstants.INVALID_SEAT_INPUT_MSG + AppConstants.SEAT_RANGE_MSG);
		}
	}

	public char getRowChar() {
		return rowChar;
	}

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		result = prime * result + rowChar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		if (rowChar != other.rowChar)
			return false;
		return true;
	}

}
