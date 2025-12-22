package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

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
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "Harry Potter the Chamber of Secrets", "descricao 1",
				50.50, "");
		Product p2 = new Product(null, "Samsung Galaxy S20", "descricao 2",
				7000.65, "");
		Product p3 = new Product(null, "Playstation 4 Pro", "descricao 3",
				3000.45, "");
		Product p4 = new Product(null, "Pc Gamer Asus", "descricao 4",
				6570.89, "");
		Product p5 = new Product(null, "The Collector - Darkside", "descricao 5",
				76.23, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}
	
	
}
