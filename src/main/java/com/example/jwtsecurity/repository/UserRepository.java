package com.example.jwtsecurity.repository;

import com.example.jwtsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(@Param("email") String email);
}
