package com.springin28days.remove.springboot.removespringbootdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springin28days.remove.springboot.removespringbootdemo.removedemo.PersonDao;

//@SpringBootApplication remove this dependency and add @Configuration
@Configuration
//Add @Component scan as this is not done in spring automatically unlike Spring Boot
@ComponentScan
public class RemovespringbootdemoApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				RemovespringbootdemoApplication.class)) {
			PersonDao person = context.getBean(PersonDao.class);
			System.out.println("created " + person + " And injected " + person.getConnection() + " in it.");
		}

	}

}
