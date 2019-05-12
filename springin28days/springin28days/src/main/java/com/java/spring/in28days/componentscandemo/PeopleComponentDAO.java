package com.java.spring.in28days.componentscandemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeopleComponentDAO {
@Autowired
private JDBCComponentConnection jdbcConnection;

public JDBCComponentConnection getJDBCConnection() {
	return jdbcConnection;
}

	

}
