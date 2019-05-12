package com.java.spring.in28days.course.springin28days;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.java.spring.in28days.componentscandemo.PeopleComponentDAO;

@SpringBootApplication
@ComponentScan("com.java.spring.in28days.componentscandemo")
public class Springin28daysComponntScanDemoApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(Springin28daysComponntScanDemoApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springin28daysScopeDemoApplication.class, args);
		PeopleComponentDAO peopleDao = context.getBean(PeopleComponentDAO.class);

	}

}
