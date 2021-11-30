/**
 * @author Becca Deuser - rddeuser
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
package dmacc.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	//Error Could not determine type for: java.util.List, at table: student, for columns: [org.hibernate.mapping.Column(courses)]
	//private List<Course> courses;
	
	public Student(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}//end 3 arg constructor
	
	
}//end Student
