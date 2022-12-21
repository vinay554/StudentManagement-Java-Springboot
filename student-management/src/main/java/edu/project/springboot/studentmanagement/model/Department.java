package edu.project.springboot.studentmanagement.model;

public class Department {

	private String departmentID;
	private String departmentName;
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName
				+ ", getDepartmentID()=" + getDepartmentID() + ", getDepartmentName()=" + getDepartmentName()
				+ "]";
	}
	
	
}
