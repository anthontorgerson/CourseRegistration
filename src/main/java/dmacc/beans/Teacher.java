/**
 * @author AnthonT - atorgerson
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Teacher {
	private String lastName;
	private String email;
	//private int teacherID; // changed from id, was causing duplication errors with course.id
	
	public Teacher() {
		super();
	}

	public Teacher(String lastName, String email) {
		super();
		this.lastName = lastName;
		this.email = email;
		//this.teacherID = teacherID;
	}

	// getters and setters
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
/*
	public int getteacherID() {
		return teacherID;
	}

	public void setteacherID(int teacherID) {
		this.teacherID = teacherID;
	}
*/
	@Override
	public String toString() {
		return "Teacher [lastName=" + lastName + ", email=" + email + "]";
	}
}
