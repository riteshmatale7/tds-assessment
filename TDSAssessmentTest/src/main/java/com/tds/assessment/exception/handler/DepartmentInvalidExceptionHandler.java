package com.tds.assessment.exception.handler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tds.assessment.exception.CountryRestCallException;
import com.tds.assessment.exception.DepartmentInvalidException;
import com.tds.assessment.exception.TDSCustomException;

@ControllerAdvice
public class DepartmentInvalidExceptionHandler {

	
	@ExceptionHandler(value = {DepartmentInvalidException.class})
	public ResponseEntity<Object> handlerDeptInvalidException(DepartmentInvalidException e){
		//payload containing exception details
		HttpStatus notFound = HttpStatus.UNPROCESSABLE_ENTITY;
		TDSCustomException customException = new TDSCustomException(e.getMessage(), notFound.value(), ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(customException, notFound);
	}
}

