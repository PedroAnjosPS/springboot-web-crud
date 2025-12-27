package com.educandoweb.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.repositories.UserRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminResource {
	@Autowired
	private UserRepository userRepository;
	
	@DeleteMapping("/reset-users")
	public ResponseEntity<Void> resetUsers() {
		userRepository.truncateUsers();
		return ResponseEntity.noContent().build();
	}
}
