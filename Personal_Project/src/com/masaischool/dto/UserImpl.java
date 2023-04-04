package com.masaischool.dto;

import java.time.LocalDate;

public class UserImpl implements User {
	private Integer userId;
	private String name;
	private String username;
	private String password;
	private LocalDate registrationDate;
	
	public UserImpl() {}
	
	public UserImpl(Integer userId, String name, String username, String password, LocalDate registrationDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.registrationDate = registrationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		return userId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserImpl other = (UserImpl) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User Id: " + userId + ", Name: " + name + ", Username: " + username + ", Registration Date: " + registrationDate;
	}
}
