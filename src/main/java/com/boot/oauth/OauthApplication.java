package com.boot.oauth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.boot.oauth.user.model.User;
import com.boot.oauth.user.repository.UserRepository;

@SpringBootApplication
@EnableResourceServer
public class OauthApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		if (this.userRepository.findByUsername("swati") == null) {
			User user = new User("Swati", "swati", passwordEncoder.encode("password1"), Arrays.asList("ADMIN"));

			this.userRepository.save(user);
		}
	}

}
