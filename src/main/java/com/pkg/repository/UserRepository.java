package com.pkg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkg.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
Optional<User> findByName(String name);
}
