package com.salman.RestAPIStudentProject.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salman.RestAPIStudentProject.model.Student;
import com.salman.RestAPIStudentProject.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private static final AtomicLong counter = new AtomicLong();
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public List<Student> findAllStudents() {
		return (List<Student>) studentrepository.findAll();

	}

	@Override
	public Student findById(long id) {

		return studentrepository.findOne(id);

	}

	@Override
	public void saveStudent(Student Student) {
		Student.setId(counter.incrementAndGet());
		studentrepository.save(Student);
	}

	@Override
	public void updateStudent(Student Student) {

		studentrepository.save(Student);
	}

	@Override
	public void deleteStudentById(long id) {

		studentrepository.delete(findById(id));
	}

	@Override
	public void deleteAllStudents() {
		studentrepository.deleteAll();
	}

}
