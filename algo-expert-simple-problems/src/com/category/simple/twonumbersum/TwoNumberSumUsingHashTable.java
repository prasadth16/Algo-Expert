package com.category.simple.twonumbersum;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n) where n=number of elements in the input array. As we
 * are iterating through the array at least once space Complexity: O(n) where
 * n=number of elements in the input array. As we are creating Hash Table
 **/
public class TwoNumberSumUsingHashTable {

	public static void main(String[] args) {
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
		Map<Integer, Boolean> targetHash = new HashMap<>();
		Integer currentNumber = null;
		Integer anotherNumber = null;
		int[] targetArray;
		for (int i : intArray) {

			if (!targetHash.containsKey(targetSum - (i))) {
				targetHash.put(i, true);
			} else {
				currentNumber = i;
				anotherNumber = (targetSum - (i));
				break;
			}
		}
		if (currentNumber != null && anotherNumber != null) {
			targetArray = new int[2];
			if (currentNumber > anotherNumber) {
				targetArray[0] = anotherNumber;
				targetArray[1] = currentNumber;
			} else {
				targetArray[0] = currentNumber;
				targetArray[1] = anotherNumber;
			}
		} else {
			targetArray = new int[] {};
		}
		return targetArray;
	}

}
