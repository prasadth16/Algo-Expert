/*
 * Time Complexity: O(blocks * requirements)
 * Space Complexity: O(1)
 * */

package com.category.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHuntingAlgorithmImpl {

	public static void main(String[] args) {
		// 1: school
		// 2: Gym
		// 3: Store
		List<String> requirementList = Arrays.asList("SC", "G", "ST");
		List<Map<String, Boolean>> blockRequirements = new ArrayList<>();
		Map<String, Boolean> requirement = new HashMap<String, Boolean>();
		int min = Integer.MAX_VALUE;
		int minValue = 0;
		requirement.put("SC", true);
		blockRequirements.add(requirement);
		requirement = new HashMap<String, Boolean>();
		requirement.put("G", true);
		blockRequirements.add(requirement);
		requirement = new HashMap<String, Boolean>();
		requirement.put("G", true);
		requirement.put("SC", true);
		blockRequirements.add(requirement);
		requirement = new HashMap<String, Boolean>();
		requirement.put("SC", true);
		blockRequirements.add(requirement);
		requirement = new HashMap<String, Boolean>();
		requirement.put("SC", true);
		requirement.put("ST", true);
		blockRequirements.add(requirement);
		int[][] prefilledMatrix = prepopulateRequirementArray(blockRequirements, requirementList);
		for (int j = 0; j < prefilledMatrix[0].length; j++) {
			if (min > findMax(prefilledMatrix[0][j], prefilledMatrix[1][j], prefilledMatrix[2][j])) {
				min = findMax(prefilledMatrix[0][j], prefilledMatrix[1][j], prefilledMatrix[2][j]);
				minValue = j;
			}
		}
		System.out.println("Targetted block is: " + minValue);
	}

	private static int findMax(int one, int two, int three) {
		int max = one;
		if (max < two) {
			max = two;
		}
		if (max < three) {
			max = three;
		}
		return max;
	}

	private static int[][] prepopulateRequirementArray(List<Map<String, Boolean>> blockRequirements,
			List<String> requirements) {
		int[][] prefilledMatrix = new int[requirements.size()][blockRequirements.size()];
		int latestPosition = -1;
		String reqType = "";
		for (int i = 0; i < prefilledMatrix.length; i++) {
			latestPosition = -1;
			reqType = requirements.get(i);
			for (int j = 0; j < prefilledMatrix[0].length; j++) {
				if (null != blockRequirements.get(j).get(requirements.get(i))) {
					prefilledMatrix[i][j] = 0;
					latestPosition = j;
				} else if (latestPosition == -1) {
					prefilledMatrix[i][j] = latestPosition;
				} else {
					prefilledMatrix[i][j] = j - latestPosition;
				}
			}
			latestPosition = -1;
			for (int j = prefilledMatrix[0].length - 1; j >= 0; j--) {
				if (null != blockRequirements.get(j).get(requirements.get(i))) {
					prefilledMatrix[i][j] = 0;
					latestPosition = j;
				} else if (prefilledMatrix[i][j] != -1 && prefilledMatrix[i][j] > latestPosition - j
						&& latestPosition != -1) {
					prefilledMatrix[i][j] = latestPosition - j;
				} else if (prefilledMatrix[i][j] == -1) {
					prefilledMatrix[i][j] = latestPosition - j;
				}
			}
		}

		return prefilledMatrix;
	}

}
