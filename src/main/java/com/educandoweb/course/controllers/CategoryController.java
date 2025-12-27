package com.educandoweb.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryRepository CategoryRepository;

	@GetMapping
	public String listCategorys(Model model) {
		List<Category> categories = CategoryRepository.findAll();
		model.addAttribute("categories", categories);
	    return "categories";
	}
}
