package com.skiply.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skiply.student.entity.StudentReceiptMapping;

public interface StudentReceiptMappingRepository extends JpaRepository<StudentReceiptMapping, Long> {

}
