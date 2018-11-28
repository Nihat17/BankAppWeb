package com.bankapp.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {

	// define local fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "transaction_type")
	private String type;
	
	@Column(name = "date_time")
	private String dateTime;
	
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name = "amount")
	private double amount;
	
	// define constructors
	public Transaction(){
		
	}
	
	public Transaction(String type, String dateTime, int accountId, double amount) {
		this.type = type;
		this.dateTime = dateTime;
		this.accountId = accountId;
		this.amount = amount;
	}
	
	public Transaction(String type, double amount, String dateTime){
		this.type = type;
		this.amount = amount;
		this.dateTime = dateTime;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	// define getter/setters
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", type=" + type + ", dateTime=" + dateTime
				+ ", accountId=" + accountId + ", amount=" + amount + "]";
	}
	
}
