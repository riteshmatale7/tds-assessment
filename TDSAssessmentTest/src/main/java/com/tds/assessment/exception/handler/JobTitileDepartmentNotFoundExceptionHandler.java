package com.tds.assessment.exception.handler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tds.assessment.exception.BadgeNotFoundException;
import com.tds.assessment.exception.JobTitleDepartmentNotFoundException;
import com.tds.assessment.exception.JobTitleNotFoundException;
import com.tds.assessment.exception.TDSCustomException;

@ControllerAdvice
public class JobTitileDepartmentNotFoundExceptionHandler {

	@ExceptionHandler(value = {JobTitleDepartmentNotFoundException.class})
	public ResponseEntity<Object> handlerBadgeNotFoundEx(JobTitleDepartmentNotFoundException e){
		//payload containing exception details
		HttpStatus notFound = HttpStatus.UNPROCESSABLE_ENTITY;
		TDSCustomException customException = new TDSCustomException(e.getMessage(), notFound.value(), ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(customException, notFound);
	}
}
