package com.tds.assessment.mapper;

import com.tds.assessment.entity.Badge;
import com.tds.assessment.model.BadgeModel;

public class BadgeMapper {
	public static BadgeModel mapBadgeObj(Badge badge) {
		BadgeModel badgeModel = new BadgeModel();
		badgeModel.setBadge_number(badge.getBadgeNumber());
		badgeModel.setBadge_status(badge.getBadgeStatus());
		badgeModel.setBadge_expiry_date(badge.getBadgeExpiryDate());
		return badgeModel;
	}

}
