package com.category.simple.twonumbersum;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SmallestDifferrenceAlgorithmTest {

	@Test
	void test() {
		int[] ipArray1 = new int[] { 2, 27, 34, 67, 89, 127, 156 };
		int[] ipArray2 = new int[] { 5, 16, 20, 67, 78, 90, 100, 101 };

		assertArrayEquals(new int[] { 67, 67 }, SmallestDifferrenceAlgorithm.findSmallestDiffernce(ipArray1, ipArray2));

		ipArray1 = new int[] { 2, 27, 34, 47, 89, 90, 156 };
		ipArray2 = new int[] { 5, 16, 20, 67, 78, 91, 100, 101 };
		assertArrayEquals(new int[] { 90, 91 }, SmallestDifferrenceAlgorithm.findSmallestDiffernce(ipArray1, ipArray2));
		
		ipArray1 = new int[] { 2, 27, 34, 47, 89, 90, 156 };
		ipArray2 = new int[] { -5, 16, 20, 67, 78, 91, 100, 101 };
		assertArrayEquals(new int[] { 90, 91 }, SmallestDifferrenceAlgorithm.findSmallestDiffernce(ipArray1, ipArray2));
	}

}
