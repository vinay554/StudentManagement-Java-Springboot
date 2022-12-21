package edu.project.springboot.studentmanagement.model;

import java.sql.Date;

public class Student {

	private int student_id;
	private String firstName;
	private String LastName;
	private Date dob;
	private String program;
	private String departmentName;
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", firstName=" + firstName + ", LastName=" + LastName + ", dob="
				+ dob + ", program=" + program + ", departmentName=" + departmentName + "]";
	}
	
	
	
	
	
	
	
}
