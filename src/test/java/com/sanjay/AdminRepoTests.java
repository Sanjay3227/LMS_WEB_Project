package com.sanjay;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sanjay.admin.Admin;
import com.sanjay.admin.AdminRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AdminRepoTests {
	
	@Autowired
	private AdminRepo arepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateAdmin() {
		Admin admin = new Admin();
	    admin.setName("Admin");
	    admin.setUsername("admin1@admin.com"); 
	    admin.setPassword("root");
	    
	    Admin savedAdmin = arepo.save(admin);
	     
	    Admin existAdmin = entityManager.find(Admin.class, savedAdmin.getId());
	     
	    assertThat(admin.getUsername()).isEqualTo(existAdmin.getUsername());
	}
	

}
