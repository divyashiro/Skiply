package com.skiply.student.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.skiply.student.entity.Student;
import com.skiply.student.service.StudentService;

@SpringBootTest
public class StudentControllerTest {
	
	
	@InjectMocks
	StudentController studentController; 
	
	@Mock
	private StudentService studentService;
	
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void addStudent() {
		Student student = new Student();
		student.setGrade("3");
		student.setMobileNumber((long) 776655449);
		student.setName("Blake");
		student.setSchoolName("Presidency");
		student.setIsFeePaid(false);
		student.setId((long) 2);
		when(studentService.addStudent(any())).thenReturn(student);
		ResponseEntity<?> stduentData = studentController.addStudent(student);
		Assert.assertTrue(stduentData != null && HttpStatus.CREATED.equals(stduentData.getStatusCode()));
	}

}
