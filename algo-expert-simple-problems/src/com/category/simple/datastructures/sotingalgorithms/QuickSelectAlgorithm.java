package com.category.simple.datastructures.sotingalgorithms;

import java.math.BigDecimal;

/**Time Complexity=Best and Avrage case: O(n)
 * Woerst case: O(n^2)
 * 
 * Space Complexity: O(1)
 * **/
public class QuickSelectAlgorithm {

	public static int getNthSmallestNumber(int[] inputArray, int number) {
		int left = 1;
		int right = inputArray.length - 1;
		int pivote = generateRandomNumber(left, right);
		int start = 0;
		int end = inputArray.length - 1;
		inputArray = swapPositions(pivote, 0, inputArray);
		pivote = 0;
		boolean gotAnswer = false;
		while (!gotAnswer) {
			while (left <= right) {
				if (inputArray[left] > inputArray[pivote] && inputArray[right] <= inputArray[pivote]) {
					inputArray = swapPositions(left, right, inputArray);
				}
				if (inputArray[left] <= inputArray[pivote]) {
					left++;
				}
				if (inputArray[right] > inputArray[pivote]) {
					right--;
				}

			}
			inputArray = swapPositions(right, pivote, inputArray);
			if (right == number - 1) {
				gotAnswer = true;
			}
			// determining new left, right and pivote position

			else if (right > number - 1) {
				end = right - 1;
			} else {
				start = right + 1;
			}
			if (!gotAnswer) {
				left = start + 1;
				right = end;
				 pivote = generateRandomNumber(left, right);
				 inputArray = swapPositions(pivote, start, inputArray);
				pivote = start;
			}

		}

		return inputArray[right];
	}

	private static int generateRandomNumber(int low, int high) {
		return BigDecimal.valueOf((Math.random() * ((high - low) + 1) + low)).intValue();
	}

	private static int[] swapPositions(int firstPosition, int seconPosition, int[] inputArray) {
		int tempHolder = inputArray[firstPosition];
		inputArray[firstPosition] = inputArray[seconPosition];
		inputArray[seconPosition] = tempHolder;
		return inputArray;
	}

	public static void main(String[] args) {
		System.out.println(getNthSmallestNumber(new int[] { 13, 3, 9, 5, 14, 17, 19, 7, 25 }, 3));
	}
}
