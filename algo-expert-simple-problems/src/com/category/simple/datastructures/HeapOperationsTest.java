package com.category.simple.datastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeapOperationsTest {

	@Test
	void test() {
		int[] ipArray = { 17, 5, 14, 23, 9, 21, 37, 2, Integer.MAX_VALUE };
		int[] expectedArray = { 2, 5, 14, 17, 9, 21, 37, 23, Integer.MAX_VALUE };
		assertArrayEquals(expectedArray, HeapOperations.buildHeap(ipArray, 8));
	}

}
