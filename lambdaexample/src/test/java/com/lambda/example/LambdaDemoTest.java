package com.lambda.example;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class LambdaDemoTest {
	private List<Person> people;
	private List<Person> filteredPeopleList;

	@Before
	public void setup() {
		people = new ArrayList<>();
		filteredPeopleList = new ArrayList<>();
		people.add(new Person("Saumya", "Thakur", 9, "Unmarried"));
		people.add(new Person("Prasad", "Takur", 39, "Married"));
		people.add(new Person("Kishore", "Dabholkar", 43, "Married"));
		people.add(new Person("Hemant", "Dhabholkar", 9, "Married"));
		people.add(new Person("Milind", "Debholkar", 9, "Married"));
		filteredPeopleList.add(new Person("Kishore", "Dabholkar", 43, "Married"));
		filteredPeopleList.add(new Person("Milind", "Debholkar", 9, "Married"));
		filteredPeopleList.add(new Person("Hemant", "Dhabholkar", 9, "Married"));

	}

	@Test
	void testLambdaOperations() {
		setup();
		List<Person> testFilteredList = LambdaDemo.peopleOperations(people, "D");

		assertTrue(LambdaDemo.peopleOperations(people, "D").containsAll(filteredPeopleList)
				&& LambdaDemo.peopleOperations(people, "D").size() == 3);
		assertIterableEquals(filteredPeopleList, testFilteredList,
				"Assertion Failed, Filtered list does not match with the expected one!!!");
	}

	@Test
	public void testLambdaExceptionFunction() {
		LambdaExceptionHandlingDemo.arithmaticBiconsumer(new int[] { 1, 2, 3, 4, 5 }, 0,
				LambdaExceptionHandlingDemo.biConsumerWrapper((i, k) -> System.out.println(i / k)));
		LambdaExceptionHandlingDemo.arithmaticBiconsumer(new int[] { 1, 2, 3, 4, 5 }, 5,
				LambdaExceptionHandlingDemo.biConsumerWrapper((i, k) -> System.out.println(i + k)));
		LambdaExceptionHandlingDemo.arithmaticBiconsumer(new Double[] { 1.1, 2.3, 3.4, 4.5, 5.6 }, Double.valueOf(5.5),
				LambdaExceptionHandlingDemo.biConsumerWrapper((i, k) -> System.out.println(i + k)));
	}

}
