package com.itemsharing.userservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itemsharing.userservice.model.Role;
import com.itemsharing.userservice.model.User;
import com.itemsharing.userservice.model.UserRole;
import com.itemsharing.userservice.service.UserService;

@SpringBootApplication
public class UserserviceApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setFirstName("HeJ");
		user.setLastName("padig");
		user.setEmail("oink@boink.com");
		user.setId(1);
		
		user.setUsername("testy");
		user.setPassword("pass");

		Set<UserRole> roles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		roles.add(new UserRole(user, role1));
	
		userService.createUser(user);
	}

}
