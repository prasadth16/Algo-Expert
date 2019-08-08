package com.category.simple;

/**
 * Refer to algoExpert for detailed graphical representation of the problem
 * statement Time Complexity=O(n) Space Complexity= O(n) Where n is the number
 * of elements in the given input array. Solved below problem using Dynamic
 * programming
 * 
 * This problem can even be solved by iterating through array once and for every
 * visting element iterate all the earlier elements and accurately recalculate
 * the water area. But the time complexity increases to O(n^2) and hence it is
 * not the best solution. Space complexity remains same as the dynamic
 * programming solution.
 **/
public class WaterSurfaceAreaCalculation {

	public static int calculateWaterArea(int[] inputArray) {
		int[] calcLeftMax = calculateLeftMax(inputArray);
		int[] calcRightMax = calculateRightMax(inputArray);
		int[] calcDepth = calcWaterArea(calcLeftMax, calcRightMax, inputArray);
		int totalWaterArea = 0;
		for (int i : calcDepth) {
			totalWaterArea += i;
		}

		return totalWaterArea;
	}

	private static int[] calculateLeftMax(int[] inputArray) {
		int[] leftMax = new int[inputArray.length];
		int leftMaximum = inputArray[0];

		for (int i = 1; i < inputArray.length; i++) {
			leftMax[i] = leftMaximum;
			if (leftMaximum < inputArray[i])
				leftMaximum = inputArray[i];
		}

		return leftMax;
	}

	private static int[] calculateRightMax(int[] inputArray) {
		int[] rightMax = new int[inputArray.length];
		int rightMaximum = inputArray[inputArray.length - 1];

		for (int i = inputArray.length - 2; i >= 0; i--) {
			rightMax[i] = rightMaximum;
			if (rightMaximum < inputArray[i])
				rightMaximum = inputArray[i];
		}
		return rightMax;

	}

	private static int[] calcWaterArea(int[] inputLeftMax, int[] inputRightMax, int[] inputArray) {
		int[] calcop = new int[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			calcop[i] = Integer.min(inputLeftMax[i], inputRightMax[i]) > inputArray[i]
					? Integer.min(inputLeftMax[i], inputRightMax[i]) - inputArray[i]
					: 0;
		}
		return calcop;
	}

	public static void main(String[] args) {
		System.out.println(calculateWaterArea(new int[] { 0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3 }));
	}

}
