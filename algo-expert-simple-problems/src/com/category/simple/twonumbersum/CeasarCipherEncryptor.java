package com.category.simple.twonumbersum;

import java.util.Arrays;
import java.util.List;

public class CeasarCipherEncryptor {

	private static List<Character> charRepo;
	static {
		charRepo = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
	}
	/**
	 * Program for simple encoding the String based on the key.
	 * if the key is greater than the repository then use MOD operator to convert it to the smaller number.
	 * Logic of an Algorithm: Every letter in the input string will be replaced with the letter at the position of ->position of the current letter+key
	 * if the new letter position is greater than letter repository then use formula->
	 * ((stating index position in repository-1)+new position%last index position in the repository))
	 * Time Complexity: O(n) where n are the number of the letters in the input string.
	 * Note: we consider here that operation at line 31 is constant time operation.
	 * if it is not then the time complexity is O(n*m)
	 * Space Complexity: O(n) where n are the number of the letters in the input string
	 * because we need to create the output character array of equal length as of input string
	 * **/
	public static String CeasarCipher(String ipString, int key) {
		char[] ipCharArray = ipString.toCharArray();
		char[] opCharArray = new char[ipCharArray.length];
		int charIndex = -5;
		if (key > 25) {
			key = key % 26;
		}
		int counter = 0;
		for (char ipChar : ipCharArray) {
			charIndex = charRepo.indexOf(ipChar);
			charIndex = charIndex + key;
			if (charIndex > 25) {
				charIndex = (-1 + charIndex % 25);
			}
			opCharArray[counter] = charRepo.get(charIndex);
			counter++;
		}
		
		return String.valueOf(opCharArray);
	}
}
