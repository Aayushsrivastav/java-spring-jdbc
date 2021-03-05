package com.spring.springjdbc.dao;

import java.util.List;

import com.spring.springjdbc.entites.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentID);
	public Student getStudent(int studentID);
	public List<Student> getAllStudents();
}
