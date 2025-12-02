package com.intellibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellibank.entity.OTP;

public interface OtpRepository extends JpaRepository<OTP, Long> {

}
