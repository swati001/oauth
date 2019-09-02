package com.boot.oauth.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boot.oauth.user.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);
	
//	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    User findByUsernameCaseInsensitive(@Param("username") String username);

//    @Query
    User findByEmail(String email);

}