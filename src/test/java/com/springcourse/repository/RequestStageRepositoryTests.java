package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.domain.enums.Role;
import com.springcourse.repositories.RequestRepository;
import com.springcourse.repositories.RequestStageRepository;
import com.springcourse.repositories.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RequestStageRepositoryTests {
	
	@Autowired
	private RequestStageRepository repo;
	
	@Autowired
	private RequestRepository requestRepo;
	
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
		Request createdRequest = requestRepo.save(request);
		assertThat(createdRequest.getId()).isEqualTo(1);
		
		RequestStage requestStage = new RequestStage(null, "Foi comprado LAPTOP DELL", LocalDateTime.now(), RequestState.CLOSED, createdRequest, createUser);
		
		RequestStage createdRequestStage = repo.save(requestStage);
		assertThat(createdRequestStage.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(2)
	public void getByIdTest() {
		Optional<RequestStage> requestStage = repo.findById(1);
		RequestStage result = requestStage.get();
		assertThat(result.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(3)
	public void findAllByRequestIdTest() {
		List<RequestStage> lista = repo.findAllByRequestId(1);
		assertThat(lista.size()).isGreaterThan(0);
	}
	
	
	@Test
	@Order(4)
	public void listTest() {
		List<RequestStage> lista = repo.findAll();
		assertThat(lista.size()).isGreaterThan(0);
	}
	
}
