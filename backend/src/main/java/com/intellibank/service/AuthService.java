package com.intellibank.service;

import org.springframework.stereotype.Service;

import com.intellibank.dto.RegisterUserRequestDTO;
import com.intellibank.repository.OtpRepository;

@Service
public class AuthService {

	private final OtpRepository otpRepository;

	public AuthService(OtpRepository otpRepository) {
		this.otpRepository = otpRepository;
	}
	
	public void register(RegisterUserRequestDTO registerUerRequestDTO) {
		// TODO Auto-generated method stub
		
	}
	
	
}
