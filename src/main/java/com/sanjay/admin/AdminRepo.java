package com.sanjay.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, String> {
//	@Query("SELECT name,email,password FROM admin u WHERE u.email = ?1")
//    public Admin findByEmail(String email);
	
	public Admin findByUsernameAndPassword(String username, String password);
}
