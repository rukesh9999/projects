package com.rest.webservices.restfulwebservice.Controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties(value = {"id","name"} )
@JsonFilter("filterBean")
public class FilterBean {
    
	private int id;
	private String name;
	//@JsonIgnore
	private String course;
	
	
	public FilterBean(int id, String name, String course) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "FilterBean [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
	
	
	
	
}
