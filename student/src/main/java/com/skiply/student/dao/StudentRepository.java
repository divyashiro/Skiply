package com.skiply.student.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.skiply.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Optional<Student> getStudentByNameAndMobileNumber(String name, Long mobileNumber);
	
	@Transactional
	@Modifying
	@Query("update Student s set s.isFeePaid = ?2 where id = ?1")
	void updateFeePaid(Long studentId, Boolean val);

}
