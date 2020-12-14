package com.ust.pms.service;

import java.util.List;

import com.ust.pms.model.User;

public interface UserService {
	public String saveUser(User user);
	public String updateUser(User User);
	public String deleteUser(int userId);
	public List<User> getUsers();
	public User getUser(int userId);
	public boolean isUserExists(int userId);
	public boolean validateUser(String userName,String password);
}
