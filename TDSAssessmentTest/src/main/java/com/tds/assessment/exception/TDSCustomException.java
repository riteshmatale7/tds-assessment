package com.tds.assessment.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class TDSCustomException {
	private final String message;
	private final int status;
	private final ZonedDateTime timestamp;
	public TDSCustomException(String message, int status, ZonedDateTime timestamp) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}
	public int getStatus() {
		return status;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
}
