package com.java.spring.in28days.course.springin28days.CDI;

import javax.inject.Named;

@Named
public class jdbcConnection {

	public jdbcConnection() {
		System.out.println("Created JDBCConnection!!!!");
	}
}
