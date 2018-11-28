package com.bankapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {

	// start by defining fields	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int account_id;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "Balance")
	private double balance;
	
	// make the many to many relation between Account and User
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
				CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name = "Users_Accounts",
			joinColumns = @JoinColumn(name = "account_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")) 
	private List<User> users;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "account_id")
	private List<Transaction> transactions;
	
	public void addTransaction(Transaction transaction){
		
		if(transaction == null)
			transactions = new ArrayList<Transaction>();
		
		transactions.add(transaction);
	}
	
	public void addUser(User user){
		
		if(users == null)
			users = new ArrayList<User>();
		
		users.add(user);
	}
	
	// define constructors
	public Account(){
		
	}

	public Account(String type, double balance) {
		this.type = type;
		this.balance = balance;
	}
	
	public Account(String type, double balance, int accountId){
		this.type = type;
		this.balance = balance;
		this.account_id = accountId;
	}
	
	// define getter/setters
	public int getaccount_id() {
		return account_id;
	}

	public void setId(int account_id) {
		this.account_id = account_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	//define toString method
	@Override
	public String toString() {
		return "Account [id=" + account_id + ", type=" + type + ", balance=" + balance + ", users=" + users + "]";
	}

	
	
}
