package com.category.simple.datastructures.sotingalgorithms;

import java.util.Arrays;
import java.util.Random;

/***
 * This is randomized Quick Sort algorithm implementation. average and best case
 * time Complexity is O(n log n). Most possibly the worst case time complexity
 * will also be O(n log n).
 * 
 **/

public class QuickSortAlgorithm {

	public static void randomizedQuickSort(Integer[] inputArray, Integer startIndex, Integer endIndex) {

		if (startIndex < endIndex) {
			Integer pivotIndex = randomizedPartition(inputArray, startIndex, endIndex);
			randomizedQuickSort(inputArray, startIndex, pivotIndex - 1);
			randomizedQuickSort(inputArray, pivotIndex + 1, endIndex);
		}
		return;

	}

	public static Integer randomizedPartition(Integer[] inputArray, Integer startIndex, Integer endIndex) {

		Integer randomIndex = (new Random().nextInt(endIndex - startIndex) + 1) + startIndex;
		swapElements(inputArray, randomIndex, endIndex);
		Integer PvIndex = startIndex;
		Integer pivotIndex = endIndex;
		Integer counter = startIndex;
		while (counter < endIndex) {
			if (inputArray[counter] < inputArray[pivotIndex]) {
				swapElements(inputArray, counter, PvIndex);
				PvIndex++;
			}
			counter++;
		}
		swapElements(inputArray, PvIndex, pivotIndex);

		return PvIndex;
	}

	public static Integer[] swapElements(Integer[] inputArray, Integer firstIndex, Integer secondIndex) {
		Integer tmpHolder = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = tmpHolder;

		return inputArray;
	}

	public static void main(String[] args) {

		Integer[] candidateArray = new Integer[] { 1, 10, 2, 34, 2, 56, 33, 15, 17, 9, 7, 32, 76 };
		System.out.println("Unsorted Array is: " + Arrays.toString(candidateArray));

		randomizedQuickSort(candidateArray, 0, candidateArray.length - 1);
		System.out.println("Array after sorting Operation: " + Arrays.toString(candidateArray));

	}
}
