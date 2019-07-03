package com.category.simple;
/**Problem to find the Single Cycle in the given input array.
 * See the description in algo expert
 * Time Complexity: O(n) where n is the number of element in the given array
 * Space Complexity: O(1) as we are doing all the operation in place. No extra space is used.
 * **/
public class SingleCycleCheckAlgorithm {

	public static boolean checkSingleCycle(int[] ipArray) {
		int counter = 0;
		int currentIndex = 0;
		boolean isSingleCycle = false;
		while (counter < ipArray.length) {
			if (currentIndex + ipArray[currentIndex] == currentIndex) {
				isSingleCycle = false;
				break;
			}
			if (currentIndex + ipArray[currentIndex] >= ipArray.length) {
				currentIndex = (currentIndex + ipArray[currentIndex]) - (ipArray.length);
			} else if (currentIndex + ipArray[currentIndex] < 0) {
				currentIndex = ipArray.length + (currentIndex + ipArray[currentIndex]);
			} else {
				currentIndex = currentIndex + ipArray[currentIndex];
			}
			if (currentIndex == 0 && counter == ipArray.length - 1 && counter > 0) {
				isSingleCycle = true;
			}
			if (currentIndex == 0 && counter < ipArray.length - 1 && counter > 0) {
				isSingleCycle = false;
			}
			counter++;
		}

		return isSingleCycle;
	}

	public static void main(String[] args) {
		System.out.println(SingleCycleCheckAlgorithm.checkSingleCycle(new int[] { 2, 2, -1 }));
		System.out.println(SingleCycleCheckAlgorithm.checkSingleCycle(new int[] { 2, 2, 2 }));
		System.out.println(SingleCycleCheckAlgorithm.checkSingleCycle(new int[] { 1, 1, 1, 1, 1 }));
		System.out.println(SingleCycleCheckAlgorithm.checkSingleCycle(new int[] { 0, 1, 1, 1, 1 }));
		System.out.println(SingleCycleCheckAlgorithm.checkSingleCycle(new int[] { 1, 1, 0, 1, 1 }));
		System.out.println(SingleCycleCheckAlgorithm.checkSingleCycle(new int[] { 1, 1, 1, 1, 2 }));
		System.out.println(SingleCycleCheckAlgorithm
				.checkSingleCycle(new int[] { 3, 5, 6, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2 }));
	}

}
