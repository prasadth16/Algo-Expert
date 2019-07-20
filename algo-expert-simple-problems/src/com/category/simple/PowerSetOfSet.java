package com.category.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program to get all the power sets of the given set Please check AlgoExpert to
 * get more information about the problem. Time Complexity: Number of power sets
 * is 2^n where n is the number of elements in the input array.
 * every array has average size of n/2.
 * so time complexity is O(2^n*n/2) that is O(2^n*n)
 * Space complexity is O(2^n*n)
 **/
public class PowerSetOfSet {

	public static List<List<Integer>> getPowerSets(List<Integer> ipSet) {
		List<List<Integer>> opPowerSets = new ArrayList<List<Integer>>();
		opPowerSets.add(new ArrayList<>());
		int setCount = 1;
		for (Integer i : ipSet) {
			int tmpCounter = 0;
			int tmpSetCount = 0;
			List<Integer> newList = null;
			while (tmpCounter < setCount) {
				List<Integer> exstList = opPowerSets.get(tmpCounter);
				newList = new ArrayList<>();
				newList.addAll(exstList);
				newList.add(i);
				opPowerSets.add(newList);
				tmpSetCount++;
				tmpCounter++;
			}
			setCount = setCount + tmpSetCount;
		}
		return opPowerSets;

	}

	public static void main(String[] args) {
		List<Integer> ipSet = Arrays.asList(1, 2, 3);
		List<List<Integer>> opPowerSets = getPowerSets(ipSet);
		System.out.println("Power Sets Generated!!");
	}

}
