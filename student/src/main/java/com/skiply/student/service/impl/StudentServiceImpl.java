package com.skiply.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skiply.student.dao.StudentRepository;
import com.skiply.student.entity.Student;
import com.skiply.student.exception.StudentAlreadyExistsExeption;
import com.skiply.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		Optional<Student> isStudentPresent = studentRepository.getStudentByNameAndMobileNumber(student.getName(),
				student.getMobileNumber());
		
		if(isStudentPresent.isPresent()) {
			throw new StudentAlreadyExistsExeption("Record with Name - " +student.getName() + " and Mobile number - " + student.getMobileNumber() + " already present");
		} 
		return studentRepository.save(student);
	}
	
	public List<Student> addStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	@Override
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

}
