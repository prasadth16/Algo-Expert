package com.category.simple.datastructures.sotingalgorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeCheckTest {

	@Test
	void test() {
		assertFalse(PalindromeCheck.isPalindrome("baba"));
		assertTrue(PalindromeCheck.isPalindrome("abcdcba"));
	}

}
