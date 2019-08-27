package com.boot.oauth.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.boot.oauth.user.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}