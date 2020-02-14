package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Student;



	public interface StudentDAO {
		public  void saveStudent(Student student); 
		public List<Student> getStudents() ;
		public Student get(int theId);
		
		public void delete(int theId);
		//public Student mail(int theId);
		
			
		
}
	
