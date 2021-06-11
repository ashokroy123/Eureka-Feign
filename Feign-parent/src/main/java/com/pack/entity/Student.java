package com.pack.entity;


public class Student {

	
	private Long id;
	private String studentName;
	private String city;
	private String email;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Long id, String studentName, String city, String email) {
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
