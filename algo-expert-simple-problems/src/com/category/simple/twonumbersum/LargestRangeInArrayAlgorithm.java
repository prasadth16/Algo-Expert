package com.category.simple.twonumbersum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Program to find the largest range present in the given input array. Space
 * Complexity: O(n) where n is the number of elements present in the input
 * array. Time complexity: O(n): We iterated through the array once to put them
 * in hash table. Then we iterated through the array again and do processing for
 * each number only once and mark that number as false in the hash map. Hence
 * the time complexity=> O(2n)=> O(n)
 **/
public class LargestRangeInArrayAlgorithm {
	private static Map<Integer, Boolean> integerMap = new HashMap<>();
	private static List<List<Integer>> opRange = new ArrayList<>();

	public static List<Integer> getLargestRange(int[] inputArray) {
		populateHashTable(inputArray);
		List<Integer> rangeList = null;
		for (int i = 0; i < inputArray.length; i++) {
			if (integerMap.get(inputArray[i])) {
				integerMap.put(inputArray[i], false);

				int counter = 1;
				rangeList = new ArrayList<>();
				rangeList.add(inputArray[i]);
				// Decrement sequence
				while (true) {
					if (integerMap.containsKey(inputArray[i] - counter)) {
						rangeList.add(inputArray[i] - counter);
						integerMap.put(inputArray[i] - counter, false);
					} else {
						break;
					}
					counter++;
				}
				counter = 1;
				// Increment Sequence
				while (true) {
					if (integerMap.containsKey(inputArray[i] + counter)) {
						rangeList.add(inputArray[i] + counter);
						integerMap.put(inputArray[i] + counter, false);
					} else {
						break;
					}
					counter++;
				}
			}
			if (rangeList != null && rangeList.size() > 0)
				opRange.add(rangeList);
			rangeList = null;
		}

		return opRange.stream().max((a, b) -> a.size() >= b.size() ? 1 : -1).get();
	}

	private static void populateHashTable(int[] inputArray) {
		Arrays.stream(inputArray).forEach(i -> integerMap.put(i, true));
	}

	public static void main(String[] args) {
		List<Integer> largestRange = getLargestRange(new int[] { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6 });
		System.out.println("Found the largest number!!!");
	}
}
