package com.example.csis3275_group5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.csis3275_group5.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

}