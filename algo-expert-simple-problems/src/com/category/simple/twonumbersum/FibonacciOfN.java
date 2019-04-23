package com.category.simple.twonumbersum;

/**
 * Here we are using the dynamic programming and storing the intermediate results in some data structure and hence the time complexity isO(n)
 * and space complexity is O(n) as there can be maximum of n recursive method calls on the class stack.
 * With dynamic programming and recursion the time complexity will increase to O(2^n)
 * 
 *  Another Approach to solve this would be iterative program which would need same time complexity of O(n),
 *  but as we would not use the recursion, the space complexity would be constant i.e. O(1) 
 * **/
public class FibonacciOfN {

	public static Integer fibonacci(Integer n, Integer[] store) {
		Integer fib = 0;
		Integer lastfib = 0;
		Integer lastToLastFib = 0;

		if (n == 1) {
			System.out.println(1);

			return 0;
		} else if (n == 2) {
			System.out.println(0);

			return 1;
		}
		if (store[n - 1] != null)
			lastfib = store[n - 1];
		else {
			lastfib = fibonacci(n - 1, store);
			store[n - 1] = lastfib;
		}
		if (store[n - 2] != null)
			lastToLastFib = store[n - 2];
		else {
			lastToLastFib = fibonacci(n - 2, store);
			store[n - 2] = lastToLastFib;
		}
		fib = lastfib + lastToLastFib;

		System.out.println(fib);
		return fib;

	}

	public static void main(String[] args) {
		Integer[] store = new Integer[11];
		fibonacci(10, store);

	}
}
