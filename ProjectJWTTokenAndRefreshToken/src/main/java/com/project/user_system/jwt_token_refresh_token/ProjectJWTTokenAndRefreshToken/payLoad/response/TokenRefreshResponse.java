package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.response;

import lombok.Data;

@Data
public class TokenRefreshResponse {
	private String accessToken;
	private String refreshToken;
	private String tokenType = "Bearer";
	
	public TokenRefreshResponse(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
	    this.refreshToken = refreshToken;
	}
}
