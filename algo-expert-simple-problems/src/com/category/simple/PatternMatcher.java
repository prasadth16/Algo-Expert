package com.category.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Space Complexity: O(n) where n is length of input string and M is the length
 * of pattern. We are storing the X and Y string which takes approximately n
 * size. Time Complexity: O(n+m) as first two method iterate over the pattern
 * and the last function iterate almost n times in worst case when pattern does
 * not exist.
 **/
public class PatternMatcher {

	public static void matchPattern(String pattern, String inputString) {
		String modifiedPattern = getmodifiedPattern(pattern);
		Map<String, Integer> patternStats = getPatternStats(modifiedPattern);
		Optional<Map<String, String>> matchedPattern = findThePattern(modifiedPattern, inputString, patternStats);
		if (matchedPattern.isPresent()) {
			Map<String, String> finalPatternMap = matchedPattern.get();

			System.out.println("X is: " + finalPatternMap.get("X") + " and Y is: " + finalPatternMap.get("Y"));
		} else {
			System.out.println("No pattern Found!!!!!");
		}

	}

	// We always want the pattern to start with "X". If not then we will update the
	// pattern
	public static String getmodifiedPattern(String pattern) {

		String modifiedPattern = "";
		if (pattern.indexOf("X") == 0) {
			modifiedPattern = pattern;
		} else {

			for (int i = 0; i < pattern.toCharArray().length; i++) {
				if (pattern.toCharArray()[i] == 'X') {
					modifiedPattern = modifiedPattern + "Y";
				} else if (pattern.toCharArray()[i] == 'Y') {
					modifiedPattern = modifiedPattern + "X";
				}
			}
		}

		return modifiedPattern;
	}

	// Get the information about the number of occurances of X and Y and starting
	// index of Y
	public static Map<String, Integer> getPatternStats(String pattern) {
		int numberOfX = 0;
		int numberOfY = 0;
		int yIndex = pattern.indexOf("Y");
		Map<String, Integer> stats = new HashMap<String, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.toCharArray()[i] == 'X')
				numberOfX++;
			else if (pattern.toCharArray()[i] == 'Y') {
				numberOfY++;
			}
		}

		stats.put("X", numberOfX);
		stats.put("Y", numberOfY);
		stats.put("YINDEX", yIndex);
		return stats;
	}

	// actual algorithm to find the pattern.
	public static Optional<Map<String, String>> findThePattern(String pattern, String ipString,
			Map<String, Integer> patternStats) {
		String x = "";
		String y = "";
		int xLenght = 1;// assume the length of x string as 1
		int yLength = 0;
		String finalPattern = "";
		Map<String, String> resultMap = null;
		// if both X and Y present in the pattern
		if (patternStats.get("Y") != 0) {
			yLength = (ipString.length() - (xLenght * patternStats.get("X"))) / patternStats.get("Y");
			x = ipString.substring(0, xLenght);
			y = ipString.substring(xLenght * patternStats.get("YINDEX"),
					(xLenght * patternStats.get("YINDEX")) + yLength);
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.toCharArray()[i] == 'X') {
					finalPattern = finalPattern + x;
				} else if (pattern.toCharArray()[i] == 'Y') {
					finalPattern = finalPattern + y;
				}

			}
			while (!finalPattern.equals(ipString) && xLenght < ipString.length()) {
				finalPattern = "";
				xLenght++;
				yLength = (ipString.length() - (xLenght * patternStats.get("X"))) / patternStats.get("Y");
				// determine String X
				x = ipString.substring(0, xLenght);
				// Determine String Y
				if (xLenght < ipString.length() && yLength > 0)
					y = ipString.substring(xLenght * patternStats.get("YINDEX"),
							(xLenght * patternStats.get("YINDEX")) + yLength);
				// Form the final String using X and Y
				for (int i = 0; i < pattern.length(); i++) {
					if (pattern.toCharArray()[i] == 'X') {
						finalPattern = finalPattern + x;
					} else if (pattern.toCharArray()[i] == 'Y') {
						finalPattern = finalPattern + y;
					}

				}
			}
			// Only X is present in the pattern
		} else {
			x = ipString.substring(0, ipString.length() / patternStats.get("X"));
			y = "";
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.toCharArray()[i] == 'X') {
					finalPattern = finalPattern + x;
				} else if (pattern.toCharArray()[i] == 'Y') {
					finalPattern = finalPattern + y;
				}

			}
		}
		if (finalPattern.equals(ipString)) {
			resultMap = new HashMap<>();
			resultMap.put("X", x);
			resultMap.put("Y", y);
		}

		return Optional.ofNullable(resultMap);
	}

	public static void main(String[] args) {
		matchPattern("YYXYYX", "gogocodeninjagogocodeninja");
		matchPattern("YYYY", "gogogogo");
		matchPattern("YYXYYX", "gogocodeninjagogocodenin");
	}

}
