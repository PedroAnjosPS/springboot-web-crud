package com.educandoweb.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public String listproducts(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
	    return "products";
	}
}
