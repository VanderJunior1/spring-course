package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.Request;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.domain.enums.Role;
import com.springcourse.repositories.RequestRepository;
import com.springcourse.repositories.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RequestRepositoryTests {
	
	@Autowired
	private RequestRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	@Order(1)
	public void save() {
		User user = new User(null, "Vander", "vanderjunior1@hotmail.com", "1234561", Role.SIMPLE);
		User createUser  = userRepo.save(user);
		assertThat(createUser.getId()).isEqualTo(1);
		
		Request request = new Request(null, "Novo LapTop HP", "Pretento obter laptop Hp",
				LocalDateTime.now(), RequestState.OPEN, createUser);
		Request createdRequest = repo.save(request);
		assertThat(createdRequest.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(2)
	public void update() {
		Optional<User> getUser  = userRepo.findById(1);
		User resultUser = getUser.get();
		assertThat(resultUser.getPassword()).isEqualTo("1234561");
		
		Request request = new Request(1, "Novo LapTop DELL", "Pretento obter laptop DELL",
				null, RequestState.OPEN, resultUser);
		Request updatedRequest = repo.save(request);
		assertThat(updatedRequest.getSubject()).isEqualTo("Novo LapTop DELL");
	}
	
	@Test
	@Order(3)
	public void getByIdTest() {
		Optional<Request> request = repo.findById(1);
		Request result = request.get();
		assertThat(result.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(4)
	public void listTest() {
		List<Request> lista = repo.findAll();
		assertThat(lista.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(5)
	public void listByOwnerTest() {
		List<Request> lista = repo.findAllByOwnerId(1);
		assertThat(lista.size()).isEqualTo(1);
	}
	
	@Test
	@Order(6)
	public void updateStatusTests() {
		Integer affectedRows = repo.updateStatus(1, RequestState.CLOSED.getCod());
		assertThat(affectedRows).isEqualTo(1);
	}

}
