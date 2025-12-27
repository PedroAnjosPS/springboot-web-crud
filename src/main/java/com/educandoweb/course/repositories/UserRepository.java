package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.educandoweb.course.entities.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long>{
	@Modifying
	@Transactional
	@Query(value = "TRUNCATE TABLE tb_user RESTART IDENTITY CASCADE", nativeQuery = true)
	void truncateUsers();
}
