package com.tds.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DEPARTMENT")
public class Department {
	
	@Id
	@Column(name = "DEPARTMENT_CODE")
	private int departmentCode;
	
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	public int getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	

}
