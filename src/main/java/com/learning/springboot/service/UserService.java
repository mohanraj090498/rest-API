package com.learning.springboot.service;

import java.util.List;
import com.learning.springboot.entity.UserDetails;

public interface UserService {

	UserDetails saveUser(UserDetails user);

	List<UserDetails> getAllUsers();

	UserDetails getUserById(Long id);

	UserDetails updateUser(Long id, UserDetails user);

	void deleteUser(Long id);

}
