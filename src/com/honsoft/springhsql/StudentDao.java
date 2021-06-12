package com.honsoft.springhsql;

import java.util.List;

public interface StudentDao {
	public Student getStudent(int id);
	public List<Student> getAllStudents();
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int id);
	
}
