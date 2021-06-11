package com.pack.feign.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pack.entity.Student;

@FeignClient(url="http://localhost:8083/student",name="CrudRepository")
public interface CrudInterface {

	@GetMapping("/allStudents")
	public List<Student> getAllStudents(@RequestBody Student student);
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student);
	
	@PostMapping("/addStudent")
	public Student addStudent(@Valid @RequestBody Student student);
	
	

	@GetMapping("/find/{id}")
	public Student getStudentById(@PathVariable("id") Long id);
	
	
}
