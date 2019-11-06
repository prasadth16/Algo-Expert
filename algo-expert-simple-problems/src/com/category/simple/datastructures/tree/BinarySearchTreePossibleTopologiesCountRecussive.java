package com.category.simple.datastructures.tree;

/*
 * Refer https://www.youtube.com/watch?v=kT_VabdscHk 
 * Time complexity=O(n^2)
 * Space Complexity= O(n)
 * */

public class BinarySearchTreePossibleTopologiesCountRecussive {
	private static int[] MEMOISATION_ARRAY;

	public static void main(String[] args) {
		System.out.println(determineTopolgyCount(5));
	}

	private static int determineTopolgyCount(int nodes) {
		MEMOISATION_ARRAY = new int[nodes+1];
		MEMOISATION_ARRAY[0] = MEMOISATION_ARRAY[1] = 1;
		return topologyCountRecurssive(nodes);
	}

	private static int topologyCountRecurssive(int nodes) {
		int left = 0, right = 0;
		int topoCount = 0;
		int actualNodes = 0;
		if (MEMOISATION_ARRAY[nodes] != 0) {
			return MEMOISATION_ARRAY[nodes];

		} else {
			actualNodes = nodes - 1;
			for (int i = 0; i <= actualNodes; i++) {
				left = i;
				right = actualNodes - i;
				topoCount += topologyCountRecurssive(left) * topologyCountRecurssive(right);
				MEMOISATION_ARRAY[nodes] = topoCount;
			}
		}
		return topoCount;
	}

}
