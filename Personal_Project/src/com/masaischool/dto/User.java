package com.masaischool.dto;

import java.time.LocalDate;

public interface User {
	public Integer getUserId();
	public void setUserId(Integer userId);
	public String getName();
	public void setName(String name);
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password);
	public LocalDate getRegistrationDate();
	public void setRegistrationDate(LocalDate registrationDate);
}
