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

import dmacc.beans.Contact;
import dmacc.beans.Course;
import dmacc.repository.CourseRegistrationRepository;

@Controller
public class WebController {
	@Autowired
	CourseRegistrationRepository repo;
	
	//delete function
	@GetMapping("/delete/{id}")
	
	public String deleteCourse(@PathVariable("id") long id, Model model) {
		Course c = repo.findById(id).orElse(null);
		repo.delete(c);
		//TODO: viewAllCourses method will need to be created
		return viewAllCourses(model);
	}//end deleteCourse
	
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
		//TODO: viewAllCourses method will need to be created
		return viewAllContacts(model);
	}//end addNewCourse
	
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
	
}//end WebController
