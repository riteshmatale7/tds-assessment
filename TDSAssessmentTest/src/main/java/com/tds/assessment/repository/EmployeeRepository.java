package com.tds.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tds.assessment.entity.Badge;
import com.tds.assessment.entity.Employee;
import com.tds.assessment.entity.JobTitle;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByJobTitleCode(int jobTitleCode);
	
	@Query("SELECT E FROM Employee E WHERE E.leaveDate is NULL OR E.leaveDate > SYSDATE")
	public List<Employee> findActiveEmployees();


}
