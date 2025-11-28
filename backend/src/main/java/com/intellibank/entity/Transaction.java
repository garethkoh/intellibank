package com.intellibank.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.JOINED) // or SINGLE_TABLE
@DiscriminatorColumn(name = "type") // MOBILE or BANK
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_account_id", nullable = false)
    private Account senderAccount;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_account_id", nullable = false)
    private Account receiverAccount;
    
    @Column(name="recipientName", nullable = false)
    private String recipientName;
    
    @Column(name="amount", nullable = false)
    private Double amount;
    
    @Column(name="status", nullable = false)
    private String status;		//	PASS or FAIL
    
    @Column(name="note")
    private String note;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    

    public Transaction() {}

    public Transaction(Account senderAccount, Account receiverAccount, String recipientName, Double Amount, String status, String note) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.recipientName = recipientName;
        this.amount = amount;
        this.status = status;
        this.note = note;
        this.timestamp = LocalDateTime.now();
    }
    // Getters and Setters

    public Long getTransactionId() {
        return transactionId;
    }

	public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    
    public Long getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccountId(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Long getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Long getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (!type.equals("MOBILE") && !type.equals("BANK")) {
            throw new IllegalArgumentException("Transaction type must be 'MOBILE' or 'BANK'");
        }
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
    	if (!status.equals("PASS") && !status.equals("FAIL")) {
            throw new IllegalArgumentException("Transaction status must be 'PASS' or 'FAIL'");
        }
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}