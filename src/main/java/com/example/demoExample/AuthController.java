package com.example.demoExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Users users = null;
		if(loginRequest.getUsername().equals("user") && loginRequest.getPassword().equals("123"))
		{
			users = new Users();
			users.setUserName("user");
			users.setEmail("user@gmail.com");
			users.setPassword(loginRequest.getPassword());
			users.setRole("ROLE_USER");
		}
		if(loginRequest.getUsername().equals("admin") && loginRequest.getPassword().equals("123"))
		{
			users = new Users();
			users.setUserName("admin");
			users.setEmail("admin@gmail.com");
			users.setPassword(loginRequest.getPassword());
			users.setRole("ROLE_ADMIN");
		}
		return ResponseEntity.ok(new JwtResponse(users.getId(), users.getUserName(), users.getEmail(), users.getRole()));
	}
}
