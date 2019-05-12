package com.java.spring.in28days.course.springin28days.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeopleDAO {
@Autowired
private JDBCConnection jdbcConnection;

public JDBCConnection getJDBCConnection() {
	return jdbcConnection;
}

	

}
