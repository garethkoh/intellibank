package com.intellibank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "mobile_payment")
public class MobilePayment extends Transaction{

    @OneToOne
    @JoinColumn(name = "transaction_id")
    @JsonBackReference
    private Transaction transaction;

    private String recipientMobileNumber;

    // Getters and setters

    public Long getRecipientMobileNumber() { return recipientMobileNumber; }
    public void setRecipientMobileNumber(String mobileNumber) { this.recipientMobileNumber = mobileNumber; }

    
    public Transaction getTransaction() { return transaction; }
    public void setTransaction(Transaction transaction) { this.transaction = transaction; }
}