package com.example.csis3275_group5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.csis3275_group5.model.Role;
import com.example.csis3275_group5.model.RoleType;

public interface RoleRepo extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(RoleType name);

}