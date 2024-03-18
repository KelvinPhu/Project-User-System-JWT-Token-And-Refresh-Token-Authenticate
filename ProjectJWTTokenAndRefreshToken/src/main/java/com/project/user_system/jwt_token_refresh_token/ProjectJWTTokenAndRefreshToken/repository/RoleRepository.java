package com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.EnumRole;
import com.project.user_system.jwt_token_refresh_token.ProjectJWTTokenAndRefreshToken.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(EnumRole name);
}
