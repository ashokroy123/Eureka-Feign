package com.pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.Student;

public interface CrudRepository extends JpaRepository<Student,Long> {

	List<Student> findByIdGreaterThan(Long id);
	
	List<Student> findTop2ByOrderByStudentName();

	List<Student> findTop2ByOrderByStudentNameDesc();
	
	Student findByStudentNameLike(String studentName);

	Student findByEmail(String email);
	
}
