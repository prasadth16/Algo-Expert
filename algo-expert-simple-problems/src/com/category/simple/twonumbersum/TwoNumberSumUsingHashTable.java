package com.category.simple.twonumbersum;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSumUsingHashTable {

	public static void main(String[] args) {
		int[] targetArray = getTwoNumberSum(new int[] { 7, -10, 6, 11, -1, 45 }, 10);
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
		int currentNumber = 0;
		int anotherNumber = 0;
		int[] targetArray = new int[2];
		for (int i : intArray) {
			if (!targetHash.containsKey(targetSum - i)) {
				targetHash.put(i, true);
			} else {
				currentNumber = i;
				anotherNumber = targetSum - i;
				break;
			}
		}
		if (currentNumber != 0 && anotherNumber != 0) {
			if (currentNumber > anotherNumber) {
				targetArray[0] = anotherNumber;
				targetArray[1] = currentNumber;
			} else {
				targetArray[0] = currentNumber;
				targetArray[1] = anotherNumber;
			}
		}
		return targetArray;
	}

}
