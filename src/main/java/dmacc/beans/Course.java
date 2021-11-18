/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Nov 17, 2021
 */
package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String courseId;
	private String courseName;
	private String teacher;
	private final int COURSEMAX = 15;
	private final int COURSEMIN = 5;
	private int courseApplied;

}
