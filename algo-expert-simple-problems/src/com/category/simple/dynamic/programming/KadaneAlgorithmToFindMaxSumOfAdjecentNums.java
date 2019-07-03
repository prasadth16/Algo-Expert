package com.category.simple.dynamic.programming;
/**Program to calculate Max sum of consecutive numbers in an input array.
 * Logic: Add number at ith index to the sum of all previous number sum at i-1th index only if after addition 
 * sum s greater or equal to the number at ith index in array.
 * Time Complexity : O(n)
 * Space Complexity is O(1)
 * **/
public class KadaneAlgorithmToFindMaxSumOfAdjecentNums {

	public static int getMaxSum(int[] ipArray) {
		int maxSum = ipArray[0];
		int counter = 0;
		while (counter < ipArray.length) {
			if (counter > 0 && (ipArray[counter] + ipArray[counter - 1]) >= ipArray[counter]) {
				ipArray[counter] = ipArray[counter] + ipArray[counter - 1];
			} else if (counter > 0 && (ipArray[counter] + ipArray[counter - 1]) < ipArray[counter]) {
				if (ipArray[counter - 1] > maxSum) {
					maxSum = ipArray[counter - 1];
				}
			}
			counter++;
		}
		if (ipArray[counter - 1] > maxSum) {
			maxSum = ipArray[counter - 1];
		}
		return maxSum;

	}

	public static void main(String[] arg) {
		System.out.println(getMaxSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		System.out.println(getMaxSum(new int[] { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 }));
		System.out.println(getMaxSum(new int[] { -10, -2, -9, -4, -8, -6, -7, -1, -3, -5 }));
		System.out.println(getMaxSum(new int[] { 1, 2, 3, 4, 5, 6, -20, 7, 8, 9, 10 }));
	}

}
