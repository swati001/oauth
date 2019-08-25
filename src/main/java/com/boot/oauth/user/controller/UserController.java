package com.boot.oauth.user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.oauth.user.model.User;
import com.boot.oauth.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public List<User> getAllUsers() {
		return this.userService.getAll();
	}
	
    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
}