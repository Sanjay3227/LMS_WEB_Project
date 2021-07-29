package com.sanjay;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sanjay.user.User;
import com.sanjay.user.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTests {
	
	@Autowired
	private UserRepo repo;

	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
	    user.setName("Rushi Sherkhane");
	    user.setAddress("Pune");
	    user.setReg_date("20/07/2021");
	    user.setUsername("rushi@gmail.com");
	    user.setPhone(907666666);
	    user.setPassword("root");
	    
	    User savedUser = repo.save(user);
	     
	    User existUser = entityManager.find(User.class, savedUser.getId());
	     
	    assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
	}
	
//	@Test
//	public void testFindUserByEmail() {
//		String email = "rushi@gmail.com";
//		User user=repo.findByEmail(email);
//		
//		assertThat(user).isNotNull();
//	}
}