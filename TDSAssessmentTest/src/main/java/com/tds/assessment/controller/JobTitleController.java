package com.tds.assessment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.JobTitle;
import com.tds.assessment.helper.CountryService;
import com.tds.assessment.model.Country;
import com.tds.assessment.model.JobTitleModel;
import com.tds.assessment.service.JobTitleService;

@RestController
public class JobTitleController {
	@Autowired
	private JobTitleService jobTitleService;
	
	
	@RequestMapping("/job_titles")
	public List<JobTitleModel> findAllJobTitles(){				
		return jobTitleService.getJobTitles();
	}
	
	
	@RequestMapping(value = "/job_titles/{department_name}")
	public List<JobTitleModel> findJobTitlesByDeptName(@PathVariable String department_name){
		return jobTitleService.getJobTitlesByDepartmentName(department_name);
		
	}
	
}
