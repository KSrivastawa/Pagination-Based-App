package com.ketan.page.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> getUserExceptionHandler(UserException exception, WebRequest request){
		
		MyError error = new MyError();
		error.setDateTime(LocalDateTime.now());
		error.setMessage(exception.getMessage());
		error.setDescription(request.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyError> getProductExceptionHandler(ProductException exception, WebRequest request){
		
		MyError error = new MyError();
		error.setDateTime(LocalDateTime.now());
		error.setMessage(exception.getMessage());
		error.setDescription(request.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> getExceptionHandler(Exception exception, WebRequest request){
		
		MyError error = new MyError();
		error.setDateTime(LocalDateTime.now());
		error.setMessage(exception.getMessage());
		error.setDescription(request.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);		
	}
	
}
