package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TokenRefreshRequest {

	@NotBlank
	private String refreshToken;
}
