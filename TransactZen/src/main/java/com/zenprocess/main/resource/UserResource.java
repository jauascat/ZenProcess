package com.zenprocess.main.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenprocess.main.document.User;
import com.zenprocess.main.repository.UsersRepository;

@RestController
@RequestMapping("/rest/users")
public class UserResource {
	
	private UsersRepository usersRepository;
	
	public UserResource(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@GetMapping("/all")
	public List<User> getAll() {
		return usersRepository.findAll();
	}
}
