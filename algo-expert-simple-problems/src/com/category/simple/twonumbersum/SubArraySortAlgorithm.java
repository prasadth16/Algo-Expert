package com.category.simple.twonumbersum;

/**
 * Program to find the start and end index of the sub-array which needed to be
 * sorted in order to sort that array. Time complexity: We are iterating through
 * the input array thrice and hence O(3n)=>O(n) where n is number of input
 * elements. Space Complexity: O(n) as we are creating a boolean array.
 **/
public class SubArraySortAlgorithm {

	public static int[] getSubArraySortIndex(int[] inputArray) {
		int[] opArray = new int[2];
		int minimumNumber = Integer.MAX_VALUE;
		int maximumNumber = Integer.MIN_VALUE;
		boolean[] isSortedArray = new boolean[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			if (i - 1 < 0) {
				isSortedArray[i] = inputArray[i] <= inputArray[i + 1];

			} else if (i + 1 == inputArray.length) {
				isSortedArray[i] = inputArray[i - 1] <= inputArray[i];
			} else {
				isSortedArray[i] = inputArray[i - 1] <= inputArray[i] && inputArray[i] <= inputArray[i + 1];
			}
			if (!isSortedArray[i]) {
				minimumNumber = minimumNumber > inputArray[i] ? inputArray[i] : minimumNumber;
				maximumNumber = maximumNumber < inputArray[i] ? inputArray[i] : maximumNumber;
			}
		}

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] >= minimumNumber) {
				opArray[0] = i;
				break;
			}
		}

		for (int i = inputArray.length - 1; i >= 0; i--) {
			if (inputArray[i] <= maximumNumber) {
				opArray[1] = i;
				break;
			}
		}
		return opArray;

	}

	public static void main(String[] args) {
		int[] opArray = getSubArraySortIndex(new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 });
		System.out.println("Output Index is: " + opArray[0] + " and " + opArray[1]);
	}
}
