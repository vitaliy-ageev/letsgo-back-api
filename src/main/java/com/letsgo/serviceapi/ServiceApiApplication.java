package com.letsgo.serviceapi;

import com.letsgo.serviceapi.model.AppRole;
import com.letsgo.serviceapi.model.AppUser;
import com.letsgo.serviceapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApiApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new AppRole(null, "ROLE_USER"));
			userService.saveRole(new AppRole(null, "ROLE_MANAGER"));
			userService.saveRole(new AppRole(null, "ROLE_ADMIN"));
			userService.saveRole(new AppRole(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
		};
	}
}
