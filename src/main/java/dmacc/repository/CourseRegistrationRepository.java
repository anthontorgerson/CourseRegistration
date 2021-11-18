/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Nov 17, 2021
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Course;

@Repository
public interface CourseRegistrationRepository extends JpaRepository <Course, Long> {

}
