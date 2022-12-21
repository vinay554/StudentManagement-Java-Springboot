package edu.project.springboot.studentmanagement.dao;

import java.util.List;

import edu.project.springboot.studentmanagement.model.Course;
import edu.project.springboot.studentmanagement.model.Department;
import edu.project.springboot.studentmanagement.model.Student;


public interface StudentDaoInterface {

	public List<Student> listAllStudents();

	public Student getStudentById(int studentId);

	public int saveStudent(Student student);

	public int deleteStudent(int studentId);
	
	public int updateStudent(Student student);
	
	public List<Department> listAllDepartments();
	
	public List<Course> listAllCourses(String id);
}
