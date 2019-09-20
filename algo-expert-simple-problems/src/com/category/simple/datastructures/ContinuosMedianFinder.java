package com.category.simple.datastructures;

import java.util.stream.Stream;
/**Find the continuos MEdian
 * Time complexity: O(log n)
 * Space complexity: O(n)
 * **/
public class ContinuosMedianFinder {

	public static void main(String[] args) {
		double[] medians = findContinuosMedian(new int[] { 4, 10, 1, 7, 5, 9, 13 });
		System.out.println("Medians are: ");
		Stream.of(medians).forEach(System.out::println);
	}

	public static double[] findContinuosMedian(int[] ipNumberArray) {
		int[] maxHeapArraty = new int[ipNumberArray.length];
		int[] minHeapArraty = new int[ipNumberArray.length];
		int minHeapSize = 0;
		int maxHeapSize = 0;
		double[] median = new double[ipNumberArray.length];
		int medianCounter = 0;
		maxHeapArraty[0] = ipNumberArray[0];
		maxHeapSize++;
		median[0] = (double) ipNumberArray[0];
		medianCounter++;
		for (int i = 1; i < ipNumberArray.length; i++) {
			if (maxHeapArraty[0] <= ipNumberArray[i]) {
				minHeapArraty[minHeapSize] = ipNumberArray[i];
				minHeapArraty = shiftUpForMinHeap(minHeapArraty, minHeapSize);
				minHeapSize++;
			} else {
				maxHeapArraty[maxHeapSize] = ipNumberArray[i];
				maxHeapArraty = shiftUpForMaxHeap(maxHeapArraty, maxHeapSize);
				maxHeapSize++;
			}
			// Balancing the mean and max heap
			if (Math.subtractExact(minHeapSize, maxHeapSize) == 2) {
				maxHeapArraty[maxHeapSize] = minHeapArraty[0];
				maxHeapArraty = shiftUpForMaxHeap(maxHeapArraty, maxHeapSize);
				maxHeapSize++;
				minHeapArraty = copyMinHeapAray(minHeapArraty, minHeapSize);
				minHeapSize--;
			}
			// balancing mean and max heap
			else if (Math.subtractExact(maxHeapSize + 1, minHeapSize + 1) == 2) {
				minHeapArraty[minHeapSize] = maxHeapArraty[0];
				minHeapArraty = shiftUpForMinHeap(minHeapArraty, minHeapSize);
				minHeapSize++;
				maxHeapArraty = copyMaxHeapAray(maxHeapArraty, maxHeapSize);
				maxHeapSize--;
			}
			// finding the mean and inserting it into an array.
			if ((maxHeapSize + minHeapSize) % 2 == 0) {
				median[medianCounter] = ((double)minHeapArraty[0] + (double)maxHeapArraty[0]) / 2;

			} else {
				if (maxHeapSize > minHeapSize) {
					median[medianCounter] = maxHeapArraty[0];
				} else {
					median[medianCounter] = minHeapArraty[0];
				}

			}
			medianCounter++;
		}
		return median;
	}
	
	private static int[] copyMinHeapAray(int[] original, int length) {
		int[] copy = CopyArrayRange(original, length);
		int[] finalCopy = new int[copy.length];
		for (int i = 0; i < length-1; i++) {
			finalCopy[i] = copy[i];
			finalCopy = shiftUpForMinHeap(finalCopy, i);
		}
		return finalCopy;
	}

	private static int[] copyMaxHeapAray(int[] original, int length) {
		int[] copy = CopyArrayRange(original, length);
		int[] finalCopy = new int[copy.length];
		for (int i = 0; i < length-1; i++) {
			finalCopy[i] = copy[i];
			finalCopy = shiftUpForMaxHeap(finalCopy, i);
		}
		return finalCopy;
	}

	private static int[] CopyArrayRange(int[] original, int length) {
		int[] copy = new int[original.length];
		for (int i = 1; i < length; i++) {
			copy[i - 1] = original[i];
		}
		return copy;
	}

	/**
	 * Time Complexity O(log n) Space Complexity O(1)
	 **/
	public static int[] shiftUpForMinHeap(int[] ipArray, int index) {
		int prntindx = Math.floorDiv(index - 1, 2);
		if (index > 0) {
			while (true) {
				if (prntindx >= 0 && ipArray[prntindx] >= ipArray[index]) {
					ipArray = swapElements(ipArray, prntindx, index);
					index = prntindx;
					prntindx = Math.floorDiv(index - 1, 2);
				} else {
					break;
				}
			}
		}
		return ipArray;
	}

	/**
	 * Time Complexity O(log n) Space Complexity O(1)
	 **/
	public static int[] shiftUpForMaxHeap(int[] ipArray, int index) {
		int prntindx = Math.floorDiv(index - 1, 2);
		if (index > 0) {
			while (true) {
				if (prntindx >= 0 && ipArray[prntindx] <= ipArray[index]) {
					ipArray = swapElements(ipArray, prntindx, index);
					index = prntindx;
					prntindx = Math.floorDiv(index - 1, 2);
				} else {
					break;
				}
			}
		}
		return ipArray;
	}

	public static int[] swapElements(int[] ipArray, int index1, int index2) {
		int tempValue = ipArray[index1];
		ipArray[index1] = ipArray[index2];
		ipArray[index2] = tempValue;

		return ipArray;
	}
}
