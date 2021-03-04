package com.spring.springjdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.springjdbc.dao.StudentDao;
import com.spring.springjdbc.entites.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Start" );
        
        //Spring jdbc
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/springjdbc/config.xml");
//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        
//        //Insert query
//        String insertQuery = "insert into student(id, name, city) values(?, ?, ?)";
//        
//        //Execute query
//        int result = template.update(insertQuery, 48, "wick", "delhi");
//        System.out.println("number of record inserted :"+ result);
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        //////////////////////INSERT/////////////////////////////
//        Student student = new Student();
//        student.setId(666);
//        student.setName("stwert");
//        student.setCity("Chennai");
//        int insert = studentDao.insert(student);
//        System.out.println("Student added :" + insert);
        
        ////////////////////////////UPDATE/////////////////////
//        Student student = new Student();
//	      student.setId(666);
//	      student.setName("raj");
//	      student.setCity("bangaluru");
//	      
//	    int result = studentDao.change(student);
//        System.out.println("Student updated row :" + result);
        
        ///////////////////////////DELETE/////////////////////////////////
//        Scanner sc = new Scanner(System.in);
//        int id = sc.nextInt();
//        int result = studentDao.delete(id);
//        System.out.println("Deleted row :" + result);
//        sc.close();
        
        /////////////////////////Single data////////////////////
        
        Student student = studentDao.getStudent(222);
        System.out.println(student);
    }
}
