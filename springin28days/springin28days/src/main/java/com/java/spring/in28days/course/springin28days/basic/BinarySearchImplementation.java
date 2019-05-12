package com.java.spring.in28days.course.springin28days.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImplementation {

	@Autowired
	private SortAlgorithm sortService;

	public BinarySearchImplementation(SortAlgorithm sortService) {
		this.sortService = sortService;
	}

	public int searchNumber(int[] input, int numberToBeSearched) {
		System.out.println("Sort service being used is:" + sortService);
		return numberToBeSearched;
	}
}
