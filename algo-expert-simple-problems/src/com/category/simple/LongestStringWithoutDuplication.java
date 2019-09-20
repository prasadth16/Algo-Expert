package com.category.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n) Space complexity: O(min(n,n-duplicates)) Where n is the
 * total number of characters in the given input string
 **/
public class LongestStringWithoutDuplication {
	public static String getLongestSubStringWithoutDuplication(String inputString) {
		Map<Character, Integer> hash = new HashMap<>();
		int start = 0;
		char[] inputChars = inputString.toCharArray();
		String opString = "";
		String contProcess = "";
		for (int i = 0; i < inputChars.length; i++) {
			Character processChar = inputChars[i];
			if (hash.get(processChar) != null) {
				start = Math.max(start, hash.get(processChar) + 1);
				contProcess = "";
				for (int j = start; j <= i; j++) {
					processChar = inputChars[j];

					contProcess = contProcess + processChar;
				}
			} else {
				contProcess = contProcess + processChar;
			}
			hash.put(processChar, i);
			if (contProcess.length() > opString.length()) {
				opString = contProcess;
			}
		}

		return opString;
	}

	public static void main(String[] args) {
		System.out.println(getLongestSubStringWithoutDuplication("clementisacap"));
	}

}
