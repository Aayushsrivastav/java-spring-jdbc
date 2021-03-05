package com.spring.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.springjdbc.dao.StudentDao;
import com.spring.springjdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.springjdbc.dao"})
public class jdbcConfig {
	
	@Bean(name = {"ds"})
	public DriverManagerDataSource getDatasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	@Bean(name = {"jdbcTemplate"})
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDatasource());
		return jdbcTemplate;
	}
	
//	@Bean(name = {"studentDao"})
//	public StudentDao getStudentDao() {
//		StudentDaoImpl studentDao = new StudentDaoImpl();
//		studentDao.setJdbcTemplate(getTemplate());
//		return studentDao;
//	}

}
