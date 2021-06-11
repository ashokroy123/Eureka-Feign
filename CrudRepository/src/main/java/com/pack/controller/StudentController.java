package com.pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Student;
import com.pack.exception.DuplicateEntryException;
import com.pack.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/allStudents")
	public List<Student> getAllStudents(@RequestBody Student student) {

		return service.getAllStudents();
	}

	@PostMapping("/addStudent")
	public Student addStudent(@Valid @RequestBody Student student) throws DuplicateEntryException {
		if (getStudentByEmail(student.getEmail()) != null) {
			throw new DuplicateEntryException("Student already registered");
		} else {

			return service.addStudent(student);
		}
	}

	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {

		service.deleteStudent(id);
	}

	@GetMapping("/find/{id}")
	public Student getStudentById(@PathVariable("id") Long id) {
		return service.getStudentById(id);
	}

	@GetMapping("/all/page/size")
	public ResponseEntity<Map<String, Object>> getAllUsersByPagination(@RequestParam(defaultValue = "1") int page,

			@RequestParam(defaultValue = "3") int size) {

		try {
			List<Student> tutorials = new ArrayList<Student>();
			Pageable paging = PageRequest.of(page, size);

			Page<Student> pageTuts;

			pageTuts = service.findAll(paging);
			tutorials = pageTuts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("students", tutorials);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalpages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/all/sort")
	public List<Student> getAllStudentsBySort() {
		return service.getAllStudents(Sort.by("city"));

	}

	@GetMapping("/all/id/greaterthan/{id}")
	public List<Student> getAllStudentsIdgreaterThan(@PathVariable long id) {
		return service.getAllStudentsByStudentIdGreaterthan(id);
	}

	@GetMapping("/top2")
	public List<Student> getTop2StudentNames(@RequestBody Student student) {
		return service.findByTop2StudentNames();

	}

	@GetMapping("/top2/desc")
	public List<Student> getTop2StudentNamesDesc(@RequestBody Student student) {
		return service.findByTop2StudentNamesDesc();

	}

	@GetMapping("userbyfnamelike/like")
	public Student getUsersByFirstNameLike(@RequestParam String like) {
		return service.getUsersByFirstNameLike("%" + like + "%");
	}

	@GetMapping("/email")
	public Student getStudentByEmail(String email) {
		return service.getStudentByEmail(email);
	}

}
