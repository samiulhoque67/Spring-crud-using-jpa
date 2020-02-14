package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Student;

public interface Studentservice {


List<Student> getStudents();

Student get(int theId);

void saveStudent(Student student);

void delete(int theId);

//Student sendmail(int theId);

}
