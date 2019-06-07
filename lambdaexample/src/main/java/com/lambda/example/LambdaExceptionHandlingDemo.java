package com.lambda.example;

import java.util.function.BiConsumer;

public class LambdaExceptionHandlingDemo {

	public static void arithmaticBiconsumer(int[] ipArray, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : ipArray) {
			consumer.accept(i, key);
		}
	}

	public static void arithmaticBiconsumer(Double[] ipArray, Double key, BiConsumer<Double, Double> consumer) {
		for (Double i : ipArray) {
			consumer.accept(i, key);
		}
	}

	public static <T> BiConsumer<T, T> biConsumerWrapper(BiConsumer<T, T> consumer) {
		return (i, k) -> {
			try {
				consumer.accept(i, k);
			} catch (ArithmeticException e) {
				System.out.println("arithmetic Exception thrown!!!!!");
			}
		};

	}

}
