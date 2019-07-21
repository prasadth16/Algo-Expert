package com.lang.java.concepts.functional.stream.operations;

import java.util.Arrays;
import java.util.List;

public class DataExtractor {
	
	static List<StreamOperations.Book> getFromAmazon(String keyword) {
		StreamOperations.Book b1 = new StreamOperations.Book(9780596009201L, "Java 1", 4.0, 25.0, "Amazon");
		StreamOperations.Book b2 = new StreamOperations.Book(9780596009202L, "Java 2", 4.1, 25.0, "Amazon");
		StreamOperations.Book b3 = new StreamOperations.Book(9780596009203L, "Java 3", 4.5, 25.0, "Amazon");
		StreamOperations.Book b4 = new StreamOperations.Book(9780596009204L, "Java 4", 4.5, 25.0, "Amazon");
		StreamOperations.Book b5 = new StreamOperations.Book(9780596009205L, "Java 5", 3.9, 30.0, "Amazon");
		StreamOperations.Book b6 = new StreamOperations.Book(9780596009206L, "Java 6", 4.8, 40.0, "Amazon");
		StreamOperations.Book b7 = new StreamOperations.Book(9780596009207L, "Java 7", 4.9, 40.0, "Amazon");
		StreamOperations.Book b8 = new StreamOperations.Book(9780596009208L, "Java 8", 4.7, 50.0, "Amazon");
		StreamOperations.Book b9 = new StreamOperations.Book(9780596009209L, "Java 9", 4.3, 50.0, "Amazon");
		StreamOperations.Book b10 = new StreamOperations.Book(9780596009210L, "Java 10", 4.5, 60.0, "Amazon");
		
		return Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b7, b8, b9, b10);
	}
	
	static List<StreamOperations.Book> getFromBarnesAndNoble(String keyword) {
		StreamOperations.Book b1 = new StreamOperations.Book(9780596009201L, "Java 1", 3.9, 20.0, "B&N");
		StreamOperations.Book b2 = new StreamOperations.Book(9780596009202L, "Java 2", 4.1, 20.0, "B&N");
		StreamOperations.Book b3 = new StreamOperations.Book(9780596009203L, "Java 3", 4.6, 20.0, "B&N");
		StreamOperations.Book b4 = new StreamOperations.Book(9780596009204L, "Java 4", 4.5, 20.0, "B&N");
		StreamOperations.Book b5 = new StreamOperations.Book(9780596009211L, "Java 11", 4.9, 40.0, "B&N");
		StreamOperations.Book b6 = new StreamOperations.Book(9780596009212L, "Java 12", 4.9, 55.0, "B&N");
		StreamOperations.Book b7 = new StreamOperations.Book(9780596009213L, "Java 13", 4.9, 60.0, "B&N");
		
		return Arrays.asList(b1, b2, b3, b4, b5, b6, b7);
	}
}
