package com.tds.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tds.assessment.entity.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer>{

	List<JobTitle> findByDepartmentCode(int departmentCode);

}
