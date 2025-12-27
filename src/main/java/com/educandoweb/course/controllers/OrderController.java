package com.educandoweb.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository OrderRepository;

	@GetMapping
	public String listOrders(Model model) {
		List<Order> orders = OrderRepository.findAll();
		model.addAttribute("orders", orders);
	    return "orders";
	}
}
