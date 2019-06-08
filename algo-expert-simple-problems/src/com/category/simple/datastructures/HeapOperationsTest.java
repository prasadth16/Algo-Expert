package com.category.simple.datastructures;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HeapOperationsTest {

	@Test
	void testHeapConstruction() {
		int[] ipArray = { 17, 5, 14, 23, 9, 21, 37, 2, Integer.MAX_VALUE };
		int[] expectedArray = { 2, 5, 14, 17, 9, 21, 37, 23, Integer.MAX_VALUE };
		assertArrayEquals(expectedArray, HeapOperations.buildHeap(ipArray, 8));
	}

	@Test
	void testShift_Up() {
		int[] ipArray = { 2, 5, 14, 17, 9, 21, 37, 23, 4 };
		int[] expectedArray = { 2, 4, 14, 5, 9, 21, 37, 23, 17 };
		assertArrayEquals(expectedArray, HeapOperations.shiftUp(ipArray, ipArray.length - 1));
	}

	@Test
	void test_Insert_Element() {
		int[] ipArray = { 2, 5, 14, 17, 9, 21, 37, 23, Integer.MAX_VALUE };
		int[] expectedArray = { 2, 4, 14, 5, 9, 21, 37, 23, 17 };
		assertArrayEquals(expectedArray, HeapOperations.insertElement(ipArray, 4));
	}

	@Test
	void test_delete_element() {
		int[] ipArray = { 2, 4, 14, 5, 9, 21, 37, 23, 17 };
		int[] expectedArray = { 4, 5, 14, 17, 9, 21, 37, 23 ,Integer.MAX_VALUE};
		assertArrayEquals(expectedArray, HeapOperations.deleteElement(ipArray));
	}

}
