package com.category.simple;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequenceAlgorithm {
	/**
	 * Method 1: Time Complexity: O(m*n) Space Complexity: O(m*n)
	 **/
	public static List<Character> getLongestCommonSubsequenceAlgorithm(String ipString1, String ipString2) {

		List<Character> commonSubsequence = null;
		int[][][] ipMetrix = new int[ipString1.length() + 1][ipString2.length() + 1][];
		ipMetrix = initializeMetrix(ipMetrix);// Initializing ipMetrix with an integer array of size 4.
		for (int i = 1; i < ipMetrix.length; i++) {
			for (int j = 1; j < ipMetrix[0].length; j++) {
				int[] tmpArray = ipMetrix[i][j];
				if (ipString1.charAt(i - 1) == ipString2.charAt(j - 1)) {
					tmpArray[0] = (int) ipString1.charAt(i - 1);
					tmpArray[1] = ipMetrix[i - 1][j - 1][1] + 1;
					tmpArray[2] = i - 1;
					tmpArray[3] = j - 1;
				} else {
					tmpArray[0] = -1;
					if (ipMetrix[i][j - 1][1] >= ipMetrix[i - 1][j][1]) {
						tmpArray[1] = ipMetrix[i][j - 1][1];
						tmpArray[2] = i;
						tmpArray[3] = j - 1;
					} else {
						tmpArray[1] = ipMetrix[i - 1][j][1];
						tmpArray[2] = i - 1;
						tmpArray[3] = j;
					}
				}
				ipMetrix[i][j] = tmpArray;
			}

		}
		commonSubsequence = deriveCommonSubsequence(ipMetrix);
		return commonSubsequence;
	}

	private static List<Character> deriveCommonSubsequence(int[][][] ipMetrix) {

		List<Character> commonSubsequence = new ArrayList<Character>();
		int i = ipMetrix.length - 1;
		int j = ipMetrix[0].length - 1;
		int tmpi = 0;
		int tmpj = 0;
		while (i > 0 && j > 0) {
			if (ipMetrix[i][j][0] != -1) {
				commonSubsequence.add((char) ipMetrix[i][j][0]);
			}
			tmpi = ipMetrix[i][j][2];
			tmpj = ipMetrix[i][j][3];
			i = tmpi;
			j = tmpj;
		}

		return commonSubsequence;
	}

	private static int[][][] initializeMetrix(int[][][] ipMetrix) {

		for (int i = 0; i < ipMetrix.length; i++) {
			for (int j = 0; j < ipMetrix[0].length; j++) {
				ipMetrix[i][j] = new int[] { 0, 0, 0, 0 };
			}
		}

		return ipMetrix;
	}

	static class Touple {
		Character ch;
		Integer index;

		public Touple(Character ch, Integer index) {
			this.ch = ch;
			this.index = index;
		}

		public Character getCh() {
			return ch;
		}

		public Integer getIndex() {
			return index;
		}

	}

	/**
	 * Method 2 Time Complexity: O(m*n) Space Complexity: O(Min(m,n))
	 **/

	public static List<Character> getLongestCommonSubsequenceAlgo(String ipString1, String ipString2) {
		List<Character> commonSubsequence = new ArrayList<>();
		List<Touple> commonSubsequenceTouple = new ArrayList<>();
		for (int i = ipString1.length() - 1; i >= 0; i--) {
			for (int j = ipString2.length() - 1; j >= 0; j--) {
				if (ipString1.charAt(i) == ipString2.charAt(j)) {
					commonSubsequenceTouple.add(new Touple(ipString1.charAt(i), j));
				}
			}
		}
		for (int i = 0; i < commonSubsequenceTouple.size(); i++) {
			if (i == 0)
				commonSubsequence.add(commonSubsequenceTouple.get(i).getCh());
			else {
				if (commonSubsequenceTouple.get(i).getIndex() < commonSubsequenceTouple.get(i - 1).getIndex()) {
					commonSubsequence.add(commonSubsequenceTouple.get(i).getCh());
				}
			}
		}
		return commonSubsequence;
	}

	public static void main(String[] args) {
		// System.out.println(getLongestCommonSubsequenceAlgorithm("ZXVVYZW",
		// "XKYKZPW"));
		// System.out.println(getLongestCommonSubsequenceAlgo("ZXVVYZW", "XKYKZPW"));

		// System.out.println(getLongestCommonSubsequenceAlgorithm("ZXVVYZW",
		// "XKYKZYW"));
		// System.out.println(getLongestCommonSubsequenceAlgo("ZXVVYZW", "XKYKZYW"));

		// System.out.println(getLongestCommonSubsequenceAlgorithm("ABCDEFG",
		// "ABCDEFG"));
		// System.out.println(getLongestCommonSubsequenceAlgo("ABCDEFG", "ABCDEFG"));

		System.out.println(getLongestCommonSubsequenceAlgorithm("ABCDEFG", "APPLES"));
		System.out.println(getLongestCommonSubsequenceAlgo("ABCDEFG", "APPLES"));
	}
}
