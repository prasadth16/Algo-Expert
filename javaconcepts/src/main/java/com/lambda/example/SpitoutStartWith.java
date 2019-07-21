package com.lambda.example;

import java.util.List;
@FunctionalInterface
public interface SpitoutStartWith {
	public List<Person> getSurnamesStartWith(List<Person> inputList, String startWith);

}
