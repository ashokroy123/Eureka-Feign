package com.pack.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.Student;
import com.pack.exception.UserNotFoundException;
import com.pack.repository.CrudRepository;

@Service
public class StudentService {

	@Autowired
	CrudRepository repository;
	private Long id;
	private Long studentId;
	
	public Student addStudent(Student student) {
		
		return repository.save(student);
	}
	
	public List<Student> getAllStudents() {
		return repository.findAll();
		
	}
	
	
	
	  public List<Student> getAllStudents(Sort sort) { return
	  repository.findAll(sort);
	  
	  }
	 
	 
	
	public Student updateStudent(Student student) {
		return repository.save(student);
	}
	
	public   void deleteStudent(Long id) {
	 
		 repository.deleteById(id);
		
	}
	
	public Student getStudentById(Long id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException("user "+id+"is not found"));
		
	}
	
	
	  public Page<Student> findAll(Pageable paging){ return
	  repository.findAll(paging); }
	 
	
	
	
	  public List<Student> getAllStudentsByStudentIdGreaterthan(Long id) { return
	  repository.findByIdGreaterThan(id);
	  
	  }
	  
	  public List<Student> findByTop2StudentNames(){
		  return repository.findTop2ByOrderByStudentName();
		 
	  }
	  
	  public List<Student> findByTop2StudentNamesDesc(){
		  return repository.findTop2ByOrderByStudentNameDesc();
		 
	  }

	public Student getUsersByFirstNameLike(String studentName) {
		
		return repository.findByStudentNameLike(studentName);
	}

	public Student getStudentByEmail(String email) {
	
		return repository.findByEmail(email);
	}

	
	  
	
	
}
