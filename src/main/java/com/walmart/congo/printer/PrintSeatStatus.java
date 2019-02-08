package com.walmart.congo.printer;

public class PrintSeatStatus {
	int rows = 9;
	int seats = 33;

	private String[][] getSeatMatrix() {
		String arr[][] = new String[rows][];
		fillDecor(arr);
		return arr;
	}

	private void fillDecor(String[][] arr) {
		String tArr[] = new String[seats];
		int t = 0;
		for (int i = 0; i < 10; i++) {
			tArr[t + i] = "-";
		}
		tArr[t++] = "[";
		tArr[t++] = "[";
		tArr[t++] = " ";
		tArr[t++] = "STAGE";
		tArr[t++] = " ";
		tArr[t++] = " ";
		tArr[t++] = "]";
		tArr[t++] = "]";
	}

	public void printStatus() {

	}
}
