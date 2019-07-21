package com.category.simple.twonumbersum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Program to find all possible unique combinations of 4 numbers sum up to the
 * target sum. Time Complexity: O(n2) where n is size of the input list. We
 * iterate over the input list and inside main loop there are two loops which
 * iterate forward and backward and hence iterate on the complete list.
 * 
 * Space Complexity: O(n^2): This is the number of elements in the Hash.
 * Approximately n^2 pairs will be generated from the input list having size n.
 **/
public class FourNumberSum {

	public static List<List<Integer>> getTargetQuad(List<Integer> ipList, int targetSum) {
		List<List<Integer>> outputList = new ArrayList<List<Integer>>();
		Map<Integer, List<List<Integer>>> hash = new HashMap<>();
		int counter = 0;
		int forwardCounter = 0;
		int backwardCounter = 0;

		while (counter < ipList.size()) {
			forwardCounter = counter + 1 < ipList.size() ? counter + 1 : -1;
			backwardCounter = counter - 1 >= 0 ? counter - 1 : -1;
			if (forwardCounter != -1 && backwardCounter != -1) {

				while (forwardCounter < ipList.size()) {
					if (hash.containsKey(targetSum - (ipList.get(forwardCounter) + ipList.get(counter)))) {
						for (List<Integer> l : hash
								.get(targetSum - (ipList.get(forwardCounter) + ipList.get(counter)))) {
							List<Integer> tmpList = new ArrayList<>();
							tmpList.addAll(l);
							tmpList.add(ipList.get(counter));
							tmpList.add(ipList.get(forwardCounter));
							outputList.add(tmpList);
						}

					}
					forwardCounter++;
				}
				while (backwardCounter >= 0) {
					List<Integer> tmpList = new ArrayList<>();
					tmpList.add(ipList.get(counter));
					tmpList.add(ipList.get(backwardCounter));
					List<List<Integer>> hashList = hash.containsKey(ipList.get(counter) + ipList.get(backwardCounter))
							? hash.get(ipList.get(counter) + ipList.get(backwardCounter))
							: new ArrayList<List<Integer>>();
					hashList.add(tmpList);
					hash.put(ipList.get(counter) + ipList.get(backwardCounter), hashList);
					backwardCounter--;
				}

			}

			counter++;
		}

		return outputList;
	}

	public static void main(String[] args) {
		System.out.println(getTargetQuad(Arrays.asList(7, 6, 4, -1, 1, 2), 16));
	}
}
