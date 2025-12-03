package com.intellibank.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MOBILE")
@Table(name = "mobile_payment")
public class MobilePayment extends Transaction {

    @Column(name = "recipient_mobile_number", nullable = false)
    private String recipientMobileNumber;

    public MobilePayment() {}

    public MobilePayment(Account senderAccount, Account receiverAccount, String recipientName, Double amount, String status, String note, String mobileNumber) {
        super(senderAccount, receiverAccount, recipientName, amount, status, note);
        this.recipientMobileNumber = mobileNumber;
    }
    // Getters and setters
    public String getRecipientMobileNumber() { 
    	return recipientMobileNumber; 
    }
    public void setRecipientMobileNumber(String mobileNumber) { 
    	this.recipientMobileNumber = mobileNumber;
    }
}