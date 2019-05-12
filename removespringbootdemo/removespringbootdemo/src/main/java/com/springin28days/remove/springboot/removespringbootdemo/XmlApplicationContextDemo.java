package com.springin28days.remove.springboot.removespringbootdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springin28days.remove.springboot.removespringbootdemo.xmlconfiguration.PersonDao;

public class XmlApplicationContextDemo {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PersonDao person = context.getBean(PersonDao.class);
		person.printmessage();
		System.out.println("injected " + person.getjdbcConnection() + " in personDAO!!!");
	}

}
