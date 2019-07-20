package com.category.simple;

public class LonestPalindromeInString {
	/**
	 * Program to find largest palindrome substring in the given input String Time
	 * Complexity:We are iterating through the whole input string and for every
	 * character on an average we again loop through n/2 times and hence time
	 * complexity is O(n*n/2=>O(n^2) Space Complexity: O(n) as largest palindrome
	 * string is stored and in worst case whole ip string can be largest palindrom.
	 **/
	public static String getLongestPalindrome(String ipString) {
		String longestPalindrome = "";
		int counter = 0;
		int upCounter = 0;
		int downCounter = 0;
		while (counter < ipString.length()) {
			upCounter = 0;
			downCounter = 0;
			// even length Palindrom String
			if ((counter < ipString.length() - 2) && ipString.charAt(counter) == ipString.charAt(counter + 1)) {
				upCounter = counter + 2;
				downCounter = counter - 1;
				if (upCounter < ipString.length() && downCounter >= 0) {
					while ((upCounter < ipString.length() && downCounter >= 0)
							&& ipString.charAt(upCounter) == ipString.charAt(downCounter)) {
						upCounter++;
						downCounter--;
					}
					upCounter--;
					downCounter++;
					longestPalindrome = longestPalindrome.length() <= ipString.substring(downCounter, upCounter + 1)
							.length() ? ipString.substring(downCounter, upCounter + 1) : longestPalindrome;
				} else {
					longestPalindrome = longestPalindrome.length() <= ipString.substring(counter, counter + 1).length()
							? ipString.substring(counter, counter + 1)
							: longestPalindrome;
				}

			}
			// Odd length Palindrome String
			else {
				upCounter = counter + 1;
				downCounter = counter - 1;
				if (upCounter < ipString.length() && downCounter >= 0) {
					while ((upCounter < ipString.length() && downCounter >= 0)
							&& ipString.charAt(upCounter) == ipString.charAt(downCounter)) {
						upCounter++;
						downCounter--;
					}
					upCounter--;
					downCounter++;
					longestPalindrome = longestPalindrome.length() <= ipString.substring(downCounter, upCounter + 1)
							.length() ? ipString.substring(downCounter, upCounter + 1) : longestPalindrome;
				} else {
					longestPalindrome = longestPalindrome.length() <= ipString.substring(counter, counter + 1).length()
							? ipString.substring(counter, counter + 1)
							: longestPalindrome;
				}

			}
			counter++;
		}

		return longestPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(getLongestPalindrome("abaxyxxyxf"));
		System.out.println(getLongestPalindrome("It's a highnoon"));
	}
}
