package com.bookapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookapi.model.User;

public interface UserRepository  extends JpaRepository<User, String>{

	  Optional<User> findByUsername(String username);
	  Boolean existsByUsername(String username);


}
