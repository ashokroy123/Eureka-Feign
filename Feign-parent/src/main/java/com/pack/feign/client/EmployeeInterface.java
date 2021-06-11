package com.pack.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pack.entity.Employee;

@FeignClient(url = "http://localhost:8072/employee", name = "Employeemanagement")
public interface EmployeeInterface {

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees();

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee);

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee);

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id);

}
