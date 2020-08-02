package com.tds.assessment.mapper;

import java.util.ArrayList;
import java.util.List;

import com.tds.assessment.entity.Department;
import com.tds.assessment.entity.Employee;
import com.tds.assessment.exception.CountryRestCallException;
import com.tds.assessment.helper.CountryService;
import com.tds.assessment.model.Country;
import com.tds.assessment.model.DepartmentModel;
import com.tds.assessment.model.EmployeeModel;

public class EmployeeMapper {

	static ArrayList<Country> countryList = null;
	
	private static EmployeeModel employeeModelMap(Employee employee) {
		EmployeeModel model = new EmployeeModel();
		model.setId(employee.getId());
		model.setFirstname(employee.getFirstName());
		model.setLastname(employee.getLastName());
		model.setBadge_number(employee.getBadgeNumber());
		model.setCountry(getCountryName(employee.getCountryCode()));
		model.setJob_title(employee.getJobTitle().getJobTitleName());
		model.setDepartment(employee.getJobTitle().getDepartment().getDepartmentName());
		model.setStart_date(employee.getStartDate());
		model.setLeave_date(employee.getLeaveDate());		
		return model;
	}
	
	
	//mapping of dept list 
	public static List<EmployeeModel> mapEmployeeModelList(List<Employee> employeeList){
		countryList = getCountryDetails();
		ArrayList<EmployeeModel> empModelList = new ArrayList<EmployeeModel>();		
		for (Employee employee : employeeList) {
			EmployeeModel model = employeeModelMap(employee);
			empModelList.add(model);
		}						
		return empModelList;			
	}
	
	private static String getCountryName(String countryCode) {
		if(countryList != null && !countryList.isEmpty()) {
			if(countryCode != null && countryCode.length() == 2) {
				for(Country country : countryList) {
					if(country.getAlpha2Code().equalsIgnoreCase(countryCode)) {
						return country.getName();
					}					
				}
			}
			if(countryCode != null && countryCode.length() == 3) {
				for(Country country : countryList) {
					if(country.getAlpha3Code().equalsIgnoreCase(countryCode)) {
						return country.getName();
					}
				}
			}
		}else {
			throw new CountryRestCallException("Retrieval of Country Rest Call failed");
		}
		return null;		
	}

	private static ArrayList<Country> getCountryDetails(){
		CountryService countryService = new CountryService();
		if(countryList == null) {
			countryList = countryService.getCountryByCode("all");				
			return countryList;
		}else {
			return countryList;
		}		
	}
	

	
}
