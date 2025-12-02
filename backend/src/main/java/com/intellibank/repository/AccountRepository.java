package com.intellibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellibank.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
