package com.rest.webservices.restfulwebservice.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restfulwebservice.dto.User;
import com.rest.webservices.restfulwebservice.exceptins.UserNotFoundException;
import com.rest.webservices.restfulwebservice.service.UserServiceDao;

@RestController
public class ResourceController {

	@Autowired
	private UserServiceDao userServiceDao;
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userServiceDao.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id)
	{
	  	User user = userServiceDao.findUser(id);
	  	if(user==null) {
	  		throw new UserNotFoundException("User not found with id...."+id);
	  	}
	  	
	    WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllUsers());
	    
	    EntityModel<User> resource =new EntityModel<User>(user, link.withRel("all-users"));
	    //resorce.add(link.withRel("all-users"));
	    
	  	return resource;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> createUser(@RequestBody @Valid User user)
	{
		//User user =new User(104, "nani", new Date());
		User user1= userServiceDao.save(user);
		
		URI location = ServletUriComponentsBuilder.
		fromCurrentRequest().
		path("/{id}").
		buildAndExpand(user1.getId()).toUri();
		
	    return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/deleteusers/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user =  userServiceDao.findUser(id);
		if(user==null)
		{
			throw new UserNotFoundException("user not found....."+id);
		}
		else
		{
			 userServiceDao.deleteUser(id); 	
		}
		
	}
	
}
