package com.sanjay.user;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {
	
//	 @Query(value = "SELECT id,email FROM User u WHERE u.email = ?1", 
//	  nativeQuery = true)
//    public User findByEmail(String email);

//	public User findByUsernameAndPassword(String username, String password);
}
