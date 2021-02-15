package com.salman.RestAPIStudentProject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.salman.RestAPIStudentProject.exception.StudentExceptionHandler;
import com.salman.RestAPIStudentProject.model.Student;
import com.salman.RestAPIStudentProject.service.StudentService;

@RestController
@RequestMapping("/api")

public class StudentController {
	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/student/", method = RequestMethod.GET)
	public ResponseEntity<?> listAllStudents() {
		List<Student> student = studentService.findAllStudents();
		if (student.isEmpty()) {
			// return new ResponseEntity(HttpStatus.NO_CONTENT);
			throw new StudentExceptionHandler("Their is no Student entries");

		}
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getStudent(@PathVariable("id") long id) {
		logger.info("Fetching Student with id {}", id);
		Student student = studentService.findById(id);
		if (student == null) {
			logger.error("Student with id {} not found.", id);
			throw new StudentExceptionHandler("Their is no Student with this id:" + id);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/", method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Student : {}", student);
		studentService.saveStudent(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/student/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		logger.info("Updating Student with id {}", id);

		Student currentStudent = studentService.findById(id);

		if (currentStudent == null) {
			logger.error("Unable to update. Employee with id {} not found.", id);
			throw new StudentExceptionHandler("Unable to update, Their is no Student with id " + id);
		}

		currentStudent.setName(student.getName());
		currentStudent.setAge(student.getAge());
		currentStudent.setCourseFees(student.getCourseFees());

		studentService.updateStudent(currentStudent);
		return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudent(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Student with id {}", id);

		Student student = studentService.findById(id);
		if (student == null) {
			logger.error("Unable to delete. Student with id {} not found.", id);
			throw new StudentExceptionHandler("Unable to Delete, Their is no Student with this id " + id);
		}
		studentService.deleteStudentById(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/student/", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteAllStudent() {
		logger.info("Deleting All Students");

		studentService.deleteAllStudents();
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

}