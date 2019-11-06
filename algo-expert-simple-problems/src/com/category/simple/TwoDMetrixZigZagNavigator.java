package com.category.simple;

import java.util.Arrays;

public class TwoDMetrixZigZagNavigator {

	public static void navigator(int[][] ipMatrix) {
		int x = ipMatrix.length;
		int y = ipMatrix[0].length;
		int opCounter = 0;
		int curx = 0;
		int cury = 0;
		boolean upDirection = false;
		int[] opArray = new int[x * y];
		boolean nav = true;
		while (nav) {
			if (curx == (x - 1) && cury == (y - 1)) {
				opArray[opCounter] = ipMatrix[curx][cury];
				nav = false;
			} else if (cury == 0 && curx < (x - 1) && !upDirection) {
				opArray[opCounter] = ipMatrix[curx][cury];
				curx++;
				upDirection = true;

			} else if (curx == 0 && cury < (y - 1) && upDirection) {
				opArray[opCounter] = ipMatrix[curx][cury];
				cury++;
				upDirection = false;
			} else if (upDirection && curx > 0 && cury < y - 1) {
				opArray[opCounter] = ipMatrix[curx][cury];
				curx--;
				cury++;
			} else if (!upDirection && curx < x - 1 && cury > 0) {
				opArray[opCounter] = ipMatrix[curx][cury];
				curx++;
				cury--;
			} else if (curx == (x - 1) && cury < (y - 1) && !upDirection) {
				opArray[opCounter] = ipMatrix[curx][cury];
				cury++;
				upDirection = true;
			} else if (cury == (y - 1) && curx < (x - 1) && upDirection) {
				opArray[opCounter] = ipMatrix[curx][cury];
				curx++;
				upDirection = false;
			}
			opCounter++;
		}
		printOpArray(opArray);
	}

	private static void printOpArray(int[] opArray) {
		Arrays.stream(opArray).forEach(System.out::println);
	}

	public static void main(String[] args) {
		// create metrix and call the navigator function
		int[][] ipMatrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		navigator(ipMatrix);
	}

}
