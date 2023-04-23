package com.ketan.page.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyError {
	
	private String message;
	private String description;
	private LocalDateTime dateTime;
	
}
