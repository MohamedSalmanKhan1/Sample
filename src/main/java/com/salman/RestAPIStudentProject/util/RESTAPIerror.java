package com.salman.RestAPIStudentProject.util;

public class RESTAPIerror {
	
	private String errorMessage;

    public RESTAPIerror(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
