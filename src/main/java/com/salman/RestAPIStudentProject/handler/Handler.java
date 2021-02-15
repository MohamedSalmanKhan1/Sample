package com.salman.RestAPIStudentProject.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.salman.RestAPIStudentProject.exception.StudentExceptionHandler;

@RestControllerAdvice
public class Handler {
	@ExceptionHandler
	public String handleInvalidException(StudentExceptionHandler exception) {
		return exception.getMessage();
	}

}
