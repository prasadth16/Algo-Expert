package com.java.spring.in28days.course.springin28days;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.java.spring.in28days.course.springin28days.scope.PeopleDAO;

@SpringBootApplication
public class Springin28daysScopeDemoApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(Springin28daysScopeDemoApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springin28daysScopeDemoApplication.class, args);
		PeopleDAO peopleDao = context.getBean(PeopleDAO.class);
		PeopleDAO peopleDao1 = context.getBean(PeopleDAO.class);
		LOGGER.info("peopleDao: {}", peopleDao);
		LOGGER.info("peopleDao1: {}", peopleDao1);
		LOGGER.info("peopleDao->JDBCConnection: {}", peopleDao.getJDBCConnection());
		LOGGER.info("peopleDao1->JDBCConnection: {}", peopleDao1.getJDBCConnection());
	}

}
