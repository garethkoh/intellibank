package com.intellibank.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long userId;
	
	@Column(name="name")
	public String name;
	
	@Column(name="email", unique=true)
	public String email;
	
	@Column(name="mobile_number")
	public String mobileNumber;
	
	@Column(name="password_hash")
	public String passwordHash; // store hashed pw
	
    @Column(name="role")
	public String role;

	@Column(name="is_verified")
	public boolean isVerified;
	
    
    @OneToMany(mappedBy = "user")
    public List<Account> accounts;

	@Transient
	private String password;

    // TODO: getters and setters, constructor
	//Getter,Setters
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(boolean verificationStatus) {
		this.isVerified = verificationStatus;
	}

    public void addAccount(Account account) {
        accounts.add(account);
    }
 
	
	//Constructors
	public User(int userId, String name, String email, String mobileNumber, String passwordHash, String role, boolean isVerified) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.passwordHash = passwordHash;
		this.role = role;
		this.isVerified = isVerified;
	}
	
	public User() {
		
	}
}