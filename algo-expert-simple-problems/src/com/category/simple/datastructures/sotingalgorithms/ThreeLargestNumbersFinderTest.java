package com.category.simple.datastructures.sotingalgorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ThreeLargestNumbersFinderTest {
	@Test
	public void testCompareOutputArray() {

		int[] ipArray = new int[] { 19, 17, 13 };
		assertArrayEquals(new int[] { 19, 17, 13 }, ThreeLargestNumbersFinder.compareOutputArray(ipArray, 9));
		assertArrayEquals(new int[] { 19, 17, 15 }, ThreeLargestNumbersFinder.compareOutputArray(ipArray, 15));
		assertArrayEquals(new int[] { 19, 18, 17 }, ThreeLargestNumbersFinder.compareOutputArray(ipArray, 18));
		assertArrayEquals(new int[] { 20, 19, 17 }, ThreeLargestNumbersFinder.compareOutputArray(ipArray, 20));
		ipArray= new int[]{0,0,0};
		assertArrayEquals(new int[] { 5,0,0 }, ThreeLargestNumbersFinder.compareOutputArray(ipArray, 5));
	}
	
	@Test
	public void testChooseThreeLargestNumbers() {
		int[] ipArray=new int[] {141,1,17,-7,-17,-27,18,541,8,7,7};
		assertArrayEquals(new int[] {18,141,541}, ThreeLargestNumbersFinder.chooseThreeLargestNumbers(ipArray));
		ipArray=new int[] {10,5,9,10,12};
		assertArrayEquals(new int[] {10,10,12}, ThreeLargestNumbersFinder.chooseThreeLargestNumbers(ipArray));
	} 
}
