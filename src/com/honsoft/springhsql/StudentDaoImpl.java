package com.honsoft.springhsql;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Student getStudent(int id) {
		String SQL = "select * from Student where id = ?";
		Student student = (Student) jdbcTemplate.queryForObject(SQL, new Object[] { id }, new StudentRowMapper());
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplate.query(SQL, new StudentRowMapper());
		return students;
	}

	@Override
	public int insertStudent(Student student) {
		String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplate.update(SQL, student.getName(), student.getAge());
		System.out.println("Created Record Name = " + student.getName() + " Age = " + student.getAge());
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
