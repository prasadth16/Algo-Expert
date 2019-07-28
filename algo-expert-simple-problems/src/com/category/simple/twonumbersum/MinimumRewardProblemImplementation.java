package com.category.simple.twonumbersum;
/**Minimum Reward Algorithm Program
 * For more details Please check the AlgoExpert Website
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * **/
public class MinimumRewardProblemImplementation {

	public static int[] calculateMinimumRewards(int[] ipArray) {

		int[] opArray = new int[ipArray.length];
		opArray = initializeArray(opArray);
		for (int i = 0; i < ipArray.length; i++) {
			if (i > 0 && ipArray[i] > ipArray[i - 1]) {
				opArray[i] = opArray[i - 1] + 1;
			}
		}
		for (int i = ipArray.length - 1; i >= 0; i--) {
			if (i < ipArray.length - 1 && ipArray[i] > ipArray[i + 1]) {
				opArray[i] = opArray[i + 1] + 1;
			}
		}

		return opArray;
	}

	private static int[] initializeArray(int[] ipArray) {
		for (int i = 0; i < ipArray.length; i++) {
			ipArray[i] = 1;
		}
		return ipArray;
	}

	public static void main(String[] args) {
		int[] opArray = calculateMinimumRewards(new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5 });//25
		opArray = calculateMinimumRewards(new int[] { 0, 4, 2, 1, 3 });//9
		System.out.println("Program Execution Finished!!!!");
	}
}
