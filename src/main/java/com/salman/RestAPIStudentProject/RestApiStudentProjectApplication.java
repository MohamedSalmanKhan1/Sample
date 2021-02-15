package com.salman.RestAPIStudentProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.salman.restapistudentproject" })
public class RestApiStudentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiStudentProjectApplication.class, args);
	}

}
