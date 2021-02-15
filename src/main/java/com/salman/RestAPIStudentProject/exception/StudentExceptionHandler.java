package com.salman.RestAPIStudentProject.exception;

public class StudentExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public StudentExceptionHandler(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
