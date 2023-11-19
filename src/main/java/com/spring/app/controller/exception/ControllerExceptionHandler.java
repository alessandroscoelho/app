package com.spring.app.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.spring.app.exception.ObjectNotFoundExcepetion;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundExcepetion.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundExcepetion e, HttpServletRequest request) {
		StandarError error = new StandarError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	
	}
}
