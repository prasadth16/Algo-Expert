package com.category.simple.twonumbersum;

public class TwoNumberSumUsingSorting {
	public static void main(String[] arg) {
		int[] targetArray = getTwoNumberSum(new int[] { -7, -5, -3, -1, 0, 1, 3, 5, 7 }, -5);
		if (targetArray.length > 0) {
			System.out.println("Target sum does match!!!");
			for (int i : targetArray) {
				System.out.println(i);
			}
		} else {
			System.out.println("Target sum does not match!!!");
		}
	}

	public static int[] getTwoNumberSum(int[] intArray, int targetSum) {
		// Assuming here that input array is already sorted using an highly efficient
		// sorting algorithm
		int startingIndex = 0;
		int endingIndex = intArray.length - 1;
		Integer number1 = null;
		Integer number2 = null;
		int[] targetArray;
		while (startingIndex != endingIndex) {
			if (intArray[startingIndex] + intArray[endingIndex] == targetSum) {
				number1 = intArray[startingIndex];
				number2 = intArray[endingIndex];
				break;
			} else if (intArray[startingIndex] + intArray[endingIndex] < targetSum) {
				startingIndex = startingIndex + 1;
			} else {
				endingIndex = endingIndex - 1;
			}
		}
		if (number1 != null && number2 != null) {
			targetArray = new int[] { number1, number2 };
		} else {
			targetArray = new int[] {};
		}
		return targetArray;
	}

}
