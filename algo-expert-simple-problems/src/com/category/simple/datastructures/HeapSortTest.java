package com.category.simple.datastructures;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static com.category.simple.datastructures.HeapSort.heapSort;

import org.junit.jupiter.api.Test;

class HeapSortTest {

	@Test
	void testHeapSort() {
		int[] ipArray = new int[] { 5, 9, 10, 1, 6, 3, 24, 29 };
		int[] opArray = new int[] { 1, 3, 5, 6, 9, 10, 24, 29 };
		assertArrayEquals(opArray, heapSort(ipArray));

		ipArray = new int[] { 5, 9, 10, 1, 6, 3, 24, 29, 13 };
		opArray = new int[] { 1, 3, 5, 6, 9, 10, 13, 24, 29 };
		assertArrayEquals(opArray, heapSort(ipArray));
	}

}