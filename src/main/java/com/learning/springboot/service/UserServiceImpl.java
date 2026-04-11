package com.learning.springboot.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.springboot.entity.UserDetails;
import com.learning.springboot.exception.UserNotFoundException;
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
		Optional<UserDetails> userDetails = userRepository.findById(id);
		if (userDetails.isPresent()) {
			return userDetails.get();
		}else {
			throw new UserNotFoundException("user not found "+id);
		}
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
