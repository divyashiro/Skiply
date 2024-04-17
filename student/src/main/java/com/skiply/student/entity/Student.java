package com.skiply.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	
	private String name;
	
	@Id
	@GeneratedValue
	private Long id;
	private String grade;
	private Long mobileNumber;
	private String schoolName;
	private Boolean isFeePaid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", grade=" + grade + ", mobileNumber=" + mobileNumber
				+ ", schoolName=" + schoolName + "]";
	}
	public Boolean getIsFeePaid() {
		return isFeePaid;
	}
	public void setIsFeePaid(Boolean isFeePaid) {
		this.isFeePaid = isFeePaid;
	}
	
	
	

}
