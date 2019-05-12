package com.springin28days.remove.springboot.removespringbootdemo.xmlconfiguration;

public class PersonDao {

	private JDBCConnection jdbcConnection;

	public PersonDao(JDBCConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
	public PersonDao() {
		System.out.println("PersonDao created!!!");
	}

	public JDBCConnection getjdbcConnection() {
		return jdbcConnection;
	}

	public void setjdbcConnection(JDBCConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	public void printmessage() {
		System.out.println("Printing the message!!!");
	}
}
