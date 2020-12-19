package com.springcourse.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.RequestStage;
import com.springcourse.repositories.RequestRepository;
import com.springcourse.repositories.RequestStageRepository;

@Service
public class RequestStageService {

	@Autowired
	private RequestStageRepository repo;
	@Autowired
	private RequestRepository requestRepository;

	public RequestStage save(RequestStage stage) {
		stage.setRealizationDate(LocalDateTime.now());
		RequestStage creationRequestStage = repo.save(stage);
		requestRepository.updateStatus(stage.getRequest().getId(), stage.getState().getCod());

		return creationRequestStage;
	}

	public RequestStage getById(Integer id) {
		Optional<RequestStage> result = repo.findById(id);
		return result.get();
	}

	public List<RequestStage> findAllByRequestId(Integer id) {
		return repo.findAllByRequestId(id);
	}

}
