package com.spring.jdbc.basic.springjdbcdemo;

import java.util.Date;

public class Person {
	private Integer id;
	private String name;
	private String location;
	private Date birth_date;

	public Person(Integer id, String name, String location, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birth_date = birth_date;
	}

	public Person() {

	}

	public String toString() {
		return this.name + "--" + this.location + "--" + this.birth_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

}
