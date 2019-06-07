package com.spring.jdbc.basic.springjdbcdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJDBCDao {
	@Autowired
	private JdbcTemplate dbTemplate;

	public List<Person> getPersonData() {

		return dbTemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class));
		
	}
	public Person getPersonByID(Integer id) {
		return dbTemplate.queryForObject("select * from person where id=?", 
				new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
}
