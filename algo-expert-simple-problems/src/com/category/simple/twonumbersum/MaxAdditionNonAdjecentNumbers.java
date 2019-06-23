package com.category.simple.twonumbersum;

/**
 * Method to get the maximum addition of non adjecent number from the array Time
 * Complexity: O(n) where n is the number of elements in the input array Space
 * Complexity: O(1) as there is no additional Storage used.
 * 
 **/
public class MaxAdditionNonAdjecentNumbers {

	public static int getMaxAdditionOfNonAdjecentNumbers(int[] ipArray) {
		int counter = 0;
		while (counter <= ipArray.length - 1) {
			if (counter == 0) {
				counter++;
				continue;
			}
			if (counter == 1 && ipArray[counter - 1] > ipArray[counter]) {
				ipArray[counter] = ipArray[counter - 1];
				counter++;
				continue;
			}
			if (counter == 1 && ipArray[counter - 1] <= ipArray[counter]) {
				counter++;
				continue;
			}
			if (ipArray[counter - 1] > ipArray[counter - 2] + ipArray[counter]) {
				ipArray[counter] = ipArray[counter - 1];
			} else {
				ipArray[counter] = ipArray[counter - 2] + ipArray[counter];
			}
			counter++;
		}

		return ipArray[ipArray.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(getMaxAdditionOfNonAdjecentNumbers(new int[] { 7, 125, 124, 90, 31, 57, 69, 4, 35 }));
		System.out.println(getMaxAdditionOfNonAdjecentNumbers(new int[] { 7, 35, 15, 75, 100 }));
		System.out.println(getMaxAdditionOfNonAdjecentNumbers(new int[] { 7, -35, 15, 75, 100 }));
	}

}
