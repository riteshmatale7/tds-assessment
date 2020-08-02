package com.tds.assessment.exception;

public class DepartmentNotFoundException extends RuntimeException{

	public DepartmentNotFoundException(String message) {
		super(message);
	}
}
