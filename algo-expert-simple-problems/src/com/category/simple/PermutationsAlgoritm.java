package com.category.simple;

import java.util.ArrayList;
import java.util.List;
/**program to find different permutations out of an integer array
 * Please take a loot at AlgoExpert for detail problem description.
 * Time Complexity=O(n^2*n!)-->Check the explaination again.
 * Space Complexity: O(n*n!) as each permutation is of length n and there are n! number of permutations.
 * 
 * There is a second solution to this problem. Please check it.
 * **/
public class PermutationsAlgoritm {

	public static void findPermutations(List<Integer> ipList, List<Integer> currentPermutation,
			List<List<Integer>> permutations) {
		if (ipList.isEmpty()) {
			permutations.add(currentPermutation);
		} else {
			for (int i = 0; i < ipList.size(); i++) {
				List<Integer> newIPList = new ArrayList<>();
				newIPList.addAll(ipList);
				Integer currentInteger = newIPList.remove(i);
				List<Integer> newCurrentPermutation = new ArrayList<>();
				newCurrentPermutation.addAll(currentPermutation);
				newCurrentPermutation.add(currentInteger);
				findPermutations(newIPList, newCurrentPermutation, permutations);
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> ipList = new ArrayList<>();
		ipList.add(1);
		ipList.add(2);
		ipList.add(3);

		List<Integer> currentPermutation = new ArrayList<>();
		List<List<Integer>> permutations = new ArrayList<>();
		findPermutations(ipList, currentPermutation, permutations);
		System.out.println("Permutations Generated!!!");
	}

}
