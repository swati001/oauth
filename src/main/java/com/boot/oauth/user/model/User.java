package com.boot.oauth.user.model;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Document(collection = "users")
public class User {
	@Id
	private String id;
	private String name;
	private String username;
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@JsonProperty("roles")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private Collection<String> roles;
	private boolean activated;

	public User() {

	}

	public User(String name, String username, String password, List<String> roles, String email) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.email=email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<String> getRoles() {
		return roles;
	}

	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}
	
	public String geEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email="+ email + ", username=" + username + ", password=" + password + ", roles="
				+ roles + "]";
	}

}