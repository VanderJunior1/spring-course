package com.springcourse.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repositories.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repo;

	public Request save(Request request) {
		request.setState(RequestState.OPEN);
		request.setCreationDate(LocalDateTime.now());

		Request creationrequest = repo.save(request);
		return creationrequest;
	}

	public Request update(Request request) {
		Request updateRequest = repo.save(request);
		return updateRequest;
	}

	public Request getById(Integer id) {
		Optional<Request> result = repo.findById(id);
		return result.get();
	}

	public List<Request> findAll() {
		return repo.findAll();
	}

	public List<Request> findAllByOwnerId(Integer id) {
		return repo.findAllByOwnerId(id);
	}

}
