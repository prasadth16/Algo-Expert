package com.category.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * pper bound of the time complexity is O(n(m+n)) where m=length of patteren and
 * n is length of input string o(m+n) is the time complexity for patterrn
 * matching. Space complexity: O(n)
 * 
 * For more on time complexity please check algo expert problm explaination.
 * 
 **/

public class UnderscorifyStringMatcher {

	public static String underscoreString(String ipString, String underscoreString) {
		List<List<Integer>> underscorePositions = findPosition(ipString, underscoreString);
		underscorePositions = collapseArrays(underscorePositions);
		return addUnderscoreToString(underscorePositions, ipString, underscoreString);
	}

	// This method finds out the positiions of the patteren in the given input
	// string
	private static List<List<Integer>> findPosition(String ipString, String underscoreString) {
		int fromIndex = 0;
		int startIndex = 0;
		List<List<Integer>> unFlattenedPositions = new ArrayList<>();
		while (startIndex != -1) {
			startIndex = ipString.indexOf(underscoreString, fromIndex);
			if (startIndex != -1) {
				List<Integer> position = new ArrayList<>();
				position.add(startIndex);
				position.add(startIndex + underscoreString.length());
				unFlattenedPositions.add(position);
				fromIndex = startIndex + 1;
			}
		}
		return unFlattenedPositions;
	}

	// This method flatterens the positions if patterens are consecutively place one
	// after the other.
	private static List<List<Integer>> collapseArrays(List<List<Integer>> inputList) {
		for (int i = 1; i < inputList.size(); i++) {
			List<Integer> current = inputList.get(i);
			List<Integer> previous = inputList.get(i - 1);

			if (previous.get(1) >= current.get(0)) {
				previous.set(1, current.get(1));
				inputList.remove(i);
				i--;
			}

		}
		return inputList;
	}

	// this method actually creates the output string with "_"
	private static String addUnderscoreToString(List<List<Integer>> underscorePositions, String inputString,
			String pattern) {
		String opString = "";
		int counter = 0;
		// loop over the positions to add "_" and merge the original string
		for (List<Integer> position : underscorePositions) {
			opString = opString + inputString.substring(counter, position.get(0));
			opString = opString + "_";
			counter = position.get(1);
			// if there are more than 1 occurences of patterens back to back or overlapping
			int times = ((position.get(1)) - (position.get(0))) / pattern.length();
			for (int i = 0; i < times; i++) {
				opString = opString + pattern;
			}
			opString = opString + "_";
		}
		// taking care of left over string
		if (counter < inputString.length()) {
			opString = opString + inputString.substring(counter);
		}

		return opString;
	}

	public static void main(String[] args) {
		System.out.println(underscoreString("testthis is a testtest to see if testtesttest it works", "test"));
	}

}
