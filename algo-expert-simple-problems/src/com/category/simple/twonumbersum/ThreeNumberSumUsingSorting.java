package com.category.simple.twonumbersum;

import java.util.ArrayList;
import java.util.List;
/**
 * Complexity Analysis is stright forward:
 * Time Complexity:O(n^2)
 * space complexity: O(n)
 * **/
public class ThreeNumberSumUsingSorting {

	public static List<List<Integer>> threeNumberSumInSortedArray(Integer[] inputSortedArray, Integer targetSum) {

		List<List<Integer>> outputList = new ArrayList<>();
		List<Integer> innerTriplet = null;
		Integer counter = 0;
		Integer leftPointer = counter + 1;
		Integer rightPointer = inputSortedArray.length - 1;
		while (counter <= inputSortedArray.length - 3) {
			while (leftPointer < rightPointer) {
				innerTriplet = new ArrayList<>();
				if (targetSum == inputSortedArray[counter] + inputSortedArray[leftPointer]
						+ inputSortedArray[rightPointer]) {
					innerTriplet.add(inputSortedArray[counter]);
					innerTriplet.add(inputSortedArray[leftPointer]);
					innerTriplet.add(inputSortedArray[rightPointer]);
					outputList.add(innerTriplet);
					leftPointer++;
					rightPointer--;

				} else if (targetSum < inputSortedArray[counter] + inputSortedArray[leftPointer]
						+ inputSortedArray[rightPointer]) {
					rightPointer--;

				} else if (targetSum > inputSortedArray[counter] + inputSortedArray[leftPointer]
						+ inputSortedArray[rightPointer]) {
					leftPointer++;
				}
			}
			counter++;
			leftPointer = counter + 1;
			rightPointer = inputSortedArray.length - 1;
		}

		return outputList;
	}

	public static void main(String[] args) {
		// List<List<Integer>> outputList = threeNumberSumInSortedArray(new Integer[] {
		// 1, 2, 3 }, 6);--passed
		// List<List<Integer>> outputList = threeNumberSumInSortedArray(new Integer[] {
		// 1, 2, 3 }, 7);--passed
		// List<List<Integer>> outputList = threeNumberSumInSortedArray(new Integer[] {
		// 8, 10, -2, 49, 14 }, 57);--passed
		List<List<Integer>> outputList = threeNumberSumInSortedArray(new Integer[] { -8, -6, 1, 2, 3, 5, 6, 12 }, 0);//passed

		for (List<Integer> triplet : outputList) {
			System.out.println(triplet);
		}
	}

}
