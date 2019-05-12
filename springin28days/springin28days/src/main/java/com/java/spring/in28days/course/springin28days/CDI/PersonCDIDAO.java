package com.java.spring.in28days.course.springin28days.CDI;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PersonCDIDAO {
	@Inject
	private jdbcConnection connection;

	public PersonCDIDAO() {
		System.out.println("created PersonCDIDAO!!!!");
	}

	public jdbcConnection getConnection() {
		return connection;
	}
	
}
