package com.category.simple;

public class ShiftedBinarySearch {

	public static int searchIndexOfNumber(int[] inputArray, int number) {
		int index = -1;
		int bign = 0;
		int end = inputArray.length - 1;
		int mid = Math.floorDiv((bign + end), 2);
		while (bign <= end) {
			// search in first half when first half is sorted
			if (inputArray[mid] == number) {
				index = mid;
				break;
			}
			// search in second half when second half is sorted
			if (inputArray[bign] <= inputArray[mid] && number >= inputArray[bign] && number <= inputArray[mid]) {
				end = mid - 1;
				mid = Math.floorDiv((bign + end), 2);
			}

			else if (inputArray[mid] <= inputArray[end] && number >= inputArray[mid] && number <= inputArray[end]) {
				bign = mid + 1;
				mid = Math.floorDiv((bign + end), 2);
			} else if ((inputArray[mid] > inputArray[end])) {
				while (inputArray[++mid] > inputArray[end]) {
					if (inputArray[mid] == number) {
						index = mid;
						break;
					}

				}
				if (inputArray[mid] == number) {
					index = mid;
					break;
				}
				if (number >= inputArray[mid] && number <= inputArray[end]) {
					bign = mid;
					mid = Math.floorDiv((bign + end), 2);

				} else {
					break;
				}

			} else if ((inputArray[mid] < inputArray[bign])) {
				while (inputArray[--mid] < inputArray[bign]) {
					if (inputArray[mid] == number) {
						index = mid;
						break;
					}
				}
				if (inputArray[mid] == number) {
					index = mid;
					break;
				}
				if (number <= inputArray[mid] && number >= inputArray[bign]) {
					end = mid;
					mid = Math.floorDiv((bign + end), 2);
				} else {
					break;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// int foundAt = searchIndexOfNumber(new int[] { 61, 71, 78, 80, 0, 23, 46, 52,
		// 59, 60 }, 52);
		// int foundAt = searchIndexOfNumber(new int[] { 61, 71, 78, 80, 0, 23, 46, 52,
		// 59 }, 52);
		// int foundAt = searchIndexOfNumber(new int[] { 59, 60, 61, 71, 78, 80, 0, 23,
		// 46, 52 }, 52);
		//int foundAt = searchIndexOfNumber(new int[] { 59, 60, 61, 71, 78, 80, 0, 23, 46, 52 }, 57);
		int foundAt = searchIndexOfNumber(new int[] { 59, 60, 61, 71, 78, 80, 0, 23, 46 }, 80);
		if (foundAt > -1) {
			System.out.println("Number found at an Index :" + foundAt);
		} else {
			System.out.println("Number does not exists in an input Array.");
		}
	}
}
