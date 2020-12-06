package com.bookapi.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String user_name;
	private String email;
	private String password;
	
	
	private Set<Role> roles;

	
	
	public User() {
	}


	public User(String id, String user_name, String email, String password, Set<Role> roles) {
		this.id = id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "user [id=" + id + ", user_name=" + user_name + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	
	
	
	
	
	
}
