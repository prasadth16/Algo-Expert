package com.category.simple.datastructures;

public class HeapOperations {

	/**
	 * Building Heap: IP Parameters: ip int array and Actual Elments in the array.
	 * OP Parameters: Array transformed into a Min Heap. Description: We are
	 * starting from lowest avaiable parent in the given ip array and make our way
	 * up fixing the parents one after the other. Every parent will be pushed down
	 * the tree until it is in the right position. shift down logic's time
	 * complexity is O(log n) as there might be maximum log n shifts required. We
	 * need to do it for every parnt but roughly we can say that we have to do it n
	 * times as there are n nodes in the tree. So the appearent time complexity is
	 * O(n log n). But when we start shifting from the bottom of the tree, most of
	 * the parents need fixed number of shifts. Only the root node will need log n
	 * shift so actual time complexity is O(n). But if we start at the root node and
	 * start shifting nodes up then the complexity will be O(n log n), because
	 * except root node all the nodes in the bottom of the tree need log n shifts.
	 * 
	 * As we are doing in place transformation, the space complexity is O(1) or
	 * constant time.
	 **/
	public static int[] buildHeap(int[] ipArray, int actualLength) {

		int index = Math.floorDiv(actualLength - 1, 2) < (actualLength - 1) / 2
				? (Math.floorDiv(actualLength - 1, 2)) - 1
				: Math.floorDiv(actualLength - 1, 2);

		while (index >= 0) {
			ipArray = shiftDown(ipArray, index);
			index--;
		}
		return ipArray;
	}

	public static int[] shiftUp(int[] ipArray, int index) {

		return ipArray;
	}

	public static int[] shiftDown(int[] ipArray, int ipIndex) {
		int chldIndx1 = (ipIndex * 2) + 1;
		int chldIndx2 = (ipIndex * 2) + 2;

		while (!(chldIndx1 > ipArray.length && chldIndx2 > ipArray.length)) {// Assumed here
			// that
			// Integer.MAX_VALUE
			// cannot be
			// present in
			// Heap
			if (ipArray[ipIndex] > ipArray[chldIndx1] || ipArray[ipIndex] > ipArray[chldIndx2]) {
				if (ipArray[chldIndx1] <= ipArray[chldIndx2]) {
					swapElements(ipArray, ipIndex, chldIndx1);
					ipIndex = chldIndx1;
				} else {
					swapElements(ipArray, ipIndex, chldIndx2);
					ipIndex = chldIndx2;
				}
			} else {
				break;
			}
			chldIndx1 = (ipIndex * 2) + 1;
			chldIndx2 = (ipIndex * 2) + 2;
		}

		return ipArray;
	}

	public static int[] insertElement(int[] ipArray, int value) {
		return ipArray;
	}

	public static int[] deleteElement(int[] ipArray) {

		return ipArray;
	}

	public static int[] swapElements(int[] ipArray, int index1, int index2) {
		int tempValue = ipArray[index1];
		ipArray[index1] = ipArray[index2];
		ipArray[index2] = tempValue;

		return ipArray;
	}
}
