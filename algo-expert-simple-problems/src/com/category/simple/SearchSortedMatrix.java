package com.category.simple;

/**
 * Program to search number from sorted matrix(Two diamentional array) Matrix is
 * sorted i.e. all the rows and all the columns in the given input matrix are
 * sorted in Ascending order Please check AlgoExpert for more information. Time
 * Complexity: O(m+n) where m is width and n is height of the matrix. Space
 * Complexity: constant space as everything is in place.
 *
 **/
public class SearchSortedMatrix {

	public static class Coordinates {
		private int row;
		private int col;

		public Coordinates(int x, int y) {
			row = x;
			col = y;
		}

		public int getxAxis() {
			return row;
		}

		public void setxAxis(int xAxis) {
			this.row = xAxis;
		}

		public int getyAxis() {
			return col;
		}

		public void setyAxis(int yAxis) {
			this.col = yAxis;
		}

		@Override
		public String toString() {
			return row + "," + col;
		}
	}

	public static Coordinates searchSortedMatrixForAnInteger(int ipNumber, int[][] ipMatrix) {
		Coordinates searchCoordinates = new Coordinates((ipMatrix.length - 1), 0);
		/*Can we add a check here to see if the number is in between ipMatrix[0][ipMatrix[0].length-1] 
		 * and ipMatrix[ipMatrix.length-1][ipMatrix[0].length-1] then Search otherwise return -1,-1.
		 * 
		 * */
		while (searchCoordinates.getxAxis() > 0 && searchCoordinates.getyAxis() < ipMatrix[0].length) {
			if (ipMatrix[searchCoordinates.getxAxis()][searchCoordinates.getyAxis()] > ipNumber) {
				searchCoordinates.setxAxis(searchCoordinates.getxAxis() - 1);
			}
			if (ipMatrix[searchCoordinates.getxAxis()][searchCoordinates.getyAxis()] < ipNumber) {
				searchCoordinates.setyAxis(searchCoordinates.getyAxis() + 1);
			} else {
				return searchCoordinates;
			}
		}
		return new Coordinates(-1, -1);
	}

	public static void main(String[] args) {
		int[][] ipMatrix = new int[][] { { 1, 4, 7, 12, 15, 1000 }, { 2, 5, 19, 31, 32, 1001 },
				{ 3, 8, 24, 33, 35, 1002 }, { 40, 41, 42, 44, 45, 2003 }, { 99, 100, 103, 106, 128, 1004 } };
		System.out.println("Searching 41: " + searchSortedMatrixForAnInteger(41, ipMatrix));
		System.out.println("Searching 1004: " + searchSortedMatrixForAnInteger(1004, ipMatrix));
		System.out.println("Searching 1004: " + searchSortedMatrixForAnInteger(1004, ipMatrix));
	}
}
