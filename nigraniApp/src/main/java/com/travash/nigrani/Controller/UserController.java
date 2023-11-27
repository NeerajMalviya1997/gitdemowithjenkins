package com.travash.nigrani.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travash.nigrani.Model.User;
import com.travash.nigrani.Model.UserDTO;
import com.travash.nigrani.Services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	// to register user
	@PostMapping("/create")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		System.out.println(user);
		User us = userServiceImpl.createUser(user);
		return new ResponseEntity<User>(us, HttpStatus.OK);
	}

	// to update user by passing key
	@PutMapping("/update")
	public User updateUser(@RequestBody User user, @RequestParam(required = false) String key) {

		return userServiceImpl.updateUser(user, key);
	}

	// for user login
	@PostMapping("/userlogin")
	public String logInUser(@RequestBody UserDTO userDTO) throws Exception {
		return userServiceImpl.logIntoAccount(userDTO);
	}

	@PatchMapping("/userlogout")
	public String logOutUser(@RequestParam(required = false) String key) {
		return userServiceImpl.logOutAccount(key);
	}

}
