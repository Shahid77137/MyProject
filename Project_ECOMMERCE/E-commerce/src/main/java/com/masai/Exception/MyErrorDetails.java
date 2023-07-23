package com.masai.Exception;

import java.time.LocalDateTime;

public class MyErrorDetails {

	private LocalDateTime Timestamp;
	private String message;
	private String description;
	
	public MyErrorDetails() {};
	
	public MyErrorDetails(LocalDateTime timestamp, String message, String description) {
		super();
		Timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	public LocalDateTime getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		Timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
