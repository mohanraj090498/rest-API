package com.learning.springboot.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.springboot.entity.UserDetails;
import com.learning.springboot.repository.UserDetailsRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDetailsRepository userRepository;

	@Override
	public UserDetails saveUser(UserDetails user) {
		return userRepository.save(user);
	}

	@Override
	public List<UserDetails> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public UserDetails updateUser(Long id, UserDetails user) {
		UserDetails existing = getUserById(id);
		existing.setName(user.getName());
		existing.setMobileNumber(user.getMobileNumber());
		return userRepository.save(existing);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
