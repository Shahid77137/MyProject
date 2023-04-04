package com.masaischool.dao;

import java.util.List;
import com.masaischool.dto.User;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public interface UserDAO {
	//for admin side
	void addUser(User user) throws SomeThingWrongException;
	List<User> getAllUsersList() throws SomeThingWrongException, NoRecordFoundException;
	
	//for user side
	void updateNameOfUser(String name) throws SomeThingWrongException;
	void changePassword(String oldPassword, String newPassword) throws SomeThingWrongException, NoRecordFoundException;
	void deleteUser() throws SomeThingWrongException;
	void Login(String username, String password) throws SomeThingWrongException, NoRecordFoundException;
	void logout();
	
}