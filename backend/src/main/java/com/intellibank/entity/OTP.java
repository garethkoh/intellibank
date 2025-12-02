package com.intellibank.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class OTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
    private User user;
    
	@Column(name="otp", nullable = false)
    private String otp;
    
	@Column(name="expiry_time", nullable = false)
    private LocalDateTime expiryTime;
	
	@Column(name="is_verified", nullable = false)
    private boolean isVerified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean verified) {
		this.isVerified = verified;
	}
    
    
}
