package com.tds.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.Department;
import com.tds.assessment.model.DepartmentModel;
import com.tds.assessment.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/department")
	public List<DepartmentModel> findAllDepartments(){
		return deptService.getDepartments();
	}
	
}
