package com.skiply.student.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skiply.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Optional<Student> getStudentByNameAndMobileNumber(String name, Long mobileNumber);

}
