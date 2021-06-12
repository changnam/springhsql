package com.honsoft.springhsql;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StudentDaoImplSupport extends JdbcDaoSupport implements StudentDao{

	@Override
	public Student getStudent(int id) {
		String sql = "select * from student where id = ?";
		Student student = (Student) getJdbcTemplate().queryForObject(sql, new Object[] {id},new StudentRowMapper());
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		String sql = "select * from student ";
		List<Student> students = getJdbcTemplate().query(sql, new StudentRowMapper());
		return students;
	}

	@Override
	public int insertStudent(Student student) {
		String sql = "insert into student (name,age) values (?,?)";
		getJdbcTemplate().update(sql,student.getName(),student.getAge());
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
