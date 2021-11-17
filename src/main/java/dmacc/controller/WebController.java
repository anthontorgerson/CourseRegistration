/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Nov 17, 2021
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dmacc.repository.CourseRegistrationRepository;

@Controller
public class WebController {
	@Autowired
	CourseRegistrationRepository repo;
	

}
