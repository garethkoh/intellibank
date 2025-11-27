package com.intellibank.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name="senderAccountId", nullable = false)
    private Long senderAccountId;
    
    @Column(name="recipientName", nullable = false)
    private String recipientName;
    
    @Column(name="amount", nullable = false)
    private Double amount;
    
    @Column(name="type", nullable = false)
    private String type;		// UPI or BANK
    
    @Column(name="status", nullable = false)
    private String status;		//	PASS or FAIL
    
    @Column(name="note")
    private String note;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    
    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    @JsonManagedReference
    private UpiPayment upiPayment;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    @JsonManagedReference
    private BankTransfer bankTransfer;

    // Getters and setters for upiPayment and bankTransfer
    
    public UpiPayment getUpiPayment() {
		return upiPayment;
	}

	public void setUpiPayment(UpiPayment upiPayment) {
		this.upiPayment = upiPayment;
	}

	public BankTransfer getBankTransfer() {
		return bankTransfer;
	}

	public void setBankTransfer(BankTransfer bankTransfer) {
		this.bankTransfer = bankTransfer;
	}

    // Getters and Setters

    public Long getTransactionId() {
        return transactionId;
    }

	public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    
    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
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
        if (!type.equals("UPI") && !type.equals("BANK")) {
            throw new IllegalArgumentException("Transaction type must be 'UPI' or 'BANK'");
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