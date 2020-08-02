package com.tds.assessment.exception.handler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tds.assessment.exception.BadgeNotFoundException;
import com.tds.assessment.exception.JobTitleNotFoundException;
import com.tds.assessment.exception.TDSCustomException;

@ControllerAdvice
public class JobTitileNotFoundExceptionHandler {

	@ExceptionHandler(value = {JobTitleNotFoundException.class})
	public ResponseEntity<Object> handlerBadgeNotFoundEx(JobTitleNotFoundException e){
		//payload containing exception details
		HttpStatus notFound = HttpStatus.NOT_FOUND;
		TDSCustomException customException = new TDSCustomException(e.getMessage(), notFound.value(), ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(customException, notFound);
	}
}
