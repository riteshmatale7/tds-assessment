package com.tds.assessment.mapper;

import java.util.ArrayList;
import java.util.List;

import com.tds.assessment.entity.Department;
import com.tds.assessment.entity.JobTitle;
import com.tds.assessment.model.DepartmentModel;
import com.tds.assessment.model.JobTitleModel;

public class JobTitleMapper {

	public static JobTitleModel jobTitleModelMap(JobTitle jobTitle) {
		JobTitleModel model = new JobTitleModel();
		model.setJob_title_code(jobTitle.getJobTitleCode());
		model.setJob_title_name(jobTitle.getJobTitleName());
		model.setDepartment_name(jobTitle.getDepartment().getDepartmentName());
		
		return model;		
	}
	
	//mapping of dept list 
	public static List<JobTitleModel> mapJobTitleModelList(List<JobTitle> jobTitleList){
		ArrayList<JobTitleModel> jobTitleModelList = new ArrayList<JobTitleModel>();		
		for (JobTitle jobTitle : jobTitleList) {
			JobTitleModel jobTitleModel = jobTitleModelMap(jobTitle);
			jobTitleModelList.add(jobTitleModel);
		}						
		return jobTitleModelList;			
	}

}
