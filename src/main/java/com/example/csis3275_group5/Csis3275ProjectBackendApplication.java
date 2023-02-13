package com.example.csis3275_group5;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.csis3275_group5.model.Role;
import com.example.csis3275_group5.model.RoleType;
import com.example.csis3275_group5.repository.RoleRepo;

@SpringBootApplication
public class Csis3275ProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Csis3275ProjectBackendApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(RoleRepo roleRepo) {
		return arg -> {
			roleRepo.save(new Role(RoleType.ROLE_USER));
		};
	}

}
