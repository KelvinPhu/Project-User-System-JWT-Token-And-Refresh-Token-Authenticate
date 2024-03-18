package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.exception.TokenRefreshException;

@RestControllerAdvice
public class TokenControllerAdvice {

	@ExceptionHandler(value = TokenRefreshException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorMessage handleTokenRefreshException (TokenRefreshException exception, WebRequest request) {
		return new ErrorMessage(
				HttpStatus.FORBIDDEN.value(),
				new Date(),
				exception.getMessage(),
				request.getDescription(false)
		);
	}
}
