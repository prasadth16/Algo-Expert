package com.category.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm to stack the disks to get maximum height of the tower with some
 * restrictions. Check Algo-Expert for problem descriptions. Assumption: Input
 * array of the disks is sorted by disk's height. Time Complexity: O(n*n) where
 * n is the number of disks in the input array. Space Complexity: O(n) as we are
 * using supporting arrays to store intermittent results of size n
 **/
public class DiskStackingMaxHeightAlgorithm {

	public static void printMaxHeightAndDisks(int[][] inputDisks) {
		int[] heights = initializeMaxHeightArray(inputDisks);
		int maxHeightIndex = 0;
		int[] diskTrackingList = new int[inputDisks.length];

		for (int i = 1; i < inputDisks.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (inputDisks[j][0] < inputDisks[i][0] && inputDisks[j][1] < inputDisks[i][1]
						&& inputDisks[j][2] < inputDisks[i][2]) {
					if (heights[i] < heights[j] + inputDisks[i][2]) {
						heights[i] = heights[j] + inputDisks[i][2];

						diskTrackingList[i] = j;
					}
				}

			}
			if (heights[maxHeightIndex] < heights[i]) {
				maxHeightIndex = i;
			}
		}
		System.out.println("Max Tower Height is: " + heights[maxHeightIndex] + " and the disks are: ");
		printDisksInTower(diskTrackingList, maxHeightIndex, inputDisks);
	}

	private static void printDisksInTower(int[] diskTrackingList, int bottomIndex, int[][] inputDisks) {
		List<Integer> seq = new ArrayList<>();
		seq.add(bottomIndex);
		while (bottomIndex > 0) {
			seq.add(diskTrackingList[bottomIndex]);
			bottomIndex = diskTrackingList[bottomIndex];
		}
		for (int i = seq.size() - 1; i >= 0; i--) {
			System.out.println("[" + inputDisks[seq.get(i)][0] + "," + inputDisks[seq.get(i)][1] + ","
					+ inputDisks[seq.get(i)][2] + "],");
		}
	}

	private static int[] initializeMaxHeightArray(int[][] inputDisks) {
		int[] heights = new int[inputDisks.length];
		for (int i = 0; i < inputDisks.length; i++) {
			heights[i] = inputDisks[i][2];
		}
		return heights;
	}

	public static void main(String[] args) {
		printMaxHeightAndDisks(
				new int[][] { { 1, 2, 1 }, { 2, 1, 2 }, { 2, 3, 2 }, { 2, 3, 4 }, { 4, 4, 5 }, { 2, 2, 8 } });
	}

}
