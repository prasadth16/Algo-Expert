package com.category.simple.datastructures.sotingalgorithms;

import java.util.Arrays;

/**
 * This is the implementation of merge sort.
 * Worst case time Complexity of this sort is O(n log n)
 * **/
public class MergeSortAlgorithm {

	public static void mergeSortAlgorithmImplementation(Integer[] inputArray) {
		Integer[] firstChild = null;
		Integer[] secondChild = null;

		if (inputArray.length > 1) {
			if (inputArray.length == 2) {
				firstChild = copyArray(inputArray, 0, 0);
				secondChild = copyArray(inputArray, 1, 1);

			} else {
				firstChild = copyArray(inputArray, 0, ((inputArray.length - 1) / 2));
				secondChild = copyArray(inputArray, ((inputArray.length - 1) / 2) + 1, inputArray.length - 1);
			}
			mergeSortAlgorithmImplementation(firstChild);
			mergeSortAlgorithmImplementation(secondChild);
			mergeArraysIntoParent(inputArray, firstChild, secondChild);
		}
		
		return;
	}

	public static Integer[] copyArray(Integer[] InputArray, Integer startIndex, Integer endIndex) {

		Integer startCopy = startIndex;
		Integer endCopy = endIndex;
		Integer targetIndex = 0;
		Integer[] targetArray = new Integer[(endIndex - startIndex) + 1];
		while (startCopy <= endCopy) {
			targetArray[targetIndex] = InputArray[startCopy];
			targetIndex++;
			startCopy++;
		}
		return targetArray;
	}

	public static void mergeArraysIntoParent(Integer[] parentArray, Integer[] firstChild, Integer[] secondChild) {
		Integer parentpositionCounter = 0;
		Integer firstChildPositionCounter = 0;
		Integer secondChildPositionCounter = 0;

		while (firstChildPositionCounter <= firstChild.length - 1
				&& secondChildPositionCounter <= secondChild.length - 1) {
			if (firstChild[firstChildPositionCounter] <= secondChild[secondChildPositionCounter]) {
				parentArray[parentpositionCounter] = firstChild[firstChildPositionCounter];
				firstChildPositionCounter++;
			} else {
				parentArray[parentpositionCounter] = secondChild[secondChildPositionCounter];
				secondChildPositionCounter++;

			}
			parentpositionCounter++;
		}

		while (firstChildPositionCounter <= firstChild.length - 1) {
			parentArray[parentpositionCounter] = firstChild[firstChildPositionCounter];
			parentpositionCounter++;
			firstChildPositionCounter++;
		}
		while (secondChildPositionCounter <= secondChild.length - 1) {
			parentArray[parentpositionCounter] = secondChild[secondChildPositionCounter];
			parentpositionCounter++;
			secondChildPositionCounter++;
		}
	}

	public static void main(String[] args) {
		Integer[] candidateArray = new Integer[] { 1, 10, 2, 34, 2, 56, 33, 15, 17, 9, 7, 32, 76 };
		System.out.println("Unsorted Array is: " + Arrays.toString(candidateArray));

		mergeSortAlgorithmImplementation(candidateArray);
		System.out.println("Array after sorting Operation: " + Arrays.toString(candidateArray));
	}
}
