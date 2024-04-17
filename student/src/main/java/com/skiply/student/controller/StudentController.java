package com.skiply.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skiply.student.entity.Student;
import com.skiply.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		Student createdstudent = studentService.addStudent(student);
		return new ResponseEntity<>(createdstudent, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getStudents(){
		List<Student> students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long studentId){
		Student student = studentService.getStudentById(studentId);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

}
