package com.skiply.student.service;

import java.util.List;

import com.skiply.student.entity.Student;
import com.skiply.student.exception.StudentAlreadyExistsExeption;

public interface StudentService {
	
	Student addStudent(Student student) throws StudentAlreadyExistsExeption;
	
	List<Student> addStudents(List<Student> students);

	List<Student> getStudents();
	
	Student getStudentById(Long studentId);
	

}
