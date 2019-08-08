package com.category.simple.twonumbersum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program to find the maximum sum of the increasing sub array in the given
 * input array. Dynamic programming has been used in this program. Time
 * Complexity: O(n^2) where n is the number of element in the given input array.
 * Space Complexity: O(n) as we are creating tmp aarays to store maximum sum as
 * well as tracking indexes.
 **/
public class MaxSumIncreasingSubsequence {

	static class OutPut {
		private int maxSum;
		private List<Integer> subsequence = new ArrayList<Integer>();

		public int getMaxSum() {
			return maxSum;
		}

		public void setMaxSum(int maxSum) {
			this.maxSum = maxSum;
		}

		public List<Integer> getSubsequence() {
			return subsequence;
		}

		public void setSubsequence(List<Integer> subsequence) {
			this.subsequence = subsequence;
		}

	}

	public static OutPut findMaxSumIncreasingSubsequence(int[] ipArray) {

		OutPut output = new OutPut();
		Integer[] finalSubsequence = new Integer[ipArray.length];
		int[] maxSubSequenceSum = new int[ipArray.length];
		int[] subsequenceIndex = new int[ipArray.length];
		int maxSumIndex = 0;
		int maxSum = ipArray[0];
		subsequenceIndex = initializeArray(subsequenceIndex);
		for (int i = 0; i < ipArray.length; i++) {
			if (i == 0) {
				maxSubSequenceSum[i] = ipArray[i];
			} else {
				for (int j = i - 1; j >= 0; j--) {
					if (ipArray[i] > ipArray[j] && maxSubSequenceSum[j] + ipArray[i] > maxSubSequenceSum[i]) {
						maxSubSequenceSum[i] = maxSubSequenceSum[j] + ipArray[i];
						subsequenceIndex[i] = j;
					}
				}
				if (maxSubSequenceSum[i] == 0) {
					maxSubSequenceSum[i] = ipArray[i];
				}
				if (maxSubSequenceSum[i] > maxSum) {
					maxSum = maxSubSequenceSum[i];
					maxSumIndex = i;
				}
			}
		}
		output.setMaxSum(maxSubSequenceSum[maxSumIndex]);
		finalSubsequence[0] = ipArray[maxSumIndex];
		int counter = 1;
		//Creating final sub-sequence, it is actually in decreasing order. If required print it in reverse order
		while (maxSumIndex != -1) {
			if (subsequenceIndex[maxSumIndex] != -1)
				finalSubsequence[counter] = ipArray[subsequenceIndex[maxSumIndex]];
			maxSumIndex = subsequenceIndex[maxSumIndex];
			counter++;
		}
		output.setSubsequence(Arrays.asList(finalSubsequence));

		return output;
	}

	private static int[] initializeArray(int[] ipArray) {
		for (int i = 0; i < ipArray.length; i++) {
			ipArray[i] = -1;
		}
		return ipArray;
	}

	public static void main(String[] args) {
		OutPut output = findMaxSumIncreasingSubsequence(new int[] { 8, 12, 2, 3, 15, 5, 7 });
		System.out.println(output.getMaxSum() + " " + output.getSubsequence());

		OutPut output1 = findMaxSumIncreasingSubsequence(new int[] { 5, 4, 3, 2, 1 });
		System.out.println(output1.getMaxSum() + " " + output1.getSubsequence());

		OutPut output2 = findMaxSumIncreasingSubsequence(new int[] { 1, 2, 3, 4, 5 });
		System.out.println(output2.getMaxSum() + " " + output2.getSubsequence());

		OutPut output3 = findMaxSumIncreasingSubsequence(new int[] { -5, -4, -3, -2, -1 });
		System.out.println(output3.getMaxSum() + " " + output3.getSubsequence());
	}

}
