package com.category.simple;

import java.util.ArrayList;
import java.util.List;
/**Knapsack Problem. Please check Algo-expert for more problem description
 * Time Complexity: O(m*n) where m is number of products and n is maximum weight
 * Space Complexity: O(m*n) 
 * **/
public class KnapSackDynamicProgramingSolution {

	static class Product {

		private int weight;
		private int price;

		public Product(int weight, int price) {
			super();
			this.weight = weight;
			this.price = price;
		}

		public int getWeight() {
			return weight;
		}

		public int getPrice() {
			return price;
		}

	}

	public static void getKnapsackMaxPrice(Product[] products, int maxCapacity) {
		int[][] priceGrid = new int[products.length][maxCapacity + 1];
		for (int i = 0; i < products.length; i++) {
			for (int j = 0; j <= maxCapacity; j++) {
				if (i == 0) {
					if (products[i].getWeight() <= j) {
						priceGrid[i][j] = products[i].getPrice();
					}
				} else {
					if (products[i].getWeight() > j) {
						priceGrid[i][j] = priceGrid[i - 1][j];
					} else {
						priceGrid[i][j] = Integer.max(priceGrid[i - 1][j],
								priceGrid[i][j - products[i].getWeight()] + products[i].getPrice());
					}
				}
			}
		}
		System.out.println("Population Done, Max Price is :" + priceGrid[products.length - 1][maxCapacity]);
		printIncludedItems(priceGrid, products, maxCapacity);
	}

	private static void printIncludedItems(int[][] priceGrid, Product[] products, int maxCapacity) {
		List<Integer> printProducts = new ArrayList<>();
		int i = products.length - 1;
		int j = maxCapacity;
		while (priceGrid[i][j] > 0) {
			if (priceGrid[i][j] > priceGrid[i-1][j]) {
				printProducts.add(i+1);
				j -= products[i].getWeight();
				i -= 1;
				
			} else  {

				i -= 1;

			}
		}
		System.out.println("Products in the Knapsack are: ");
		for (Integer p : printProducts) {
			System.out.println(p + "<-");
		}
	}

	public static void main(String[] args) {
		Product p1 = new Product(5, 60);
		Product p2 = new Product(3, 50);
		Product p3 = new Product(4, 70);
		Product p4 = new Product(2, 30);
		getKnapsackMaxPrice(new Product[] { p1, p2, p3, p4 }, 5);

	}
}
