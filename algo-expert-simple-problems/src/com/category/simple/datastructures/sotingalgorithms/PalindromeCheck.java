package com.category.simple.datastructures.sotingalgorithms;

public class PalindromeCheck {
	/**
	 * Time Complexity: O(n) considering that conversion from string to character array conversion as constant time operation.
	 * Space Complexity: As we are converting input String into character Array
	 * we need space of O(n) else we need constant space.
	 * **/
	public static boolean isPalindrome(String inputString) {
		char[] ipArray=inputString.toCharArray();
		int forwardCounter=0;
		int backwardCounter=ipArray.length-1;
		boolean isPalindrome=true;
		while(forwardCounter<backwardCounter) {
			if(!(ipArray[forwardCounter]==ipArray[backwardCounter])) {
				isPalindrome=false;
				break;
			}
			forwardCounter++;
			backwardCounter--;
		}
		
		return isPalindrome;
	}

}
