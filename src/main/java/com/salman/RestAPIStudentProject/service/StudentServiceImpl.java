package com.salman.RestAPIStudentProject.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.salman.RestAPIStudentProject.model.Student;

@Service("studentService")

public class StudentServiceImpl implements StudentService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Student> students;
	
	static{
		students = populateDummyStudents();
	}

	public List<Student> findAllStudents() {
		return students;
	}
	
	public Student findById(long id) {
		for(Student student : students){
			if(student.getId() == id){
				return student;
			}
		}
		return null;
	}
	
	public Student findByName(String name) {
		for(Student Student : students){
			if(Student.getName().equalsIgnoreCase(name)){
				return Student;
			}
		}
		return null;
	}
	
	public void saveStudent(Student Student) {
		Student.setId(counter.incrementAndGet());
		students.add(Student);
	}

	public void updateStudent(Student Student) {
		int index = students.indexOf(Student);
		students.set(index, Student);
	}

	public void deleteStudentById(long id) {
		
		for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ) {
		    Student student = iterator.next();
		    if (student.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isStudentExist(Student student) {
		return findByName(student.getName())!=null;
	}
	
	public void deleteAllStudents(){
		students.clear();
	}

	private static List<Student> populateDummyStudents(){
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(counter.incrementAndGet(),"David",30, 70000));
		students.add(new Student(counter.incrementAndGet(),"John",40, 50000));
		students.add(new Student(counter.incrementAndGet(),"Kani",45, 30000));
		students.add(new Student(counter.incrementAndGet(),"Todd",50, 40000));
		return students;
	}
	
}
