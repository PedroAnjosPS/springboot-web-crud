package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Barolo", "barolo@gmail.com", "111111111", "09876");
		User u2 = new User(null, "Ana Castelo", "castelin@gmail.com", "999999999", "12345");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		Order o1 = new Order(null, Instant.parse("2025-12-21T15:00:00Z"), 
				OrderStatus.SHIPPED, u1);
		Order o2 = new Order(null, Instant.parse("2025-11-05T06:30:45Z"), 
				OrderStatus.DELIVERED, u1);
		Order o3 = new Order(null, Instant.parse("2025-08-26T20:09:12Z"), 
				OrderStatus.CANCELED, u2);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}
