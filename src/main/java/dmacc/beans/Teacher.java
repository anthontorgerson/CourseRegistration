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
	private int id;
	
	public Teacher() {
		// spaceholder
	}

	public Teacher(String lastName, String email, int id) {
		// spaceholder
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
