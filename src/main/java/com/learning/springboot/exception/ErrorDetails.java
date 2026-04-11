package com.learning.springboot.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime currentDateAndTime;
	private String errorMessage;
	private String description;

	public ErrorDetails(LocalDateTime currentDateAndTime, String errorMessage, String description) {
		this.currentDateAndTime = currentDateAndTime;
		this.errorMessage = errorMessage;
		this.description = description;
	}

	public LocalDateTime getCurrentDateAndTime() {
		return currentDateAndTime;
	}

	public void setCurrentDateAndTime(LocalDateTime currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
