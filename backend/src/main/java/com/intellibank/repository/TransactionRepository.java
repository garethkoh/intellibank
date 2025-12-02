package com.intellibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellibank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}

