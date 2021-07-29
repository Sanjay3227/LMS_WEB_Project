package com.sanjay;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CoursesRepoTests {
	
	@Autowired
	private CoursesRepo crepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateCourses() {
		Courses courses = new Courses();
	    courses.setName("Java Basics");
	    courses.setContent("https://www.youtube.com/watch?v=eIrMbAQSU34");
	    courses.setDescription("All Basics of Java");
	    courses.setFee(299);
	    Courses savedCourse = crepo.save(courses); 
	    Courses existcourse = entityManager.find(Courses.class, savedCourse.getId());
	     
	    assertThat(courses.getName()).isEqualTo(existcourse.getName());
	}
	
}
