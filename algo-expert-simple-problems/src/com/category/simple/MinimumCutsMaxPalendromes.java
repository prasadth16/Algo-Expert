package com.category.simple;

public class MinimumCutsMaxPalendromes {

	public static void main(String[] args) {
		System.out.println(getNumberOfCuts("noonabbad"));
		//System.out.println(getNumberOfCuts("noon"));
		//System.out.println(getNumberOfCuts("prasad"));
	}

	private static int getNumberOfCuts(String inputString) {
		char[] ipCharArray = inputString.toCharArray();
		int[][] opPalendromeMatrix = new int[ipCharArray.length][ipCharArray.length];
		opPalendromeMatrix = initializePalendromeMatrix(opPalendromeMatrix);
		opPalendromeMatrix = initializeFirstPalendromeDiagonally(opPalendromeMatrix);
		opPalendromeMatrix = fillPalendromeMatrix(opPalendromeMatrix, ipCharArray);
		for (int i = 0; i < opPalendromeMatrix.length; i++) {
			for (int j = 0; j < opPalendromeMatrix.length; j++) {
				System.out.print(opPalendromeMatrix[i][j] + " ");
			}
			System.out.println("");
		}
		int minNumberOfCuts = determineMinNumberOfCuts(opPalendromeMatrix, ipCharArray);

		return minNumberOfCuts;
	}

	private static int determineMinNumberOfCuts(int[][] ipPalMatrix, char[] ipCharArray) {
		int[] opArray = new int[ipCharArray.length];
		int tmpCuts = 0;
		int palIndex = 0;
		boolean foundPal = false;
		for (int i = 0; i < ipCharArray.length; i++) {

			if (i == 0) {
				opArray[i] = 0;
			} else {
				if (ipPalMatrix[0][i] == 1) {
					opArray[i] = 0;
					continue;
				} else {
					tmpCuts = opArray[i - 1] + 1;
					foundPal = false;
					for (int j = 1; j <= i; j++) {
						if (ipPalMatrix[j][i] == 1) {
							foundPal = true;
							palIndex = j - 1;
							break;
						}
					}
					if (foundPal) {
						opArray[i] = opArray[palIndex] + 1;
					} else {
						opArray[i] = tmpCuts;
					}
				}

			}

		}
		return opArray[opArray.length - 1];
	}

	private static int[][] initializePalendromeMatrix(int[][] ipMatrix) {
		for (int i = 0; i < ipMatrix.length; i++) {
			for (int j = 0; j < ipMatrix.length; j++) {
				ipMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		return ipMatrix;
	}

	private static int[][] initializeFirstPalendromeDiagonally(int[][] ipMatrix) {
		for (int i = 0; i < ipMatrix.length; i++) {
			ipMatrix[i][i] = 1;
		}

		return ipMatrix;
	}

	private static int[][] fillPalendromeMatrix(int[][] ipMatrix, char[] ipCharArray) {
		int col = 1, intRow = ipMatrix.length - 2, counter = 0, colCounter = 0;

		while (col <= ipMatrix.length - 1 && intRow >= 0) {
			counter = 0;
			colCounter = col;
			while (counter <= intRow) {
				if (ipCharArray[counter] == ipCharArray[colCounter] && (ipMatrix[counter + 1][colCounter - 1] == 1
						|| ipMatrix[counter + 1][colCounter - 1] == Integer.MAX_VALUE)) {
					ipMatrix[counter][colCounter] = 1;
				} else {
					ipMatrix[counter][colCounter] = 0;
				}
				counter++;
				colCounter++;
			}
			col++;
			intRow--;
		}

		return ipMatrix;
	}
}
