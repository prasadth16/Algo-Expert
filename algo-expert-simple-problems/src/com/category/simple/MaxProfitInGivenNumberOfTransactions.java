package com.category.simple;

public class MaxProfitInGivenNumberOfTransactions {

	private static int[][] memoisationMatrix;
	private static int[][] maxProfitMatrix;

	public static void main(String[] arg) {
		int[] sharePrices = new int[] { 5, 11, 3, 50, 60, 90 };
		int numberOftransactions = 2;
		populateMemoisationMatrix(sharePrices, numberOftransactions);
		System.out.println("Max Profit made with "+numberOftransactions+" is:"+ memoisationMatrix[numberOftransactions-1][sharePrices.length-1]);
	}

	private static void populateMemoisationMatrix(int[] sharePrices, int numberOfTransactions) {

		memoisationMatrix = new int[numberOfTransactions+1][sharePrices.length];
		maxProfitMatrix = new int[numberOfTransactions+1][sharePrices.length];
		maxProfitMatrix[0][0] = -sharePrices[0];

		for (int i = 1; i < numberOfTransactions; i++) {
			for (int j = 1; j < sharePrices.length; j++) {
				if (memoisationMatrix[i - 1][j - 1] >= sharePrices[j] + maxProfitMatrix[i - 1][j - 1]) {
					memoisationMatrix[i][j] = memoisationMatrix[i - 1][j - 1];
				} else {
					memoisationMatrix[i][j] = sharePrices[j] - maxProfitMatrix[i - 1][j - 1];
				}
				if (maxProfitMatrix[i - 1][j - 1] >= -sharePrices[j] + memoisationMatrix[i - 1][j]) {
					maxProfitMatrix[i - 1][j] = maxProfitMatrix[i - 1][j - 1];
				} else {
					maxProfitMatrix[i - 1][j] = -sharePrices[j] + memoisationMatrix[i - 1][j];
				}
			}

		}
	}

}
