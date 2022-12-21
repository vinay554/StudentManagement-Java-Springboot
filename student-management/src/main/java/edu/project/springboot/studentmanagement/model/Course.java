package edu.project.springboot.studentmanagement.model;

public class Course {

	private String departmentName;
	private String course;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Course [departmentName=" + departmentName + ", course=" + course + "]";
	}
	
	
}
