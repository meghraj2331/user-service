package com.edusol.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.user.model.User;
import com.edusol.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController { 
	@Autowired 
	private UserService userservice;
	
	
    @PostMapping
	public ResponseEntity<User>  addUser(@RequestBody User user)
	{
    	
    	return new ResponseEntity<User>(userservice.addUser(user),HttpStatus.CREATED);
	}
    
    @GetMapping
    public ResponseEntity <List<User>> getUser()
    {
    	return new  ResponseEntity<List<User>>(userservice.getUser(),HttpStatus.OK);
    }
    
	/*
	 * @DeleteMapping("/{city}") public List<User>
	 * deleteUsersbycityName(@RequestParam String city){ return
	 * userservice.deleteUsersByCity(city); }
	 */
    @PutMapping
    public String updateUser(@RequestBody User user) {
    	return userservice.updateUser(user);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
    	
    return userservice.deleteUser(id);	
    	
    }
   
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
    	
   // return userservice.deleteUser(id);	
    	return null;
    }
   
    
}
