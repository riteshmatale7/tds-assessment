package com.tds.assessment.entity;
//Lombok -- auto generate getter setter

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Job_Title")
public class JobTitle {
	
	@Id
	@Column(name = "Job_Title_Code")
	private int jobTitleCode;
	
	@Column(name = "Job_Title_Name")
	private String jobTitleName;
	
	@Column(name = "Department_code")
	private int departmentCode;

	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "Department_Code", insertable = false, updatable = false)
	private Department department;
	
	
	
	public int getJobTitleCode() {
		return jobTitleCode;
	}

	public void setJobTitleCode(int jobTitleCode) {
		this.jobTitleCode = jobTitleCode;
	}

	public String getJobTitleName() {
		return jobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}

	public int getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
