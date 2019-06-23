package com.category.simple.twonumbersum;

public class SmallestDifferrenceAlgorithm {
	/**
	 * Method to find the tow numbers with difference nearest to 0 from two input
	 * arrays. Note: Expectation is tow get sorted input array Time Complexity: if
	 * input Arrays are sorted then Time complexity is O(N) where N is number of
	 * elements in the largest array among two. If arrays are not sorted then time
	 * complexity of sorting both the arrays is O(nlog(n)+mlog(m)) and will be the
	 * overall time complexity. As we are not using any extra space except out put
	 * array with fixed size of 2 the space Complexity will be O(1)
	 * 
	 **/
	public static int[] findSmallestDiffernce(int[] firstArray, int[] secondAray) {
		int firstArrayCounter = 0;
		int secondArrayCounter = 0;
		int tmpFirstArrayCounter = 0;
		int tmpSecondArrayCounter = 0;
		int difference = Integer.MAX_VALUE;
		int tmpDifference = 0;
		int[] opArray = new int[2];

		while (firstArrayCounter < firstArray.length-1 || secondArrayCounter < secondAray.length-1) {

			tmpFirstArrayCounter = firstArrayCounter;
			tmpSecondArrayCounter = secondArrayCounter;
			tmpDifference = Math.abs(firstArray[firstArrayCounter] - secondAray[secondArrayCounter]);

			opArray[0] = difference > tmpDifference ? firstArray[firstArrayCounter] : opArray[0];
			opArray[1] = difference > tmpDifference ? secondAray[secondArrayCounter] : opArray[1];
			difference = difference > tmpDifference ? tmpDifference : difference;

			firstArrayCounter = (firstArray[tmpFirstArrayCounter] < secondAray[tmpSecondArrayCounter]
					&& tmpFirstArrayCounter < firstArray.length-1) ? firstArrayCounter + 1 : firstArrayCounter;
			secondArrayCounter = (firstArray[tmpFirstArrayCounter] > secondAray[tmpSecondArrayCounter]
					&& tmpSecondArrayCounter < secondAray.length-1) ? secondArrayCounter + 1 : secondArrayCounter;
			if (firstArray[tmpFirstArrayCounter] == secondAray[tmpSecondArrayCounter]) {
				opArray[0] = firstArray[firstArrayCounter];
				opArray[1] = secondAray[secondArrayCounter];
				break;
			}

		}

		return opArray;
	}

}
