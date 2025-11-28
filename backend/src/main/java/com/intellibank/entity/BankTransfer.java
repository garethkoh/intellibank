package com.intellibank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("BANK")
@Table(name = "bank_transfer")
public class BankTransfer extends Transaction{

    @Column(name = "receiver_account_number", nullable = false)
    private Long recipientAccountId;

    public BankTransfer() {}

    public BankTransfer(Account senderAccount, Account receiverAccount, String recipientName, Double amount, String status, String note, Long recipienctAccountId) {
        super(senderAccount, receiverAccount, recipientName, amount, status, note);
        this.recipientAccountId = recipienctAccountId;
    }

    // Getters and setters
    public Long getRecipientAccountId() { return recipientAccountId; }
    public void setRecipientAccountId(Long accountId) { this.recipientAccountId = accountId; }
}