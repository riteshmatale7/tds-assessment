package com.tds.assessment.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.Badge;
import com.tds.assessment.model.BadgeModel;
import com.tds.assessment.service.BadgeService;

@RestController
public class BadgeController {

	@Autowired
	private BadgeService badgeService;
	
	@RequestMapping("/badges/active")
	public ResponseEntity<List<BadgeModel>> findActiveBadges(){
		return ResponseEntity.status(HttpStatus.OK).body(badgeService.getActiveBadges());			
	}
	
	@RequestMapping(value = { "/badges" } )
	public ResponseEntity<List<BadgeModel>> findBatchByBadgeNumber(@RequestParam("badge_number") Optional<String> badgeNumber) {	
		if(badgeNumber.isPresent()) {
			//get specified badge with badge number
			System.out.println("aaaa : " + badgeNumber);
			List<BadgeModel> badgeList = badgeService.getBadgeByBadgehNumber(badgeNumber.get());
			return ResponseEntity.status(HttpStatus.OK).body(badgeList);			
		}else {
			//get all batches
			return ResponseEntity.status(HttpStatus.OK).body(badgeService.getBadges());
		}
		
	}
	
	
}
