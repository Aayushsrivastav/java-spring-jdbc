package com.spring.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.springjdbc.entites.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
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
	
	public List<Student> getAllStudents() {
		//Selecting multiple student
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
