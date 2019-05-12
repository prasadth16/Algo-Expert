package com.springin28days.remove.springboot.removespringbootdemo.removedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {
	@Autowired
	private JDBCConnection connection;

	public JDBCConnection getConnection() {
		return connection;
	}
	
	
}
