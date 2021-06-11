package com.pack.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Employee;
import com.pack.entity.Student;
import com.pack.feign.client.CrudInterface;
import com.pack.feign.client.EmployeeInterface;

@RestController
@RequestMapping("/parent")
public class ParentController {

	@Autowired
	EmployeeInterface employeeInterface;
	
	@Autowired
	CrudInterface crudInterface;
	
	
	  @GetMapping("/all") 
	  public ResponseEntity<List<Employee>> getAllEmployees (){
	  return employeeInterface.getAllEmployees();
	  
	  }
	 

	
	@PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return employeeInterface.addEmployee(employee);
		
	}
	
	 @PutMapping("/update")
	    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		 return employeeInterface.updateEmployee(employee);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		 return employeeInterface.deleteEmployee(id);
	 }
	 
	 @GetMapping("/allStudents")
		public List<Student> getAllStudents(@RequestBody Student student){
		 return  crudInterface.getAllStudents(student);
	 }
	 
	 @PutMapping("/updateStudent")
		public Student updateStudent(@RequestBody Student student) {
			return crudInterface.updateStudent(student);
	
	 }
	 
	 @PostMapping("/addStudent")
		public Student addStudent(@Valid @RequestBody Student student) {
		 return crudInterface.addStudent(student);
	 }
	 
	
	 @GetMapping("/find/{id}")
		public Student getStudentById(@PathVariable("id") Long id) {
		 return crudInterface.getStudentById(id);
	 }
}
