package com.category.simple;

import java.util.HashMap;
import java.util.Map;

public class RectangleMeniaAlgorithmImplementation {
	private static Map<String, Boolean> coordinatesMap;

	public static void main(String[] args) {
		Coordinates c0 = new Coordinates(0, 0);
		Coordinates c1 = new Coordinates(0, 1);
		Coordinates c2 = new Coordinates(1, 1);
		Coordinates c3 = new Coordinates(1, 0);
		Coordinates c4 = new Coordinates(2, 1);
		Coordinates c5 = new Coordinates(2, 0);
		Coordinates c6 = new Coordinates(3, 1);
		Coordinates c7 = new Coordinates(3, 0);
		System.out.println(getRectangleCount(new Coordinates[] { c0, c1, c2, c3, c4, c5, c6, c7}));
	}

	private static int getRectangleCount(Coordinates[] coordinates) {
		int rectangleCount = 0;
		coordinatesMap = createCoOrdinateMap(coordinates);

		for (int i = 0; i < coordinates.length; i++) {
			for (int j = 0; j < coordinates.length; j++) {
				if (coordinates[i].getX() < coordinates[j].getX() && coordinates[i].getY() < coordinates[j].getY()) {
					if (coordinatesMap.get(coordinates[i].getX() + "-" + coordinates[j].getY())
							&& coordinatesMap.get(coordinates[j].getX() + "-" + coordinates[i].getY())) {
						rectangleCount++;
					}
				}
			}
		}

		return rectangleCount;
	}

	private static Map<String, Boolean> createCoOrdinateMap(Coordinates[] coordinates) {
		Map<String, Boolean> cartMap = new HashMap<String, Boolean>();

		for (Coordinates c : coordinates) {
			cartMap.put(c.toString(), true);
		}
		return cartMap;
	}

	private static class Coordinates {
		private int x;
		private int y;

		public Coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return x + "-" + y;
		}
	}

}
