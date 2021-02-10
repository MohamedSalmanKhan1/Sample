package com.salman.RestAPIStudentProject.model;

public class Student {
	private long id;
	private String name;
	private int age;
	private double coursefees;
	
	public Student(){
		id=0;
	}
	public Student(long id, String name, int age, double coursefees){
		this.id = id;
		this.name = name;
		this.age = age;
		this.coursefees = coursefees;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getCourseFees() {
		return coursefees;
	}

	public void setCourseFees(double coursefees) {
		this.coursefees = coursefees;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", coursefees=" + coursefees + "]";
	}


}
