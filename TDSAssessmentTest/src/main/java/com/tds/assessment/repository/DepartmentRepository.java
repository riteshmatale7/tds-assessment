package com.tds.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tds.assessment.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	Department findByDepartmentName(String departName);

}
