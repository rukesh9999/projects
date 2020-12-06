package com.rest.webservices.restfulwebservice.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("All Details about the User")
public class User {

	private Integer id;
	@Size(min=3)
	@ApiModelProperty("Name Should Have Atleast 3 Characters")
	private String name;
	@Past
	@ApiModelProperty(notes = "BithDate Must be Past Date")
	private Date dateofbirth;
	
	
	
	public User() {
	}
	
	public User(Integer id, String name, Date dateofbirth) {
	
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateofbirth() {
		return dateofbirth;
	}
	
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateofbirth=" + dateofbirth + "]";
	}
	
	
}
