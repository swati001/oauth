package com.boot.oauth.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.oauth.user.model.User;
import com.boot.oauth.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User saveUser(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return this.userRepository.save(user);
	}

	public List<User> getAll() {
		return this.userRepository.findAll();
	}
}
