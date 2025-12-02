package com.intellibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellibank.entity.MobilePayment;

public interface MobilePaymentRepository extends JpaRepository<MobilePayment, Long> {

}
