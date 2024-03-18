package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.security.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.exception.TokenRefreshException;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.RefreshToken;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.repository.RefreshTokenRepository;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class RefreshTokenService {
	
	@Value("${Kelvin.app.jwtRefreshExpirationMs}")
	private Long refreshTokenDurationMs;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepo;
	
	public Optional<RefreshToken> findByToken (String token){
		return refreshTokenRepo.findByToken(token);
	}
	
	public RefreshToken createRefreshToken(Long userId) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setUser(userRepo.findById(userId).get());
		refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
		refreshToken.setToken(UUID.randomUUID().toString());
		refreshToken = refreshTokenRepo.save(refreshToken);
		return refreshToken;
	}
	
	public RefreshToken verifyExpiration(RefreshToken token) {
		if(token.getExpiryDate().compareTo(Instant.now()) < 0) {
			refreshTokenRepo.delete(token);
			throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
		}
		
		return token;
	}
	
	@Transactional
	public int deleteByUserId(Long userId) {
		return refreshTokenRepo.deleteByUser(userRepo.findById(userId).get());
	}
}
