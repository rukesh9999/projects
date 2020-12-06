package com.bookapi.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private String id;
	private ERole name;
	
	
	
	
	public Role(String id, ERole name) {
	
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ERole getName() {
		return name;
	}
	public void setName(ERole name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
}
