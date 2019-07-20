package com.category.simple;

/**
 * Program to find if the string is Palindrome String time complexity:
 * O(n/2)=>O(n) Space Complexity: O(1)
 **/
public class CheckIfPalindrome {

	public static boolean isPalindrome(String ipString) {
		int stringLength = ipString.length();
		int downCounter = 0;
		int upCounter = 0;
		boolean isValidPalindrom = true;
		int middle = stringLength / 2;
		if (stringLength % 2 > 0) {
			downCounter = middle - 1;
			upCounter = middle + 1;
			while (downCounter >= 0) {
				if (ipString.charAt(downCounter) != ipString.charAt(upCounter)) {
					isValidPalindrom = false;
					break;
				} else {
					downCounter--;
					upCounter++;
				}
			}
		} else {
			upCounter = middle;
			downCounter = middle - 1;
			while (downCounter >= 0) {
				if (ipString.charAt(downCounter) != ipString.charAt(upCounter)) {
					isValidPalindrom = false;
					break;
				} else {
					downCounter--;
					upCounter++;
				}
			}
		}
		return isValidPalindrom;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("aba"));
		System.out.println(isPalindrome("abcdefghhgfedcba"));
		System.out.println(isPalindrome("abcd"));
	}
}
