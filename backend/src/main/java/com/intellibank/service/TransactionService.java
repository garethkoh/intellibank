package com.intellibank.service;

import org.springframework.stereotype.Service;

import com.intellibank.repository.BankTransferRepository;
import com.intellibank.repository.MobilePaymentRepository;
import com.intellibank.repository.TransactionRepository;

@Service
public class TransactionService {
	
	private final TransactionRepository transactionRepository;
	private final BankTransferRepository bankTransferRepository;
	private final MobilePaymentRepository mobilePaymentRepository;
	
	public TransactionService(TransactionRepository transactionRepository,
			BankTransferRepository bankTransferRepository, MobilePaymentRepository mobilePaymentRepository) {
		super();
		this.transactionRepository = transactionRepository;
		this.bankTransferRepository = bankTransferRepository;
		this.mobilePaymentRepository = mobilePaymentRepository;
	}
	
	
}
