package com.educandoweb.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public String listUsers(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
	    return "users";
	}
}
