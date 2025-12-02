package com.intellibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellibank.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
