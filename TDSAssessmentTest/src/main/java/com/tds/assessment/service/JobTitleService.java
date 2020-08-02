package com.tds.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.Department;
import com.tds.assessment.entity.JobTitle;
import com.tds.assessment.exception.JobTitleDepartmentNotFoundException;
import com.tds.assessment.exception.JobTitleNotFoundException;
import com.tds.assessment.exception.handler.JobTitileDepartmentNotFoundExceptionHandler;
import com.tds.assessment.mapper.JobTitleMapper;
import com.tds.assessment.model.JobTitleModel;
import com.tds.assessment.repository.DepartmentRepository;
import com.tds.assessment.repository.JobTitleRepository;

@Service
public class JobTitleService {
	@Autowired
	private JobTitleRepository jobTitleRepo;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<JobTitleModel> getJobTitles(){
		List<JobTitle> jobTitles = jobTitleRepo.findAll();
		if(jobTitles != null && !jobTitles.isEmpty()) {
			List<JobTitleModel> models = JobTitleMapper.mapJobTitleModelList(jobTitles);
			return models;
			
		}else {
			throw new JobTitleNotFoundException("Job Tiles not found");
		}		
	}
	
	
	public List<JobTitleModel> getJobTitlesByDepartmentName(String departmentName){
		Department dept = getDepartmentDetails(departmentName);
		List<JobTitle> titles = getJobTitlesByDept(dept.getDepartmentCode(), departmentName);
		List<JobTitleModel> mapperList = JobTitleMapper.mapJobTitleModelList(titles);
		return mapperList;
	}
	
	//method to get list of job titles by department code
	private List<JobTitle> getJobTitlesByDept(int departmentCode, String departmentName){
		List<JobTitle> jobTitles = jobTitleRepo.findByDepartmentCode(departmentCode);
		if(jobTitles != null && !jobTitles.isEmpty()) {
			return jobTitles;
		}else {
			throw new JobTitleNotFoundException("No job titles are in department code : " + departmentName);
		}
	}

	//method to get department by dept name
	private Department getDepartmentDetails(String departmentName) {
		Department dept = departmentRepository.findByDepartmentName(departmentName);
		if(dept != null) {
			return dept;
		} else {
			throw new JobTitleDepartmentNotFoundException("Department is not valid : " + departmentName);
		}
	}
	


}
