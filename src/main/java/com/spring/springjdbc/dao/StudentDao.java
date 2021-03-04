package com.spring.springjdbc.dao;

import com.spring.springjdbc.entites.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(int studentID);
	public Student getStudent(int studentID);
}
