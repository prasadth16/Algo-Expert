package com.category.simple;

/**
 * Knuth-Morris-Pratt string Pattern search algorithm Time Complexity: O(m+n)
 * where m is the length of main string and n is the length of the pattern Space
 * Complexity: O(n) Please check the algorithm in Algo Expert for more details.
 **/
public class KnuthMorrisPrattPatternMatchingAlgorithm {

	private static int[] findPatternInsideMatchingString(String matchingString) {
		char[] matchingStringArray = matchingString.toCharArray();
		int[] patternArray = new int[matchingStringArray.length];
		patternArray = initializeIntegerArray(patternArray);
		int i = 0;
		int j = 1;
		while (j < matchingStringArray.length) {
			if (matchingStringArray[i] == matchingStringArray[j]) {
				patternArray[j] = i;
				i++;
				j++;
			} else if (matchingStringArray[i] != matchingStringArray[j] && i == 0) {
				j++;
			} else if (matchingStringArray[i] != matchingStringArray[j] && i > 0) {
				while (i > 0) {
					i--;
					if (patternArray[i] != -1) {
						i = patternArray[i] + 1;
					} else {
						i = 0;
					}
					if (patternArray[i] == patternArray[j]) {
						break;
					}
				}
			}
		}
		return patternArray;
	}

	public static boolean doesItMatch(String mainString, String pattern) {
		int[] patternInsidePattern = findPatternInsideMatchingString(pattern);
		char[] mainStringArray = mainString.toCharArray();
		char[] patternArray = pattern.toCharArray();
		int i = 0;
		int j = 0;
		boolean isMatching = false;

		while (i < mainString.length()) {
			if (mainStringArray[i] == patternArray[j]) {
				if (j == patternArray.length - 1) {
					isMatching = true;
				}
				i++;
				j++;
			}

			else if (mainStringArray[i] != patternArray[j] && j > 0) {
				while (j > 0) {
					j--;
					if (patternInsidePattern[j] != -1) {
						j = patternInsidePattern[j] + 1;
					} else {
						j = 0;
					}
					if (mainStringArray[i] == patternArray[j]) {
						break;
					}
				}
			}
		}

		return isMatching;
	}

	private static int[] initializeIntegerArray(int[] ipArray) {
		for (int i = 0; i < ipArray.length; i++) {
			ipArray[i] = -1;
		}
		return ipArray;
	}

	public static void main(String[] args) {

		System.out.println(doesItMatch("aefaefaefaedaefaedaefaefa", "aefaedaefaefas"));
	}
}
