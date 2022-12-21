package edu.project.springboot.studentmanagement.controller;

import org.springframework.web.servlet.ModelAndView;
import edu.project.springboot.studentmanagement.model.Course;
import edu.project.springboot.studentmanagement.model.Department;
import edu.project.springboot.studentmanagement.model.Student;
import edu.project.springboot.studentmanagement.service.StudentService;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/index")
public class StudentController {

	@Autowired
	private StudentService studentService;


	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView getStudents(HttpSession session) {
		System.out.println("inside get method...");
		//session.setAttribute("message", "");
		session.setMaxInactiveInterval(10);
		//session.invalidate();
		ModelAndView model = new ModelAndView("viewStudent"); 
		
		model.addObject("students", studentService.listAllStudents());
		return model;
	}

	@RequestMapping(value="/getStudentForm", method=RequestMethod.GET)
	public ModelAndView getStudentPage() {
		ModelAndView model = new ModelAndView("studentForm");
		model.addObject("department", studentService.listAllDepartments());
		return model;
	}
	
	@RequestMapping(value="/getCourse/{id}", method=RequestMethod.GET)
	public List<Course> getCourse(@PathVariable String id) {
		List<Course> course = studentService.listAllCourses(id);
		return course;
	}
	
	@RequestMapping(value="/getStudentSearchForm", method=RequestMethod.GET)
	public ModelAndView getStudentSearchPage() {
		ModelAndView model = new ModelAndView("searchStudent");
		return model;
	}

	@RequestMapping(value="/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("student")Student student, HttpSession session){
		ModelAndView model = new ModelAndView("viewStudent");
		if(student != null){
			int status = studentService.saveStudent(student);
			if(status == 1) {
				session.setAttribute("message", "Student with Name: '" + student.getFirstName() + "' added Successfully.");
				session.setMaxInactiveInterval(10);
				//session.invalidate();
				model.addObject("message", "Student with Name: '" + student.getFirstName() + "' added Successfully.");
				model.addObject("students", studentService.listAllStudents());
			}else {
				return new ModelAndView("error");
			}
		}
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = "/{id}/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable("id") int studentId, HttpSession session) {
		int status = studentService.deleteStudent(studentId);
		ModelAndView model = new ModelAndView("viewStudent");
		if(status == 1) {
			session.setAttribute("message", "Student with ID: '" + studentId + "' deleted Successfully.");
			session.setMaxInactiveInterval(10);
			//session.invalidate();
			model.addObject("message", "Student with ID: '" + studentId + "' deleted Successfully.");
			model.addObject("students", studentService.listAllStudents());
		}else {
			return new ModelAndView("error");
		}
		return new ModelAndView("redirect:/index");
	}

	@RequestMapping(value = "/{id}/editStudent", method = RequestMethod.GET)
	public ModelAndView editStudent(@PathVariable("id") int studentId) {
		ModelAndView model = new ModelAndView("editStudent");
		try {
			Student student = studentService.getStudentById(studentId);
			ArrayList<Department> department = (ArrayList<Department>) studentService.listAllDepartments();
			List<Course> course = studentService.listAllCourses(student.getDepartmentName());
			model.addObject("student", student);
			model.addObject("department", department);
			model.addObject("courses", course);
		}catch(Exception e) {
			e.printStackTrace();	
		}
		
		return model;
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("student")Student student, HttpSession session) {
		ModelAndView model = new ModelAndView("viewStudent");
		int status = studentService.updateStudent(student);
		if(status == 1) {
			session.setAttribute("message", "Student with ID: '" + student.getStudent_id() + "' updated Successfully.");
			session.setMaxInactiveInterval(10);
			//session.invalidate();
			model.addObject("message", "Student with ID: '" + student.getStudent_id() + "' updated Successfully.");
			model.addObject("students", studentService.listAllStudents());
		}
		else {
			return new ModelAndView("error");
		}
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
	public ModelAndView searchStudent(@ModelAttribute("student")Student student) {
		ModelAndView model = new ModelAndView("searchStudent");
		model.addObject("student", studentService.getStudentById(student.getStudent_id()));
		return model;
	}
	

}
