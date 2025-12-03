package com.intellibank.service;

import org.springframework.stereotype.Service;

import com.intellibank.repository.AccountRepository;
import com.intellibank.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final AccountRepository accountRepository;
	
	public UserService(UserRepository userRepository, AccountRepository accountRepository) {
		super();
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
	}
	
	
}
