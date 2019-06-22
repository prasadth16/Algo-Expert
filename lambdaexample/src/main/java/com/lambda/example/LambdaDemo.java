package com.lambda.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo {
	public static List<Person> peopleOperations(List<Person> people, String filterBy) {

		Collections.sort(people, (T1, T2) -> T1.getLastName().compareToIgnoreCase(T2.getLastName()));

		people.forEach(System.out::println);

		List<Person> filteredPeople=filterSurnames(people, filterBy, (lst, st) -> {
			return lst.stream().filter(p -> p.getLastName().startsWith(st, 0)).collect(Collectors.toList());
		});
		return filteredPeople;
	}

	public static List<Person> filterSurnames(List<Person> inputList, String StartWith, SpitoutStartWith function) {

		return function.getSurnamesStartWith(inputList, StartWith);
	}
}
