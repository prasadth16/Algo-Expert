package com.category.simple.datastructures;

public class MinimumJumpsToReachEndInArray {
	/**
	 * Please check the algorithm Solution at
	 * https://www.youtube.com/watch?v=vBdo7wtwlXs Time complexity: O(n) Space
	 * Complexity: O(1)
	 **/
	public static int linierSolution(int[] inputArray) {

		int jumps = 0;
		int ladder = inputArray[0];
		int steps = inputArray[0];

		if (ladder >= inputArray.length) {
			steps = 1;
		}
		for (int i = 0; i < inputArray.length; i++) {

			if (steps == 0) {
				steps = ladder - i > 0 ? ladder - i : inputArray[i];
				jumps += 1;
			}
			ladder = ladder <= inputArray[i] + i ? inputArray[i] + i : ladder;
			steps -= 1;
		}

		return jumps;
	}

	/**
	 * Refer to the Algoexpert Solution Time Complexity: O(n^2) Space Complexity:
	 * O(n), as we are using a separate Array to store the jumps.
	 **/

	public static int dynamicProgrammingSolution(int[] inputArray) {
		int[] jumps = new int[inputArray.length];
		jumps = initializeArrayToMax(jumps);
		jumps[0] = 0;
		int i = 1;
		while (i < inputArray.length) {
			for (int j = 0; j < i; j++) {
				if (inputArray[j] + j >= i) {
					if (jumps[j] < jumps[i])
						jumps[i] = jumps[j] + 1;
				}
			}
			i++;
		}

		return jumps[jumps.length - 1];
	}

	private static int[] initializeArrayToMax(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = Integer.MAX_VALUE;
		}
		return inputArray;
	}

	public static void main(String[] args) {
		System.out.println("Test of Linier Solution");
		System.out.println(linierSolution(new int[] { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 }));
		System.out.println(linierSolution(new int[] { 3, 1 }));
		System.out.println(linierSolution(new int[] { 1, 1, 1 }));
		System.out.println(linierSolution(new int[] { 2, 1, 1 }));
		System.out.println(linierSolution(new int[] { 2, 1, 2, 3, 1 }));

		System.out.println("Test of Dynamic programming Solution");

		System.out.println(dynamicProgrammingSolution(new int[] { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 }));
		System.out.println(dynamicProgrammingSolution(new int[] { 3, 1 }));
		System.out.println(dynamicProgrammingSolution(new int[] { 1, 1, 1 }));
		System.out.println(dynamicProgrammingSolution(new int[] { 2, 1, 1 }));
		System.out.println(dynamicProgrammingSolution(new int[] { 2, 1, 2, 3, 1 }));

	}
}
