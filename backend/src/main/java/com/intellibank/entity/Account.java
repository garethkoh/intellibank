package com.intellibank.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import com.profileManagement.entities.User;

@Entity
@Table(name="accounts")
public class Account {
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	public User user;
	
	@Id
	@Column(name="account_id", unique = true, nullable = false)
	public long accountId;
	
	@Column(name="account_balance")
	private double accountBalance;
	
    @Column(name="account_type")
    private String accountType;

	@Transient
	private Integer userId;
	
	
	public Account(User user, long accountId, double accountBalance, String accountType) {
		super();
		this.user = user;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}
	
	public Account() {}

	
	public Integer getAccountUserId() {
	    return user != null ? user.getUserId() : null;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
