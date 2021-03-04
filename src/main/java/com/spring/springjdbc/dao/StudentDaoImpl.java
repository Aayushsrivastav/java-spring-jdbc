package com.spring.springjdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.springjdbc.entites.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		String insertQuery = "insert into student(id, name, city) values(?, ?, ?)";
		int result = this.jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getCity());
		return result;
	}
	
	public int change(Student student) {
		String updateQuery = "update student set name = ?, city = ? where id = ?";
		int result = this.jdbcTemplate.update(updateQuery, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(int studentID) {
		String deleteQuery = "delete from student where id = ?";
		int result = this.jdbcTemplate.update(deleteQuery, studentID);
		return result;
	}
	
	public Student getStudent(int studentID) {
		//Select single student data
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentID);
		return student;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
