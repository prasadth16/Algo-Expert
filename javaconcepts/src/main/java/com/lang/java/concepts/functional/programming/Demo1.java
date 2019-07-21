package com.lang.java.concepts.functional.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Demo of Function, BiFunction, Predicate and BiPredicate, Consumer, Supplier
 * 
 */
public class Demo1 {

	/**
	 * Functional Interface: Filter Abstract Method: test
	 **/
	public static void filterDemo() {
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.add(6);
		intList.add(7);
		intList.add(8);

		intList = intList.stream().filter(i -> i < 5).collect(Collectors.toList());
		for (Integer i : intList) {
			System.out.println(i);
		}

	}

	/**
	 * Functional Interface: BiFilter abstract Method: test
	 **/
	public static void biFilterDemo() {
		List<String> strList = new ArrayList<>();
		strList.add("My name is Prasad");
		strList.add("I stay in Germantown");
		strList.add("I like to play Cricket");
		int length = 10;
		BiPredicate<String, Integer> biPredicate = (str, len) -> str.contains("name") && str.length() > len;
		for (String str : strList) {
			if (biPredicate.test(str, length)) {
				System.out.println(str);
			}
		}
	}

	/**
	 * Functional Interface: Function Abstract Method: apply
	 **/
	public static void functionDemo() {
		String str = "my name is Prasad";
		Function<String, Integer> stringLengthFunction = strg -> strg.length();

		System.out.println(stringLengthFunction.apply(str));

	}

	/**
	 * Demonstration of Default Method andThen in Function Interface
	 **/
	public static void andThenDemo() {
		List<String> strList = new ArrayList<>();
		strList.add("my name ");
		strList.add("is Prasad %S");
		Function<List<String>, String> first = (strLst) -> {
			String opString = "";
			for (String s : strLst) {
				opString = opString + s;
			}
			return opString;
		};
		System.out.println("And Then .... " + first.andThen(s -> s.format(s, "Thakur")).apply(strList));
	}

	/**
	 * Demonstration of Default Method compose in Function Interface
	 **/
	public static void composeDemo() {
		List<String> strList = new ArrayList<>();
		strList.add("my name ");
		strList.add("is Prasad %S");
		Function<List<String>, String> first = (strLst) -> {
			String opString = "";
			for (String s : strLst) {
				opString = opString + s;
			}
			return opString;
		};
		Function<String, String> second = (st) -> st.format(st, "Thakur");
		System.out.println("Composing ... " + (second.compose(first)).apply(strList));
	}

	/**
	 * Demonstrattion of BiFunction abstract Method: apply
	 **/
	public static void biFunctionDemo() {
		String ipString = "My name is Prasad %s";
		BiFunction<String, String, String> biFunction = (s1, s2) -> String.format(s1, s2);

		System.out.println("BiFunction .... " + biFunction.apply(ipString, "Thakur"));
	}

	/**
	 * Functional InterFace: Consumer Abstract Method: consume
	 **/
	public static void consumerDemo() {
		List<String> strList = new ArrayList<>();
		strList.add("my name ");
		strList.add("is Prasad");
		/*
		 * forEach method takes Consumer which Consume every element in the list and
		 * performs whatever operation has to be performed.
		 * 
		 */
		strList.forEach(System.out::print);
	}

	/**
	 * Functional Interface: Supplier Abstract Method: supply This is used for
	 * defered execution: if (errorMessage != null) is false, String concatenation
	 * will not happen and hence we can save some processing time.
	 * 
	 */
	public static void supplierDemo() {
		String errorMessage = "Error has been raised";
		String exceptionName = "Sample Exception ";

		Supplier<String> stringSupplier = () -> exceptionName + errorMessage;

		if (errorMessage != null) {
			System.out.println("Supplier Demo!!!");
			System.out.println(stringSupplier.get());
		}

	}

	public static void main(String[] args) {
		filterDemo();
		biFilterDemo();
		functionDemo();
		andThenDemo();
		composeDemo();
		biFunctionDemo();
		consumerDemo();
		supplierDemo();
	}
}
