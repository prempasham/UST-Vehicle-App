package com.ust.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.pms.model.User;
import com.ust.pms.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public String saveUser(User User) {
		userRepository.save(User);
		return "User Saved Successfully";
	}

	@Override
	public String updateUser(User User) {
		userRepository.save(User);
		return "User Updated Successfully";
	}

	@Override
	public String deleteUser(int userId) {
		System.out.println("Delete Service");
		userRepository.deleteById(userId);
		return "User Deleted Successfully";

	}

	@Override
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUser(int UserId) {
		Optional<User> UserData = userRepository.findById(UserId);
		User User = UserData.get();
		return User;
	}

	@Override
	public boolean isUserExists(int UserId) {
		return userRepository.existsById(UserId);
	}

	@Override
	public boolean validateUser(String userName, String password) {
		User user = userRepository.findByUserNameAndPassword(userName, password);
		if (user == null) {
			return false;
		}
		{
			return true;
		}

	}

}
