package com.java.spring.in28days.course.springin28days;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.java.spring.in28days.course.springin28days.basic.BinarySearchImplementation;

@SpringBootApplication
public class Springin28daysApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springin28daysApplication.class, args);
		BinarySearchImplementation searchAlgorithm = context.getBean(BinarySearchImplementation.class);
		int result = searchAlgorithm.searchNumber(new int[] { 1, 2, 5, 6 }, 3);
		System.out.println("Search result is: " + result);
	}

}
