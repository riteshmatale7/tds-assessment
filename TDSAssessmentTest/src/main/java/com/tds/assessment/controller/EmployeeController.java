package com.tds.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.Employee;
import com.tds.assessment.model.EmployeeModel;
import com.tds.assessment.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employees")
	public List<EmployeeModel> findEmployees(){
		return employeeService.getEmployees();
	}
	
	@RequestMapping(value = "/employees", params = "department_name")
	public List<EmployeeModel> findEmployeesByDept(@RequestParam String department_name){
		String departmentName = department_name;
		return employeeService.getEmployeesByDeptName(departmentName);	
	}
	
	@RequestMapping("/employees/active")
	public List<EmployeeModel> findActiveEmployees(){
		return employeeService.getActiveEmployees();
	}
	
}
