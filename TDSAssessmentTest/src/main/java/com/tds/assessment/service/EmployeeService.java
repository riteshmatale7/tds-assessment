package com.tds.assessment.service;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.DeploymentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.Department;
import com.tds.assessment.entity.Employee;
import com.tds.assessment.entity.JobTitle;
import com.tds.assessment.exception.DepartmentInvalidException;
import com.tds.assessment.exception.DepartmentNotFoundException;
import com.tds.assessment.exception.EmployeeNotFoundException;
import com.tds.assessment.exception.JobTitleDepartmentNotFoundException;
import com.tds.assessment.helper.CountryService;
import com.tds.assessment.mapper.EmployeeMapper;
import com.tds.assessment.model.Country;
import com.tds.assessment.model.EmployeeModel;
import com.tds.assessment.repository.DepartmentRepository;
import com.tds.assessment.repository.EmployeeRepository;
import com.tds.assessment.repository.JobTitleRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired 
	private DepartmentRepository deptRepo;
	
	@Autowired
	private JobTitleRepository jobTitleRepo;
	
	//method to get all employees
	public List<EmployeeModel> getEmployees(){		
		List<Employee> employeeList = empRepo.findAll();
		List<EmployeeModel> modelList = EmployeeMapper.mapEmployeeModelList(employeeList);
		if( modelList != null && !modelList.isEmpty() ) {
			return modelList;			
		}else {
			throw new EmployeeNotFoundException("No Employees present");
		}
	}

	//method to get employees by department name
	public List<EmployeeModel> getEmployeesByDeptName(String departmentName) {
		
		if(departmentName != null && !departmentName.isEmpty()) {
			Department dept = deptRepo.findByDepartmentName(departmentName);
			if(dept != null){												
				List<JobTitle> jobTitleList = jobTitleRepo.findByDepartmentCode(dept.getDepartmentCode());
				if(jobTitleList != null && !jobTitleList.isEmpty()) {

					List<Employee> allEmplList = new ArrayList<Employee>();
					for (JobTitle jobTitleObj : jobTitleList) {
						List<Employee> emplList = empRepo.findByJobTitleCode(jobTitleObj.getJobTitleCode());
						allEmplList.addAll(emplList);
					}
					
					List<EmployeeModel> modelList = EmployeeMapper.mapEmployeeModelList(allEmplList);
					if( modelList != null && !modelList.isEmpty() ) {
						return modelList;			
					}else {
						throw new EmployeeNotFoundException("No Employees present for depatment : " + departmentName);
					}

				}else {
					throw new JobTitleDepartmentNotFoundException("No Job Titles found for department : " + departmentName);
				}
				
			}else {
				throw new DepartmentNotFoundException("Department Not found : " + departmentName);			
			}
		}else {
			throw new DepartmentInvalidException("Please enter valid Department");
		}
		
		
		
	}

	//method to get active employees
	public List<EmployeeModel> getActiveEmployees() {
		List<Employee> emplList =empRepo.findActiveEmployees();
		if(emplList != null && !emplList.isEmpty()) {
			List<EmployeeModel> modelList = EmployeeMapper.mapEmployeeModelList(emplList);
			return modelList;			
		}else {
			throw new EmployeeNotFoundException("No Active Employees");
		}
		
	}
	

}
