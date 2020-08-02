package com.tds.assessment.exception.handler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tds.assessment.exception.BadgeNotFoundException;
import com.tds.assessment.exception.BadgeNumberFormatException;
import com.tds.assessment.exception.TDSCustomException;

@ControllerAdvice
public class BadgeNumberFormatExceptionHandler {	

	@ExceptionHandler(value = {BadgeNumberFormatException.class})
	public ResponseEntity<Object> handlerBadgeNumberFmtEx(BadgeNumberFormatException e){
		//payload containing exception details
		HttpStatus unprocessableEntity= HttpStatus.UNPROCESSABLE_ENTITY;
		TDSCustomException customException = new TDSCustomException(e.getMessage(), unprocessableEntity.value(), ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(customException, unprocessableEntity);
	}
}
