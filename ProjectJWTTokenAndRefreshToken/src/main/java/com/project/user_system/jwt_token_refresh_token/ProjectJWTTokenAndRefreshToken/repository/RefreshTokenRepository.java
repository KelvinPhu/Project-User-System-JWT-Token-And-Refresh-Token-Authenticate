package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.RefreshToken;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	Optional<RefreshToken> findByToken(String token);

	@Modifying
	int deleteByUser(User user);
}
