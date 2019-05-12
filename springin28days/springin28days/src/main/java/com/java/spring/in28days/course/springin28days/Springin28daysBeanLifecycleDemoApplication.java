package com.java.spring.in28days.course.springin28days;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.java.spring.in28days.course.springin28days.beanlifecycle.LifecycleDemoBean;

public class Springin28daysBeanLifecycleDemoApplication {

	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springin28daysScopeDemoApplication.class, args);
		LifecycleDemoBean demoBean = context.getBean(LifecycleDemoBean.class);

	}

}
