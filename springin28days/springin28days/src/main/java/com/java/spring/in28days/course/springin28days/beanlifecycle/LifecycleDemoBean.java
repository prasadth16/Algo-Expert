package com.java.spring.in28days.course.springin28days.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.java.spring.in28days.course.springin28days.Springin28daysBeanLifecycleDemoApplication;

@Component
public class LifecycleDemoBean {

	private static Logger LOGGER = LoggerFactory.getLogger(Springin28daysBeanLifecycleDemoApplication.class);

	public LifecycleDemoBean() {
		LOGGER.info("LifecycleDemoBean created!!!!");
	}

	@PostConstruct
	private void postConstructDemoMethod() {
		LOGGER.info("Post Construct Demo Method is called!!!");
	}

	@PreDestroy
	private void preDestroyDemoMethod() {
		LOGGER.info("Pre Destroy Demo Method is called!!!");
	}
}
