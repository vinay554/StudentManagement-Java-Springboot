package edu.project.springboot.studentmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.project.springboot.studentmanagement.dao.StudentDao;
import edu.project.springboot.studentmanagement.model.Course;
import edu.project.springboot.studentmanagement.model.Department;
import edu.project.springboot.studentmanagement.model.Student;


@Service
public class StudentService implements StudentServiceInterface{

	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> listAllStudents() {
		return studentDao.listAllStudents();
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public int saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	@Override
	public int deleteStudent(int studentId) {
		return studentDao.deleteStudent(studentId);
	}

	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public List<Department> listAllDepartments() {
		return studentDao.listAllDepartments();
	}

	@Override
	public List<Course> listAllCourses(String id) {
		// TODO Auto-generated method stub
		return studentDao.listAllCourses(id);
	}
}
