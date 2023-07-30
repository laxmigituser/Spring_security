package com.pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.dto.UserDTO;
import com.pkg.dto.UserDTO;
import com.pkg.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("user/addUser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		UserDTO addUser = this.userService.addUser(userDTO);
		return new ResponseEntity<UserDTO>(addUser, HttpStatus.CREATED);
	}
	@GetMapping("user/getAllUser")
	public ResponseEntity<List<UserDTO>> getAllUser(){
		return new ResponseEntity<List<UserDTO>>(this.userService.getAllUser(), HttpStatus.OK);
	}
	@GetMapping("user/getUser/{userId}")
	//only working if role is admin
	//to be checked for other roles as well
	@PreAuthorize("hasAuthority('ROLE_MODERATE')")
	public ResponseEntity<UserDTO> getUser(@PathVariable int userId){
		return new ResponseEntity<UserDTO>(this.userService.getUser(userId), HttpStatus.OK);
	}

}
