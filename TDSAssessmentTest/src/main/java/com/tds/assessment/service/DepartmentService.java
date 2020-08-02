package com.tds.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.Department;
import com.tds.assessment.exception.DepartmentNotFoundException;
import com.tds.assessment.mapper.DepartmentMapper;
import com.tds.assessment.model.DepartmentModel;
import com.tds.assessment.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository deptRepository;
	
	
	//method to get all departments
	public List<DepartmentModel> getDepartments(){ 
		List<Department> departments = deptRepository.findAll();
		if(departments != null && !departments.isEmpty()) {
			List<DepartmentModel> modelList = DepartmentMapper.mapDepartmentModelList(departments);
			return modelList;			
		}else {
			throw new DepartmentNotFoundException("No departments present in database");
		}		
	}
	 
	
}
