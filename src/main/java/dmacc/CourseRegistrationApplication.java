package dmacc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.Course;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.CourseRegistrationRepository;

@SpringBootApplication
public class CourseRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseRegistrationApplication.class, args);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
		Course c = appContext.getBean("course", Course.class);
		
		System.out.println(c.toString());
	
	}
	

}
