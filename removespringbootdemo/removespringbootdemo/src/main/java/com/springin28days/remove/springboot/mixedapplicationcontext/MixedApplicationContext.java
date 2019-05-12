package com.springin28days.remove.springboot.mixedapplicationcontext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MixedApplicationContext {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MixedApplicationContext.xml");
		System.out.println("Bean Names are=>");
		for (String name : context.getBeanDefinitionNames()) {
			System.out.println(name + ",");
		}
	}
}
