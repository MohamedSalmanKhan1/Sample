package com.salman.RestAPIStudentProject.repository;

import javax.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.salman.RestAPIStudentProject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
