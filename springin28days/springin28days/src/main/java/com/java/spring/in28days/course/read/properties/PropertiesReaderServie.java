package com.java.spring.in28days.course.read.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesReaderServie {

	@Value("${server.url}")
	private String serverUrl;

	public String readServerUrl() {
		return serverUrl;
	}
}
