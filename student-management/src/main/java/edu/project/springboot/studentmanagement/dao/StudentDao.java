package edu.project.springboot.studentmanagement.dao;

import java.sql.Date;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import edu.project.springboot.studentmanagement.model.Course;
import edu.project.springboot.studentmanagement.model.Department;
import edu.project.springboot.studentmanagement.model.Student;


@Repository
public class StudentDao implements StudentDaoInterface{

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public List<Student> listAllStudents() {
		String sql = "SELECT * FROM STUDENT";
		List<Student> students = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<?, ?> row : rows) {
			Student obj = new Student();

			obj.setStudent_id((int) ((row.get("student_id"))));
			obj.setFirstName((String) row.get("first_name"));
			obj.setLastName((String) row.get("last_name")); 
			obj.setProgram((String) row.get("program"));
			obj.setDob((Date) row.get("dob"));
			obj.setDepartmentName((String) row.get("department_name"));
			students.add(obj);
		}
		return students;
	}
	
	@Override
	public List<Course> listAllCourses(String id) {
		String sql = "SELECT * FROM course where department_name = ?";
		List<Course> courses = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,id);
		for (Map<?, ?> row : rows) {
			Course obj = new Course();
			obj.setDepartmentName((String) ((row.get("department_name"))));
			obj.setCourse((String) row.get("course"));
			courses.add(obj);
		}
		return courses;
	}

	@Override
	public Student getStudentById(int studentId) {
		Student queryForObject = jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE student_id= ?", new BeanPropertyRowMapper<Student>(Student.class), studentId);
		return queryForObject;
	} 

	@Override
	public int saveStudent(Student student) {
		//String[] department_id = student.getDepartment_name();
		int status = jdbcTemplate.update(
				"insert into student (first_name, last_name, DOB, program, department_name) values(?,?,?,?,?)",
				student.getFirstName(),student.getLastName(),student.getDob(),student.getProgram(),student.getDepartmentName()
				);
		return status;
	}

	@Override
	public int deleteStudent(int studentId) {
		return jdbcTemplate.update("DELETE FROM student WHERE student_id=?", studentId);
	}

	@Override
	public int updateStudent(Student student) {
		return jdbcTemplate.update("UPDATE student SET first_name = ?, last_name = ?, dob = ?, program = ?, department_name = ? WHERE student_id = ?", new Object[] 
				{student.getFirstName(), student.getLastName(), student.getDob(), student.getProgram(), student.getDepartmentName(), student.getStudent_id()});

	}

	@Override
	public List<Department> listAllDepartments() {
		String sql = "SELECT * FROM department";
		List<Department> department = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<?, ?> row : rows) {
			Department obj = new Department();
			obj.setDepartmentID((String) ((row.get("department_id"))));
			obj.setDepartmentName((String) row.get("department_name"));
			department.add(obj);
		}
		return department;
		
	
	}

}
