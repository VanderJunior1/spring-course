package com.springcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.User;
import com.springcourse.repositories.UserRepository;
import com.springcourse.services.util.HashUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User save(User user) {
		String hash = HashUtil.getSecutityHash(user.getPassword());
		user.setPassword(hash);
		
		User creationUser = repo.save(user);
		return creationUser;
	}

	public User update(User user) {
		String hash = HashUtil.getSecutityHash(user.getPassword());
		user.setPassword(hash);
		
		User updateUser = repo.save(user);
		return updateUser;
	}
	
	public User getById(Integer id) {
		Optional<User> result = repo.findById(id);
		return result.get();
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}

	public User login(String email, String password) {
		password = HashUtil.getSecutityHash(password);
		
		Optional<User> result = repo.findByEmailAndPassWord(email, password);
		return result.get();
	}
}
