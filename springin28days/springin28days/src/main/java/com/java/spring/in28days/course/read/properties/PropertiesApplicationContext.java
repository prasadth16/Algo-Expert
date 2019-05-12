package com.java.spring.in28days.course.read.properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:urlproperty.properties")
public class PropertiesApplicationContext {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PropertiesApplicationContext.class)) {
			PropertiesReaderServie service = context.getBean(PropertiesReaderServie.class);
			System.out.println("Server URL is: " + service.readServerUrl());
		}
	}

}
