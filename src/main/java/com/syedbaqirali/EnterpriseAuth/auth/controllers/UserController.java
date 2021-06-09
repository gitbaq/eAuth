/**
 * 
 */
package com.syedbaqirali.EnterpriseAuth.auth.controllers;

import java.util.List;

import javax.validation.Valid;

/**
 * @author SBA
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.syedbaqirali.EnterpriseAuth.auth.Status;
import com.syedbaqirali.EnterpriseAuth.auth.User;
import com.syedbaqirali.EnterpriseAuth.auth.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/user")
	public String admin() {
		return ("<h1>Welcome User</h1>");

	}

	@PostMapping("/users/register")
	public Status registerUser(@Valid @RequestBody User newUser) {
		List<User> users = userRepository.findAll();
		System.out.println("New user: " + newUser.toString());
		for (User user : users) {
			System.out.println("Registered user: " + newUser.toString());
			if (user.equals(newUser)) {
				System.out.println("User Already exists!");
				return Status.USER_ALREADY_EXISTS;
			}
		}
		userRepository.save(newUser);
		return Status.SUCCESS;
	}

	@PostMapping("/users/login")
	public Status loginUser(@Valid @RequestBody User user) {
		List<User> users = userRepository.findAll();
		for (User other : users) {
			if (other.equals(user)) {

				userRepository.save(user);
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

	@PostMapping("/users/logout")
	public Status logUserOut(@Valid @RequestBody User user) {
		List<User> users = userRepository.findAll();
		for (User other : users) {
			if (other.equals(user)) {

				userRepository.save(user);
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

	@DeleteMapping("/users/all")
	public Status deleteUsers() {
		userRepository.deleteAll();
		return Status.SUCCESS;
	}

	@GetMapping("/users/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();

	}

}
