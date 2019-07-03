package com.category.simple.dynamic.programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TotalNumberOfWaysToMakeChangeTest {

	@Test
	void test() {
		int[] input = new int[] { 2, 3, 4, 7 };
		assertEquals(1, TotalNumberOfWaysToMakeChange.numberOfWaysToMakeChange(input, 0));
		input = new int[] { 5 };
		assertEquals(0, TotalNumberOfWaysToMakeChange.numberOfWaysToMakeChange(input, 9));
	}

}
