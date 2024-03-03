package com.app.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> addNewUser(@RequestBody  UserDTO dto)
	{
		System.out.println("in add user"+dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> getUserDetails(@PathVariable Long userid){
		
		return ResponseEntity.ok(userService.getUserDetails(userid));
		
	}
	
	@PutMapping("/{userid}")
	public ResponseEntity<?> updateUser(@PathVariable Long userid,@RequestBody  UserDTO user)
	{
		return ResponseEntity.ok(userService.updateUser(userid,user));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUserDetails() {
		
		return ResponseEntity
				.ok(userService.getAllUser());
	}
	
	
}