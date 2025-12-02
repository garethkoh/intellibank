package com.intellibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellibank.entity.BankTransfer;

public interface BankTransferRepository extends JpaRepository<BankTransfer, Long>{

}
