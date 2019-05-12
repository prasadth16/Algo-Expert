package com.java.spring.in28days.course.springin28days;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.java.spring.in28days.course.springin28days.CDI.PersonCDIDAO;
import com.java.spring.in28days.course.springin28days.beanlifecycle.LifecycleDemoBean;

public class Springin28daysCDIDemoApplication2 {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springin28daysScopeDemoApplication.class, args);
		PersonCDIDAO demoBean = context.getBean(PersonCDIDAO.class);

		System.out.println(
				"PersonCDIDAO created " + demoBean + "And JDBCCOnnection Injected in it->" + demoBean.getConnection());

	}

}
