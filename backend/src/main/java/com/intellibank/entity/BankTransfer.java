package com.intellibank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_transfer")
public class BankTransfer extends Transaction{

    @OneToOne
    @JoinColumn(name = "transaction_id")
    @JsonBackReference
    private Transaction transaction;

    private Long recipientAccountId;

    // Getters and setters

    public Long getRecipientAccountId() { return recipientAccountId; }
    public void setRecipientAccountId(Long accountId) { this.recipientAccountId = accountId; }

    
    public Transaction getTransaction() { return transaction; }
    public void setTransaction(Transaction transaction) { this.transaction = transaction; }
}