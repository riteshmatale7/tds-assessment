package com.tds.assessment.model;

import java.util.Date;

public class BadgeModel {

	private int badge_number;
	
	private String badge_status;
	
	private Date  badge_expiry_date;

	public int getBadge_number() {
		return badge_number;
	}

	public void setBadge_number(int badge_number) {
		this.badge_number = badge_number;
	}

	public String getBadge_status() {
		return badge_status;
	}

	public void setBadge_status(String badge_status) {
		this.badge_status = badge_status;
	}

	public Date getBadge_expiry_date() {
		return badge_expiry_date;
	}

	public void setBadge_expiry_date(Date badge_expiry_date) {
		this.badge_expiry_date = badge_expiry_date;
	}
	
	
	
	
}
