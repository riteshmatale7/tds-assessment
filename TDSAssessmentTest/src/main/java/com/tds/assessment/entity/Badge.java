package com.tds.assessment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Badge")
public class Badge {
	
	@Id
	@Column(name = "Badge_Number")
	private int badgeNumber;

	@Column(name = "Badge_Status")
	private String badgeStatus;
	
	@Column(name = "Badge_Expiry_Date")
	private Date badgeExpiryDate;

	public int getBadgeNumber() {
		return badgeNumber;
	}

	public void setBadgeNumber(int badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public String getBadgeStatus() {
		return badgeStatus;
	}

	public void setBadgeStatus(String badgeStatus) {
		this.badgeStatus = badgeStatus;
	}

	public Date getBadgeExpiryDate() {
		return badgeExpiryDate;
	}

	public void setBadgeExpiryDate(Date badgeExpiryDate) {
		this.badgeExpiryDate = badgeExpiryDate;
	}
	
	
}
