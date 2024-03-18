package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.exception.TokenRefreshException;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.EnumRole;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.RefreshToken;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.Role;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.User;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.dto.SigninDto;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.dto.SignupDto;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.request.TokenRefreshRequest;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.response.JwtResponse;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.response.MessageResponse;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.payLoad.response.TokenRefreshResponse;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.repository.RoleRepository;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.repository.UserRepository;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.security.jwt.JwtUtils;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.security.service.RefreshTokenService;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.security.service.UserDetailsImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private PasswordEncoder passEncoder;

	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private RefreshTokenService refreshTokenService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> registeruser(@Valid @RequestBody SignupDto signupDto){
		if(userRepo.existsByUsername(signupDto.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}
		
		if(userRepo.existsByEmail(signupDto.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}
		
		User user = new User(signupDto.getUsername(),
							 signupDto.getEmail(),
							 passEncoder.encode(signupDto.getPassword()));
		Set<String> strRoles = signupDto.getRole();
		Set<Role> roles = new HashSet<>();
		
		if(strRoles == null) {
			Role userRole = roleRepo.findByName(EnumRole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		}else {
			strRoles.forEach(role -> {
		        switch (role) {
			        case "admin":
			        	Role adminRole = roleRepo.findByName(EnumRole.ROLE_ADMIN)
			        		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			        	roles.add(adminRole);
	
			        	break;
			        	
			        case "mod":
			        	Role modRole = roleRepo.findByName(EnumRole.ROLE_MODERATOR)
			              	.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			        	roles.add(modRole);
	
			        	break;
			        	
			        default:
			        	Role userRole = roleRepo.findByName(EnumRole.ROLE_USER)
			              	.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			        	roles.add(userRole);
		        }
		    });
		}
		
		user.setRole(roles);
		userRepo.save(user);
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody SigninDto signinDto){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signinDto.getUsername(), signinDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		String jwt = jwtUtils.generateJwtToken(userDetails);
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
		
		return ResponseEntity.ok(new JwtResponse(
				jwt,
				refreshToken.getToken(),
				userDetails.getId(),
				userDetails.getUsername(),
				userDetails.getEmail(),
				roles));
	}
	
	@PostMapping("/refresh-token")
	public ResponseEntity<?> refreshToken(@Valid @RequestBody TokenRefreshRequest request){
		String requestRefreshToken = request.getRefreshToken();
		
		return refreshTokenService.findByToken(requestRefreshToken)
				.map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser)
				.map(user -> {
					String token = jwtUtils.generateTokenFromUsername(user.getUsername());
					return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}
}
