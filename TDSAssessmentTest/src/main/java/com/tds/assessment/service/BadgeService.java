package com.tds.assessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.Badge;

import com.tds.assessment.exception.BadgeNotFoundException;
import com.tds.assessment.exception.BadgeNumberFormatException;
import com.tds.assessment.mapper.BadgeMapper;
import com.tds.assessment.model.BadgeModel;
import com.tds.assessment.repository.BadgeRepository;

@Service
public class BadgeService {

	@Autowired
	private BadgeRepository badgeRepo;
	
	//mapping of badge obj to badgemodel obj
	private List<BadgeModel> mapBadgeModelList(List<Badge> activeBadgesList){
		ArrayList<BadgeModel> badgeModelList = new ArrayList<BadgeModel>();		
		for (Badge badge : activeBadgesList) {
			BadgeModel badgeModel = BadgeMapper.mapBadgeObj(badge);
			badgeModelList.add(badgeModel);
		}						
		return badgeModelList;			
	}
	
	//get all badges
	public List<BadgeModel> getBadges(){
		List<Badge> badgesList = badgeRepo.findAll();	
		if(badgesList != null &&  badgesList.size() > 0) {
			List<BadgeModel> badgeModels = mapBadgeModelList(badgesList);
			return badgeModels;
		}else {
			//404 status code --not present code
			throw new BadgeNotFoundException("No Badges present in System");
		}

	}
	
	//method that returns activebadges
	public List<BadgeModel> getActiveBadges(){
		List<Badge> activeBadgesList = null;		
		List<BadgeModel> badgeModelList = null;
		activeBadgesList = badgeRepo.findActiveBadges();							
		if(activeBadgesList != null && activeBadgesList.size() > 0) {

			//mapping of badge obj to badgemodel obj
			badgeModelList = mapBadgeModelList(activeBadgesList);
			return badgeModelList;			
		}
		else {
			//404 status code --not present code
			throw new BadgeNotFoundException("No Badges are active");
		}
	}

	public List<BadgeModel> getBadgeByBadgehNumber(String badgeNumber){		
		try{ 
			  
			int badgeNumberParsed = Integer.parseInt(badgeNumber);	 		  
 
			//finding badge by batchnumber
			Optional<Badge> optionalBadge = badgeRepo.findById(badgeNumberParsed );
			Badge badge = null;
			//checking data present in optional or not
			if(optionalBadge.isPresent()) {
				//getting data from optionalBadge to badge entity
				badge = optionalBadge.get();
				List<Badge> badgesList = new ArrayList<Badge>();
				badgesList.add(badge);				
				List<BadgeModel> badgeModels = mapBadgeModelList(badgesList);
				return badgeModels;
							
			}else {
				//404 status code --not present code
				throw new BadgeNotFoundException("Entered Batch number : " + badgeNumber + " is not present");
			}
		}catch (NumberFormatException e) {
			throw new BadgeNumberFormatException("Badge number should be numeric");
		}
	
	}
}
