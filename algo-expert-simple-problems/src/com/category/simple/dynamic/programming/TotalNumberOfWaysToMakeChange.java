package com.category.simple.dynamic.programming;

import java.util.stream.Stream;

public class TotalNumberOfWaysToMakeChange {

	public static int numberOfWaysToMakeChange(int[] den, int targetSum) {
		int[] memoisationStorage = new int[targetSum + 1];
		int counter = 0;
		// initialize MemoisationStorage
		while (counter <= targetSum) {
			if (counter == 0) {
				memoisationStorage[counter] = 1;
			} else {
				memoisationStorage[counter] = 0;
			}
			counter++;
		}

		for (int dnm : den) {
			counter = 0;
			while (counter <= targetSum) {
				if (counter >= dnm) {
					memoisationStorage[counter] += memoisationStorage[counter - dnm];
				}
				counter++;
			}
		}
		return memoisationStorage[targetSum];
	}
}
