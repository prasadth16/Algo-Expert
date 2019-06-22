package com.category.simple.datastructures;

public class HeapSort {
	/**
	 * Method to sort an integer array in ascending order Time Complexity: PushDown
	 * operation in building heap takes only O(log(n)) time. But only root element
	 * requires this much of time. Parent nodes in bottom levels do not need this
	 * much of time. They do this in some constant time. For Heap sort, Building
	 * heap is called n-1 times and hence total time required is n-1*log(n) i.e
	 * O(n*log(n)) As this sorting operation is done in place and Algorithm does not
	 * use any extra space apert from input array Space Complexity is O(1) i.e
	 * Constant space.
	 * 
	 **/

	public static int[] heapSort(int[] ipArray) {
		int lastIndex = ipArray.length - 1;
		while (lastIndex > 0) {
			ipArray = buildHeap(ipArray, lastIndex);
			ipArray = swapArrayElements(ipArray, 0, lastIndex);
			lastIndex--;
		}

		return ipArray;
	}

	private static int[] buildHeap(int[] ipArray, int lastIndex) {
		int index = Math.floorDiv(lastIndex - 1, 2);
		while (index >= 0) {
			pushDown(ipArray, index, lastIndex);
			index--;
		}
		return ipArray;
	}

	private static int[] pushDown(int[] ipArray, int parentIndex, int lastIndex) {
		int childIndex1 = parentIndex * 2 + 1;
		int childIndex2 = parentIndex * 2 + 2;
		int childElement1 = Integer.MIN_VALUE;
		int childElement2 = Integer.MIN_VALUE;
		while (!(childIndex1 > lastIndex && childIndex2 > lastIndex)) {
			childElement1 = childIndex1 <= lastIndex ? ipArray[childIndex1] : Integer.MIN_VALUE;
			childElement2 = childIndex2 <= lastIndex ? ipArray[childIndex2] : Integer.MIN_VALUE;
			if (ipArray[parentIndex] <= childElement1 || ipArray[parentIndex] <= childElement2) {
				if (childElement1 >= childElement2) {
					ipArray = swapArrayElements(ipArray, parentIndex, childIndex1);
					parentIndex = childIndex1;
				} else {
					ipArray = swapArrayElements(ipArray, parentIndex, childIndex2);
					parentIndex = childIndex2;
				}
				childIndex1 = parentIndex * 2 + 1;
				childIndex2 = parentIndex * 2 + 2;
			} else
				break;

		}
		return ipArray;
	}

	private static int[] swapArrayElements(int[] ipArray, int swapIndex1, int swapIndex2) {
		int tmpElement = ipArray[swapIndex1];
		ipArray[swapIndex1] = ipArray[swapIndex2];
		ipArray[swapIndex2] = tmpElement;
		return ipArray;
	}

}
