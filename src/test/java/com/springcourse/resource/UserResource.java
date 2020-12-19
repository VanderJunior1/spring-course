package com.springcourse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcourse.domain.Request;
import com.springcourse.domain.User;
import com.springcourse.dto.UserLoginDto;
import com.springcourse.services.RequestService;
import com.springcourse.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	@Autowired
	private RequestService requestService;

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		User createdUser = service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserLoginDto user) {
		User loggedUser = service.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(loggedUser);
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable(name = "id") Integer id, @RequestBody User user) {
		user.setId(id);
		User updatedUser = service.save(user);
		return ResponseEntity.ok(updatedUser);

	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable(name = "id") Integer id) {
		User user = service.getById(id);
		return ResponseEntity.ok(user);

	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> lista = service.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}/requests")
	public ResponseEntity<List<Request>> findAllRequestsById(@PathVariable(name = "id") Integer id) {
		List<Request> lista = requestService.findAllByOwnerId(id);
		return ResponseEntity.ok(lista);
	}

}
