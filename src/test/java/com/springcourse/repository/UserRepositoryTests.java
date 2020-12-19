package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;
import com.springcourse.repositories.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Test
	@Order(1)
	public void saveTest() {
		User user = new User(null, "Vander", "vanderjunior1@hotmail.com", "1234561", Role.SIMPLE);
		User createUser  = repo.save(user);
		assertThat(createUser.getId()).isEqualTo(1);
		
	}

	@Test
	@Order(2)
	public void updateTest() {
		User user = new User(1, "Vander Junior", "vanderjunior1@hotmail.com", "1234561", Role.ADMINSTRATOR);
		User upateUser  = repo.save(user);
		assertThat(upateUser.getNome()).isEqualTo("Vander Junior");
	}
	
	@Test
	@Order(3)
	public void getByIdTest() {
		Optional<User> getUser  = repo.findById(1);
		User result = getUser.get();
		assertThat(result.getPassword()).isEqualTo("1234561");
	}
	
	@Test
	@Order(4)
	public void loginTest() {
		Optional<User> getUser = repo.findByEmailAndPassWord("vanderjunior1@hotmail.com", "1234561");
		User result = getUser.get();
		assertThat(result.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(5)
	public void listTest() {
		List<User> users = repo.findAll();
		assertThat(users.size()).isGreaterThan(0);
	}
}
