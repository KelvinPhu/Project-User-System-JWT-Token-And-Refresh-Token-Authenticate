package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.response;

import lombok.Data;

@Data
public class MessageResponse {
	
	private String message;

	public MessageResponse(String message) {
		super();
		this.message = message;
	}
}
