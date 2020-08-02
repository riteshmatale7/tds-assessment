package com.tds.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tds.assessment.entity.Badge;

public interface BadgeRepository extends JpaRepository<Badge, Integer> {

	
	@Query("SELECT B FROM Badge B WHERE LOWER(B.badgeStatus) = LOWER('Active') AND B.badgeExpiryDate >= SYSDATE")
	public List<Badge> findActiveBadges();

	
}
