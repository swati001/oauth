package com.boot.oauth.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.oauth.user.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}