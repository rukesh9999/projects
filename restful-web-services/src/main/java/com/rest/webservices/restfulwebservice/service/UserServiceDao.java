package com.rest.webservices.restfulwebservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.webservices.restfulwebservice.dto.User;

@Service
public class UserServiceDao {

	private static  List<User> users =new ArrayList<>();
	
	
	static {
		users.add(new User(101, "mounika", new Date()));
		users.add(new User(102, "roopa", new Date()));
		users.add(new User(103, "madhavi", new Date()));
	}

	
	public  List<User> findAll()
	{
		return users;
	}
	
	public User save(User user)
	{
	  if(user.getId()==null) {
			int num = users.size();
            int value=100;
            int cnt=num+value;
		  user.setId(cnt+1);
	  }
	  users.add(user);
	  return  user;
	}
	
	public User findUser(int id)
	{
	  for(User user: users)
	  {
		  if(user.getId() == id)
		  {
			  return user;
		  }
	  }
        return null;
	}
	
	public User deleteUser(int id)
	{
	    Iterator<User> itr = users.iterator();
	    while(itr.hasNext())
	    {
	    	User user = itr.next();
	    	if(user.getId()== id)
	    	{
	    		itr.remove();
	    		return user;
	    	}
	    }
	    return null;
	}
}
