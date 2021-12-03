/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Nov 17, 2021
 * 
 * @author becca deuser
 * Edited to add students enrolled
 * Dec 2, 2021
 */
package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String courseId;
	private String courseName;
	@Autowired
	private Teacher teacher;
	private int studentsEnrolled;
	//private final int COURSEMAX = 15;
	//private final int COURSEMIN = 5;
	//private int courseApplied;
	
	
	public Course() {
		super();
	}
	
	public Course(String courseID) {
		super();
		this.courseId = courseID;
	}

	public Course(String courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}


	public Course(long id, String courseId, String courseName) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
	}


	public Course(String courseId, String courseName, Teacher teacher, int studentsEnrolled) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacher = teacher;
		this.studentsEnrolled = studentsEnrolled;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public int getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(int studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}
	
	public void addStudent() {
		this.studentsEnrolled++;
	}
	
	public void removeStudent() {
		this.studentsEnrolled--;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseId=" + courseId + ", courseName=" + courseName + ", teacher=" + teacher
				+ "]";
	}
	
	
	
	
	
	

}
