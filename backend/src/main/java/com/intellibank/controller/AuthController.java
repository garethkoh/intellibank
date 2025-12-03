package com.intellibank.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.intellibank.dto.RegisterUserRequestDTO;
import com.intellibank.dto.RegisterUserResponseDTO;
import com.intellibank.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	// register
	@PostMapping("/register")
	public ResponseEntity<RegisterUserResponseDTO> register(@RequestBody RegisterUserRequestDTO registerUerRequestDTO) {
		
		RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO();
		authService.register(registerUerRequestDTO);
		return ResponseEntity.ok(registerUserResponseDTO);
	}
	
	
	// login 
	
	// validate session (in original userController)
	
	// refresh token 
	
	// change password
	
	// forget password
}
