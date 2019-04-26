package com.category.simple.twonumbersum;

/**
 * This program has both recursive and iterative binary search implementation.
 * Time complexity of both the implementations is O(log n) but the space
 * complexity of recursive algorithm is O(log n) And space Complexity of
 * iterative algorithm is O(1) as there is no space required for call stack for
 * method invocation.
 **/
public class BinarySearch {

	public static boolean recursiveBinarySearch(Integer[] inputArray, Integer lpointer, Integer rpointer,
			Integer targetSearch) {
		if (lpointer > rpointer)
			return false;
		if (inputArray[(lpointer + rpointer) / 2] == targetSearch)
			return true;
		if (inputArray[(lpointer + rpointer) / 2] > targetSearch)
			rpointer = (lpointer + rpointer) / 2 - 1;
		else
			lpointer = (lpointer + rpointer) / 2 + 1;
		return recursiveBinarySearch(inputArray, lpointer, rpointer, targetSearch);
	}

	public static boolean iterativeBinarySearch(Integer[] inputArray, Integer lpointer, Integer rpointer,
			Integer targetSearch) {
		boolean searchResult = false;
		while (lpointer <= rpointer && !searchResult) {
			if (inputArray[(lpointer + rpointer) / 2] == targetSearch)
				searchResult = true;
			else if (inputArray[(lpointer + rpointer) / 2] > targetSearch)
				rpointer = (lpointer + rpointer) / 2 - 1;
			else
				lpointer = (lpointer + rpointer) / 2 + 1;
		}
		return searchResult;
	}

	public static void main(String[] args) {
		Integer[] inputArray = new Integer[] { 1, 4, 12, 32, 34, 54, 67, 68, 78, 89, 92, 95 };
		System.out.println("Testing Recursive Binary Search!!!!!");

		System.out.println("searching 68 in input array-->" + recursiveBinarySearch(inputArray, 0, 11, 68));
		System.out.println("searching 69 in input array-->" + recursiveBinarySearch(inputArray, 0, 11, 69));
		System.out.println("searching 97 in input array-->" + recursiveBinarySearch(inputArray, 0, 11, 97));
		System.out.println("searching 0 in input array-->" + recursiveBinarySearch(inputArray, 0, 11, 0));

		System.out.println("Testing Iterative Binary Search!!!!!");

		System.out.println("searching 68 in input array-->" + iterativeBinarySearch(inputArray, 0, 11, 68));
		System.out.println("searching 69 in input array-->" + iterativeBinarySearch(inputArray, 0, 11, 69));
		System.out.println("searching 97 in input array-->" + iterativeBinarySearch(inputArray, 0, 11, 97));
		System.out.println("searching 0 in input array-->" + iterativeBinarySearch(inputArray, 0, 11, 0));
	}

}
