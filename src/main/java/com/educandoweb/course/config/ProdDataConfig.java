//package com.educandoweb.course.config;
//
//import java.time.Instant;
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import com.educandoweb.course.entities.Category;
//import com.educandoweb.course.entities.Order;
//import com.educandoweb.course.entities.OrderItem;
//import com.educandoweb.course.entities.Payment;
//import com.educandoweb.course.entities.Product;
//import com.educandoweb.course.entities.User;
//import com.educandoweb.course.entities.enums.OrderStatus;
//import com.educandoweb.course.repositories.CategoryRepository;
//import com.educandoweb.course.repositories.OrderItemRepository;
//import com.educandoweb.course.repositories.OrderRepository;
//import com.educandoweb.course.repositories.ProductRepository;
//import com.educandoweb.course.repositories.UserRepository;
//
//@Configuration
//@Profile("prod")
//public class ProdDataConfig implements CommandLineRunner {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private OrderRepository orderRepository;
//	
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	@Autowired
//	private ProductRepository productRepository;
//	
//	@Autowired
//	private OrderItemRepository orderItemRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		if (userRepository.count() > 0 || productRepository.count() > 0 || 
//				orderRepository.count() > 0 || orderItemRepository.count() > 0 ||
//				categoryRepository.count() > 0) {
//			return;
//		}
//		
//		// ====== USERS ======
//		User u1 = new User(null, "João", "joao@gmail.com", "19995273456", "09876");
//		User u2 = new User(null, "Ana", "ana@gmail.com", "17993680012", "12345");
//		
//		userRepository.saveAll(Arrays.asList(u1, u2));
//		
//		// ====== ORDERS ======
//		Order o1 = new Order(null, Instant.parse("2025-12-21T15:00:00Z"), 
//				OrderStatus.SHIPPED, u1);
//		Order o2 = new Order(null, Instant.parse("2025-11-05T06:30:45Z"), 
//				OrderStatus.DELIVERED, u1);
//		Order o3 = new Order(null, Instant.parse("2025-08-26T20:09:12Z"), 
//				OrderStatus.PAID, u2);
//		
//		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
//		
//		// ====== CATEGORIES ======
//		Category cat1 = new Category(null, "Electronics");
//		Category cat2 = new Category(null, "Books");
//		Category cat3 = new Category(null, "Computers");
//		
//		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
//		
//		// ====== PRODUCTS ======
//		Product p1 = new Product(null, "Harry Potter the Chamber of Secrets", "descricao 1",
//				50.50, "");
//		Product p2 = new Product(null, "Samsung Galaxy S20", "descricao 2",
//				7000.65, "");
//		Product p3 = new Product(null, "Playstation 4 Pro", "descricao 3",
//				3000.45, "");
//		Product p4 = new Product(null, "Pc Gamer Asus", "descricao 4",
//				6570.89, "");
//		Product p5 = new Product(null, "The Collector - Darkside", "descricao 5",
//				76.23, "");
//		
//		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
//		
//		p1.getCategories().add(cat2);
//		p2.getCategories().add(cat1);
//		p3.getCategories().add(cat1);
//		p4.getCategories().add(cat3);
//		p5.getCategories().add(cat2);
//		
//		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
//		
//		
//		// ====== ORDER ITEMS ======
//		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
//		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
//		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
//		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
//		
//		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
//		
//		Payment pay1 = new Payment(null, Instant.parse("2025-08-26T22:09:12Z"), o3);
//		o3.setPayment(pay1);
//		orderRepository.save(o3);
//
//	}
//	
//	
//}
