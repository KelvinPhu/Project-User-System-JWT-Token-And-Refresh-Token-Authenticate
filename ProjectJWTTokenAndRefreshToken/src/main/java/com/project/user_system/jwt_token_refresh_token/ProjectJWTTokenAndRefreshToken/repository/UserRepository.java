package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	Optional<User> findByUsername(String username);
}
