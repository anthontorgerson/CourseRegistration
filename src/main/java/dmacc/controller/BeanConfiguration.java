package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Course;
import dmacc.beans.Teacher;

/**
 * @author Nick - ntambroson
 * CIS175 - Fall 2021
 * Nov 19, 2021
 */

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Course course() {
		Course bean = new Course();
		return bean;
	}
	
	@Bean
	public Teacher teacher() {
		Teacher bean = new Teacher();
		return bean;
	}

}
