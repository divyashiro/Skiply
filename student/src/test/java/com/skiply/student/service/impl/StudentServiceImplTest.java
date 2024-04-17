package com.skiply.student.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.skiply.student.dao.StudentRepository;
import com.skiply.student.entity.Student;

@SpringBootTest
public class StudentServiceImplTest {
	
	@InjectMocks
	StudentServiceImpl studentservice; 
	
	@Mock
	private StudentRepository studentRepository;
	
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
		when(studentRepository.save(any())).thenReturn(student);
		Student studentdata = studentservice.addStudent(student);
		Assert.assertTrue(studentdata != null);
	}

}
