package com.category.simple.dynamic.programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoinDenominationAlgorithmTest {

	@Test
	void testRecurrsion() {
		assertEquals(2, CoinDenominationAlgorithm.getMinimumNumberCoinsUsingRecurrsion(new int[] { 1, 2, 5 }, 6));
		assertEquals(3, CoinDenominationAlgorithm.getMinimumNumberCoinsUsingRecurrsion(new int[] { 1, 2, 5 }, 11));
	}

	@Test
	void testBottomup() {
		assertEquals(2, CoinDenominationAlgorithm.getMinimumNumberCoinsUsingBottomUp(new int[] { 1, 2, 5 }, 6));
		assertEquals(3, CoinDenominationAlgorithm.getMinimumNumberCoinsUsingBottomUp(new int[] { 1, 2, 5 }, 11));
	}

}
