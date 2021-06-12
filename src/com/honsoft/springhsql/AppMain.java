package com.honsoft.springhsql;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.honsoft.springhsql.config.AppConfig;

public class AppMain {
	public static void main(String[] args) {
		//ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		

	      StudentDao studentDao = 
	         (StudentDao)context.getBean("studentDaoSupport");
	      
	      System.out.println("------Records Creation--------" );
	      studentDao.insertStudent(new Student("Zara", 11));
	      studentDao.insertStudent(new Student("Nuha", 2));
	      studentDao.insertStudent(new Student("Ayan", 15));

	      System.out.println("------Listing Multiple Records--------" );
	      List<Student> students = studentDao.getAllStudents();
	      
	      for (Student record : students) {
	         System.out.print("ID : " + record.getId() );
	         System.out.print(", Name : " + record.getName() );
	         System.out.println(", Age : " + record.getAge());
	      }

	      System.out.println("----Updating Record with ID = 2 -----" );
	     // studentJDBCTemplate.update(2, 20);

	      System.out.println("----Listing Record with ID = 2 -----" );
	      Student student = studentDao.getStudent(2);
	      System.out.print("ID : " + student.getId() );
	      System.out.print(", Name : " + student.getName() );
	      System.out.println(", Age : " + student.getAge());
	}
}
