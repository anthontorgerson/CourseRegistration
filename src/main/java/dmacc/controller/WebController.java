/**
 * @author alexanderpontier - ampontier1
 * @author becca deuser
 * CIS175 - Spring 2021
 * Nov 17, 2021
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Course;
import dmacc.beans.Student;
import dmacc.repository.CourseRegistrationRepository;

@Controller
public class WebController {
	@Autowired
	CourseRegistrationRepository repo;
	
	@GetMapping({"/", "loginpage"})
	public String loginpage(Model model) {
		model.addAttribute("courses", repo.findAll());
		return "loginpage";
	}
	
	@GetMapping({"/adminCourseView"})
	public String viewAllCourses(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewCourse(model);
		}
		model.addAttribute("courses", repo.findAll());
		return "adminCourseView";
	}
	
	@GetMapping({"/teacherCourseView"})
	public String teacherViewCourses(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewCourse(model);
		}
		model.addAttribute("courses", repo.findAll());
		return "teacherCourseView";
	}
	
	@GetMapping({"/teacherManageRosterView"})
	public String manageRosterTeacher(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewCourse(model);
		}
		model.addAttribute("courses", repo.findAll());
		return "teacherManageRosterView";
	}
	
	@GetMapping({"/studentCourseView"})
	public String studentViewCourses(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewCourse(model);
		}
		model.addAttribute("courses", repo.findAll());
		return "studentCourseView";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateCourse(@PathVariable("id") long id, Model model) {
		Course c = repo.findById(id).orElse(null);
		model.addAttribute("newCourse", c);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseContact(Course c, Model model) {
		repo.save(c);
		return viewAllCourses(model);
	}
	//delete function
	@GetMapping("/delete/{id}")
	
	public String deleteCourse(@PathVariable("id") long id, Model model) {
		Course c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllCourses(model);
	}//end deleteCourse
	
	//add student function
	@GetMapping("/add/{id}")
	public String addStudent(@PathVariable("id") long id, Model model) {
		Course c = repo.findById(id).orElse(null);
		c.addStudent();
		repo.save(c);
		return viewAllCourses(model);
	}//end of addStudent
	
	//remove students function
	@GetMapping("/remove/{id}")
		
	public String removeStudent(@PathVariable("id") long id, Model model) {
		Course c = repo.findById(id).orElse(null);
		c.removeStudent();
		repo.save(c);
		return viewAllCourses(model);
	}//end removeStudent
	
	//add course get mapping method
	@GetMapping("/inputCourse")
	
	public String addNewCourse(Model model) {
		Course course = new Course();
		model.addAttribute("newCourse", course);
		//TODO: change path as needed
		return "input";
	}//end addNewContact
	
	//add course post mapping method
	@PostMapping("/inputCourse")
	
	public String addNewCourse(@ModelAttribute Course c, Model model) {
		repo.save(c);
		return viewAllCourses(model);
	}//end addNewCourse
	
	// add student to course method
	@GetMapping("/inputStudentToCourse")
	public String addStudentToCourse(Model model) {
		Student s = new Student();
		Course c = new Course();
		model.addAttribute("newStudent", s);
		model.addAttribute("newCourse", c);
		return "input";
	}
	
	@PostMapping("/inputStudentToCourse")
	public String addStudentToCourse(@ModelAttribute Student s, Course c, Model model) {
		//TODO: This receives an error repo.save(s);
		repo.save(c);
		return viewAllCourses(model);
	}
	
	/*
	//add duplicate method
	@GetMapping("/inputCourse")
	public String addDuplicateCourse(@PathVariable("id") long id, Model model) {
		Course c = new Course();
		Course toBeCopied = repo.findById(id).orElse(null);
		c.setCourseId(toBeCopied.getCourseId());
		c.setCourseName(toBeCopied.getCourseName());
		c.setTeacher(toBeCopied.getTeacher());
		return "input";
		
	}
	*/
	
}//end WebController
