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
import org.springframework.web.bind.annotation.PathVariable;

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
	}//end deleteUser
}
