package com.ust.pms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.pms.model.User;
import com.ust.pms.repo.UserRepository;
import com.ust.pms.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("users")
public class UserController {

	/*
	 * @Autowired private UserRepository userRepository;
	 * 
	 * @PostMapping("/register") public ResponseEntity<String> saveUser(@RequestBody
	 * User user) { userRepository.save(user); return new
	 * ResponseEntity<String>("Registration Successfully ", HttpStatus.CREATED); }
	 * 
	 * @GetMapping("/getUsers") public ResponseEntity<List<User>> getUsers() {
	 * List<User> users = (List<User>) userRepository.findAll(); return new
	 * ResponseEntity<List<User>>(users, HttpStatus.OK); }
	 * 
	 * @PostMapping("/login") public ResponseEntity<User> confirm(@RequestBody User
	 * user) { User info =
	 * userRepository.findByUserNameAndPassword(user.getUserName(),
	 * user.getPassword()); if (info != null) { if
	 * ((user.getUserName()).equals(info.getUserName()) &&
	 * ((user.getPassword()).equals(info.getPassword()) )) { return new
	 * ResponseEntity<User>(HttpStatus.OK); } else return new
	 * ResponseEntity<User>(HttpStatus.UNAUTHORIZED); } return new
	 * ResponseEntity<User>(info, HttpStatus.NOT_FOUND); }
	 */

	@Autowired
	UserService userService;

	List<User> Users = new ArrayList<User>();

	// Getting All the Users
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers() {
		Users = userService.getUsers();
		return new ResponseEntity<List<User>>(Users, HttpStatus.OK);
	}

	// Saving the User
	@PostMapping()
	public ResponseEntity<String> saveUser(@RequestBody User User) {
		System.out.println(User);
		userService.saveUser(User);
		return new ResponseEntity<String>("Registration done Successfully", HttpStatus.OK);
	}

	// Getting a single User
	@GetMapping("/{UserId}")
	public ResponseEntity<User> getUser(@PathVariable("UserId") Integer UserId) {
		System.out.println("User id called");
		if (userService.isUserExists(UserId)) {
			User User = userService.getUser(UserId);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}

	// delete
	@DeleteMapping("/{UserId}")
	public ResponseEntity<String> deleteUser(@PathVariable("UserId") Integer UserId) {
		System.out.println("Delete controller");
		if (userService.isUserExists(UserId)) {
			userService.deleteUser(UserId);
			return new ResponseEntity<String>("Deleted Ok", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Deleted not ", HttpStatus.NO_CONTENT);

		}
	}

	// update
	@PutMapping()
	public ResponseEntity<String> updateUser(@RequestBody User User) {

		if (userService.isUserExists(User.getUserId())) {
			userService.updateUser(User);
			return new ResponseEntity<String>("Updated Ok", HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Updated failed ", HttpStatus.NO_CONTENT);

		}
	}

	// validate user
	// Getting a single User
	@GetMapping("/validate/{UserName}/{password}")
	public ResponseEntity<String> getUserByName(@PathVariable("UserName") String username,
			@PathVariable("password") String password) {
		System.out.println("User name called");
		boolean result = userService.validateUser(username, password);
		if (result) {
			return new ResponseEntity<String>("Valid", HttpStatus.OK);
		}
		{
			return new ResponseEntity<String>("Invalid", HttpStatus.UNAUTHORIZED);
		}

	}

}
