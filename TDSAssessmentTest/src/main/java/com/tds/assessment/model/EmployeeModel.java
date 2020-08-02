package com.tds.assessment.model;

import java.util.Date;


public class EmployeeModel {

		private int id;

		private String firstname;

		private String lastname;	
		
		private int badge_number;

		private String country;

		private String job_title;
		
		private String department;
		
		private Date start_date;
		
		private Date leave_date;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public int getBadge_number() {
			return badge_number;
		}

		public void setBadge_number(int badge_number) {
			this.badge_number = badge_number;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getJob_title() {
			return job_title;
		}

		public void setJob_title(String job_title) {
			this.job_title = job_title;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public Date getStart_date() {
			return start_date;
		}

		public void setStart_date(Date start_date) {
			this.start_date = start_date;
		}

		public Date getLeave_date() {
			return leave_date;
		}

		public void setLeave_date(Date leave_date) {
			this.leave_date = leave_date;
		}

		
		
}
