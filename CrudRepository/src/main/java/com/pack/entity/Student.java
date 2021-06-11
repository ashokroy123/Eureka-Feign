package com.pack.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@NotNull
	@Size(min=2,max=30)
	private String studentName;
	
	@Column
	private String city;
	
	@Column
	@Email
	private String email;
	
	
	public Student() {
		super();
		
	}


	public Student(Long id, @Size(min = 2, max = 30) String studentName, String city, @Email String email) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.city = city;
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", city=" + city + ", email=" + email + "]";
	}


	



	
	
}
