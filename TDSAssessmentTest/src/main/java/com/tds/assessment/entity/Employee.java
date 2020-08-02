package com.tds.assessment.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	private int id;

	@Column(name = "Firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;	
	
	@Column(name = "Badge_Number")
	private int badgeNumber;

	@Column(name = "Country_Code")
	private String countryCode;

	@Column(name = "Job_Title_Code")
	private int jobTitleCode;
	
	@Column(name = "Start_Date")
	private Date startDate;
	
	@Column(name = "Leave_Date")
	private Date leaveDate;
	
	@OneToOne(targetEntity = Badge.class)
	@JoinColumn(name = "Badge_Number", insertable = false, updatable = false)
	private Badge badge;
	
	@OneToOne(targetEntity = JobTitle.class)
	@JoinColumn(name = "Job_Title_code", insertable = false, updatable = false)
	private JobTitle jobTitle;
	
		
	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBadgeNumber() {
		return badgeNumber;
	}

	public void setBadgeNumber(int badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getJobTitleCode() {
		return jobTitleCode;
	}

	public void setJobTitleCode(int jobTitleCode) {
		this.jobTitleCode = jobTitleCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	
}

