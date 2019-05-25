package com.category.simple.datastructures.sotingalgorithms;

import java.util.List;
/**
 * This is an implementation of an algorithm to find the three largest numbers in the given 
 * input array.
 * Time complexity: O(n) where n is the number of elements in the input array
 * Space Complexity: it is constant as we will create few arrays of fixed size->3
 * 
 * **/

public class ThreeLargestNumbersFinder {
	
	public static int[] chooseThreeLargestNumbers(int[] ipArray) {
		int[] opArray=new int[] {0,0,0};
		int[] finalOpArray=new int[3];
		int opCounter=2;
		int finalOpCounter=0;
		for(int number:ipArray) {
			opArray=compareOutputArray(opArray,number);
		}
		while(opCounter>=0) {
			finalOpArray[finalOpCounter]=opArray[opCounter];
			finalOpCounter++;
			opCounter--;
		}
		return finalOpArray;
	}
	
	public static int[] compareOutputArray(int[] inputList, int targetNumber) {
		int[] opList = new int[3];
		int opCounter = 0;
		int ipCounter = 0;
		boolean isReplaced = false;
		while (opCounter < opList.length) {
			if (inputList[ipCounter] <= targetNumber && !isReplaced) {
				opList[opCounter] = targetNumber;
				if(++opCounter<opList.length)
					opList[opCounter] = inputList[ipCounter];
				isReplaced = true;

			} else {
				opList[opCounter] = inputList[ipCounter];
			}
			ipCounter++;
			opCounter++;
		}

		return opList;
	}
	

}
