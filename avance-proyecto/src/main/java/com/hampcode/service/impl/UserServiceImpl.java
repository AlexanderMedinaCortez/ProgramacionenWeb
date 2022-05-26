package com.hampcode.service.impl;

import java.util.List;

import com.hampcode.entity.User;
import com.hampcode.repository.UserRepository;
import com.hampcode.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getOneById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found!"));
	}

	@Override
	public Long create(User entity) {
		userRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, User entity) {
		User currentUser = getOneById(id);
		currentUser.setFirstName(entity.getFirstName());
		currentUser.setLastName(entity.getLastName());
		currentUser.setPhone(entity.getPhone());
		currentUser.setEmail(entity.getEmail());
		currentUser.setPassword(entity.getPassword());

		userRepository.save(currentUser);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
