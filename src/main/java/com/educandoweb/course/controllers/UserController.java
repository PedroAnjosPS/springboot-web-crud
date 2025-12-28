package com.educandoweb.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	// INSERT
	@GetMapping
	public String listUsers(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		model.addAttribute("showForm", false);
	    return "users";
	}
	
	@GetMapping("/new") 
	public String showCreateForm(Model model) {
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("showForm", true);
		return "users";
	}
	
	@PostMapping("/create")
	public String insert(User user) {
		userService.insert(user);
		return "redirect:/users";
	}
	
	// UPDATE
	@GetMapping("edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("editId", id);
		return "users";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable Long id, User user) {
		userService.update(id, user);
		return "redirect:/users";
	}
}
