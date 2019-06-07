package com.spring.jdbc.basic.springjdbcdemo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringJdbcDemoApplication.class, args);
		PersonJDBCDao personDAO=context.getBean(PersonJDBCDao.class);
		List<Person> persons=personDAO.getPersonData();
		System.out.println("Printing List of People");
		persons.forEach(System.out::println);
		System.out.println("Getting the Person's Details for ID 10001: "+personDAO.getPersonByID(10001));
	}

}
