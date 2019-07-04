package com.category.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Refer to AlgoExpert for program Description Time Complexity: O(M*N) where M
 * is width of input array and N is Height of the input array Space Complexity:
 * O(M*N) as we are using auxiliary Matrix to mark the array location as visited
 * So that every location can be visited only once.
 **/
public class RiverSizesDeterminationAlgorithm {

	public static List<Integer> getRiverSizes(int[][] ipArray) {
		List<Integer> riverSizes = new ArrayList<>();
		int riverSize;
		boolean[][] trackerArray = new boolean[ipArray.length][ipArray[0].length];
		for (int i = 0; i < ipArray.length; i++) {
			for (int j = 0; j < ipArray[i].length; j++) {
				if (ipArray[i][j] == 1 && !trackerArray[i][j]) {
					trackerArray[i][j] = true;
					riverSize = trackRiver(ipArray, trackerArray, i, j);
					if (riverSize > 0) {
						riverSizes.add(riverSize);
					}
				}
			}
		}
		return riverSizes;
	}

	private static int trackRiver(int[][] ipArray, boolean[][] trackerArray, int i, int j) {
		int riverCount = 0;

		trackerArray[i][j] = true;
		if ((i - 1) >= 0 && (i - 1) < ipArray.length && j >= 0 && j < ipArray[0].length && !trackerArray[i - 1][j]
				&& ipArray[i - 1][j] == 1)
			riverCount = riverCount + trackRiver(ipArray, trackerArray, i - 1, j);
		if ((i + 1) >= 0 && (i + 1) < ipArray.length && j >= 0 && j < ipArray[0].length && !trackerArray[i + 1][j]
				&& ipArray[i + 1][j] == 1)
			riverCount = riverCount + trackRiver(ipArray, trackerArray, i + 1, j);
		if ((i) >= 0 && (i) < ipArray.length && (j - 1) >= 0 && (j - 1) < ipArray[0].length && !trackerArray[i][j - 1]
				&& ipArray[i][j - 1] == 1)
			riverCount = riverCount + trackRiver(ipArray, trackerArray, i, j - 1);
		if ((i) >= 0 && (i) < ipArray.length && (j + 1) >= 0 && (j + 1) < ipArray[0].length && !trackerArray[i][j + 1]
				&& ipArray[i][j + 1] == 1)
			riverCount = riverCount + trackRiver(ipArray, trackerArray, i, j + 1);
		return riverCount + 1;

	}

	public static void main(String[] args) {
		List<Integer> riverSizes = getRiverSizes(new int[][] { { 1, 0, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 0 } });
		riverSizes.forEach(System.out::println);
		riverSizes = getRiverSizes(new int[][] { {0}});
		riverSizes.forEach(System.out::println);
	}

}
