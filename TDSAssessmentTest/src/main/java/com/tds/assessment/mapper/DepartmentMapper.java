package com.tds.assessment.mapper;

import java.util.ArrayList;
import java.util.List;

import com.tds.assessment.entity.Badge;
import com.tds.assessment.entity.Department;
import com.tds.assessment.model.BadgeModel;
import com.tds.assessment.model.DepartmentModel;

public class DepartmentMapper {

	public static DepartmentModel departmentModelmapBadgeObj(Department department) {
		DepartmentModel model = new DepartmentModel();
		model.setDepartment_code(department.getDepartmentCode());
		model.setDepartment_name(department.getDepartmentName());
		return model;		
	}
	
	//mapping of dept list 
	public static List<DepartmentModel> mapDepartmentModelList(List<Department> departmentList){
		ArrayList<DepartmentModel> deptModelList = new ArrayList<DepartmentModel>();		
		for (Department dept : departmentList) {
			DepartmentModel deptModel = departmentModelmapBadgeObj(dept);
			deptModelList.add(deptModel);
		}						
		return deptModelList;			
	}
	
}
