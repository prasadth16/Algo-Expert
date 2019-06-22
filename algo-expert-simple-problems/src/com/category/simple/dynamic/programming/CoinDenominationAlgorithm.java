package com.category.simple.dynamic.programming;

/**
 * PROBLEM STATEMENT: Inputs: Array of Denominations, Target Sum Output: Program
 * needs to return minimum number of coins to sum up to the target sum. Example:
 * Denomination Array={1,2,5} and Target Sum is 11 Then Output should be 2 coins
 * of 5 and 1 coin of 1=3 coins
 **/

public class CoinDenominationAlgorithm {

	public static int getMinimumNumberCoinsUsingRecurrsion(int[] dinominations, int sum) {
		int[] memoisedStorage = new int[sum + 1];
		int i = 0;
		while (i < sum + 1) {
			memoisedStorage[i] = Integer.MAX_VALUE;
			i++;
		}
		return minNumberCoins(dinominations, sum, memoisedStorage);
	}

	/**
	 * This is the Recurssive method with Dynamic Programming. Space Complexity:
	 * o(n) where n is number of levels in the tree of subproblems. Time Complexity
	 * is o(n)
	 **/

	public static int minNumberCoins(int[] dinominations, int sum, int[] memoisedStorage) {
		int min = 0;
		int newMin = 0;
		int counter = 0;
		if (memoisedStorage[sum] != Integer.MAX_VALUE) {
			return memoisedStorage[sum];
		}
		if (sum == 0) {
			memoisedStorage[0] = 0;
			return 0;
		}
		for (int den : dinominations) {
			if (den <= sum) {
				newMin = minNumberCoins(dinominations, sum - den, memoisedStorage);
				if (min > newMin + 1 && counter > 0) {
					min = newMin + 1;

				}
				if (counter == 0) {
					min = newMin + 1;
				}
				counter++;
			}
		}
		memoisedStorage[sum] = min;
		return min;
	}

	public static int getMinimumNumberCoinsUsingBottomUp(int[] dinominations, int sum) {
		int[] memoisedStorage = new int[sum + 1];
		int i = 0;
		while (i < sum + 1) {
			memoisedStorage[i] = Integer.MAX_VALUE;
			i++;
		}

		memoisedStorage = minNumberCoinsBottomUp(dinominations, sum, memoisedStorage);
		return memoisedStorage[sum];
	}

	/**
	 * This is the Bottom-Up method with Dynamic Programming. Space Complexity: o(n)
	 * where n is Target Sum. Time Complexity is o(n) where n is Target Sum as we
	 * store intermediate results.
	 **/

	public static int[] minNumberCoinsBottomUp(int[] dinominations, int sum, int[] memoisedStorage) {

		int counter = 0;
		int min = 0;
		int newMin = 0;
		int innerCounter = 0;
		while (counter <= sum) {
			if (counter == 0) {
				memoisedStorage[counter] = 0;
			} else {
				innerCounter = 0;
				for (int den : dinominations) {
					if (den <= counter) {
						if (min > memoisedStorage[counter - den] + 1 && innerCounter > 0) {
							min = memoisedStorage[counter - den] + 1;
						}

						if (innerCounter == 0) {
							min = memoisedStorage[counter - den] + 1;

						}
						innerCounter++;
					}

				}
				memoisedStorage[counter] = min;
			}

			counter++;
		}

		return memoisedStorage;
	}

}
