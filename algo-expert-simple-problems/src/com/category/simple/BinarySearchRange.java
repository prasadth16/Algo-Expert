package com.category.simple;

/**
 * find the range in the binary search time complexity: O(log n) Space
 * Complexity: constant as this is iterative implementation.
 **/

public class BinarySearchRange {

	private static int leftRangeBinarySearch(int[] inputArray, int ipNumber) {
		int left = 0;
		int right = inputArray.length - 1;
		int leftRange = -1;
		while (left <= right) {
			if (inputArray[Math.floorDiv((left + right), 2)] == ipNumber) {
				if (Math.floorDiv((left + right), 2) > 0
						&& inputArray[Math.floorDiv((left + right), 2) - 1] == ipNumber) {
					right = Math.floorDiv((left + right), 2) - 1;
				} else {
					leftRange = Math.floorDiv((left + right), 2);
					break;
				}
			}

			else if (inputArray[Math.floorDiv((left + right), 2)] < ipNumber) {
				left = Math.floorDiv((left + right), 2) + 1;
			} else {
				right = Math.floorDiv((left + right), 2) - 1;
			}
		}

		return leftRange;
	}

	private static int rightRangeBinarySearch(int[] inputArray, int ipNumber) {
		int left = 0;
		int right = inputArray.length - 1;
		int rightRange = -1;
		while (left <= right) {
			if (inputArray[Math.floorDiv((left + right), 2)] == ipNumber) {
				if (Math.floorDiv((left + right), 2) < (inputArray.length - 1)
						&& inputArray[Math.floorDiv((left + right), 2) + 1] == ipNumber) {
					left = Math.floorDiv((left + right), 2) + 1;
				} else {
					rightRange = Math.floorDiv((left + right), 2);
					break;
				}
			}

			else if (inputArray[Math.floorDiv((left + right), 2)] < ipNumber) {
				left = Math.floorDiv((left + right), 2) + 1;
			} else {
				right = Math.floorDiv((left + right), 2) - 1;
			}
		}

		return rightRange;
	}

	public static int[] searchRange(int[] inputArray, int number) {
		int[] range = new int[2];
		range[0] = leftRangeBinarySearch(inputArray, number);
		range[1] = rightRangeBinarySearch(inputArray, number);
		return range;
	}

	public static void main(String[] args) {
		int[] range = searchRange(new int[] { 12, 23, 45, 45, 45, 56, 65, 67, 87, 79, 90 }, 45);
		System.out.println(range[0] + " " + range[1]);
		range = searchRange(new int[] { 12, 23, 45, 56, 65, 67, 87, 79, 90 }, 45);
		System.out.println(range[0] + " " + range[1]);
		range = searchRange(new int[] { 12, 23, 56, 65, 67, 87, 79, 90 }, 45);
		System.out.println(range[0] + " " + range[1]);
		range = searchRange(new int[] { 45, 46, 56, 65, 67, 87, 79, 90 }, 45);
		System.out.println(range[0] + " " + range[1]);
		range = searchRange(new int[] { 1, 4, 6, 8, 10, 14, 20, 30, 45 }, 45);
		System.out.println(range[0] + " " + range[1]);
	}

}
