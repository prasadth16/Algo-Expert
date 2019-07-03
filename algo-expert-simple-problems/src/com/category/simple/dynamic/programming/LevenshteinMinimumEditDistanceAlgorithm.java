package com.category.simple.dynamic.programming;

public class LevenshteinMinimumEditDistanceAlgorithm {

	private static ProgramTouple[][] memoisationMetrix;

	public static ProgramTouple[][] getMemoisationMetrix() {
		return memoisationMetrix;
	}

	public static void setMemoisationMetrix(ProgramTouple[][] memoisationMetrix) {
		LevenshteinMinimumEditDistanceAlgorithm.memoisationMetrix = memoisationMetrix;
	}

	public static void findMinimumEditDistance(String ipString1, String ipString2) {
		setMemoisationMetrix(new ProgramTouple[ipString1.length() + 1][ipString2.length() + 1]);
		ProgramTouple tmpTouple = new ProgramTouple(0, "No-Opearation");
		memoisationMetrix[0][0] = tmpTouple;
		Character[] ipString1Array = new Character[ipString1.length() + 1];
		Character[] ipString2Array = new Character[ipString2.length() + 1];
		ipString1Array[0] = null;
		ipString2Array[0] = null;
		copyArrayFromIndex1(ipString1Array, ipString1.toCharArray());
		copyArrayFromIndex1(ipString2Array, ipString2.toCharArray());
		populateMemoisationMetrix(ipString1Array, ipString2Array);
		printOutput(ipString1.length(), ipString2.length(), ipString1Array, ipString2Array);
	}

	private static void populateMemoisationMetrix(Character[] ipString1Array, Character[] ipString2Array) {

		ProgramTouple tmpMap = new ProgramTouple();
		ProgramTouple tmpMap1 = new ProgramTouple();

		for (int i = 0; i < ipString1Array.length; i++) {
			for (int j = 0; j < ipString2Array.length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i == 0) {
					tmpMap = new ProgramTouple(j, "Insert");
					memoisationMetrix[i][j] = tmpMap;
				} else if (j == 0) {
					tmpMap = new ProgramTouple(i, "Delete");
					memoisationMetrix[i][j] = tmpMap;
				} else if (ipString1Array[i] == ipString2Array[j]) {
					tmpMap1 = memoisationMetrix[i - 1][j - 1];
					tmpMap = new ProgramTouple(tmpMap1.getMinimumEditValue(), "No-Opearation");
					memoisationMetrix[i][j] = tmpMap;
				} else if (ipString1Array[i] != ipString2Array[j]) {
					tmpMap = new ProgramTouple(
							findSmallestEditValue(memoisationMetrix[i][j - 1], memoisationMetrix[i - 1][j - 1],
									memoisationMetrix[i - 1][j]) + 1,
							findOperationName(memoisationMetrix[i][j - 1], memoisationMetrix[i - 1][j - 1],
									memoisationMetrix[i - 1][j]));
					memoisationMetrix[i][j] = tmpMap;
				}

			}
		}
	}

	private static String findOperationName(ProgramTouple previous, ProgramTouple diagonal, ProgramTouple upper) {
		String operationName = "";
		if (previous.getMinimumEditValue() <= diagonal.getMinimumEditValue()
				&& previous.getMinimumEditValue() <= upper.getMinimumEditValue())
			operationName = "Insert";
		else if (diagonal.getMinimumEditValue() <= previous.getMinimumEditValue()
				&& diagonal.getMinimumEditValue() <= upper.getMinimumEditValue())
			operationName = "Replace";
		else
			operationName = "Delete";
		return operationName;
	}

	private static Integer findSmallestEditValue(ProgramTouple tpl1, ProgramTouple tpl2, ProgramTouple tpl3) {
		ProgramTouple finalTouple = null;
		if (tpl1.getMinimumEditValue() <= tpl2.getMinimumEditValue())
			finalTouple = tpl1;
		else
			finalTouple = tpl2;
		if (finalTouple.getMinimumEditValue() > tpl3.getMinimumEditValue())
			finalTouple = tpl3;
		return finalTouple.getMinimumEditValue();
	}

	private static void copyArrayFromIndex1(Character[] target, char[] source) {
		int counter = 1;
		for (char c : source) {
			target[counter] = c;
			counter++;
		}
	}

	private static void printOutput(int rows, int cols, Character[] ip1, Character[] ip2) {

		int minimumEditValue = memoisationMetrix[rows][cols].getMinimumEditValue();
		System.out.println("Miniumum Edit value: " + minimumEditValue);
		while (minimumEditValue != 0) {
			switch (memoisationMetrix[rows][cols].getOperationName()) {
			case "Replace":
				System.out.println(
						memoisationMetrix[rows][cols].getOperationName() + " " + ip1[rows] + " For " + ip2[cols]);
				rows--;
				cols--;
				break;
			case "Delete":
				System.out.println(memoisationMetrix[rows][cols].getOperationName() + " " + ip1[rows]);
				rows--;
				break;
			case "Insert":
				System.out.println(memoisationMetrix[rows][cols].getOperationName() + " " + ip2[cols]);
				cols--;
				break;
			case "No-Opearation":
				System.out.println(memoisationMetrix[rows][cols].getOperationName());
				rows--;
				cols--;
				break;
			}
			minimumEditValue = memoisationMetrix[rows][cols].getMinimumEditValue();
		}

	}

	public static void main(String[] arg) {
		//findMinimumEditDistance("abc", "yabcx");
		findMinimumEditDistance("algoexpert", "algozexpert");
	}
}
