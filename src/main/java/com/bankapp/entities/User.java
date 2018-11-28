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
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "SSN")
	private String ssn; // Social Security Number

	// make the many to many relation between Account and User
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
				CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "",
			joinColumns = @JoinColumn(name = "Users_Accounts"),
			inverseJoinColumns = @JoinColumn(name = "account_id"))
	private List<Account> accounts;

	
	public void addAccount(Account account){
		
		if(accounts == null){
			accounts = new ArrayList<Account>();			
		}
		accounts.add(account);
	}
	
	// define constructors
	public User() {

	}

	public User(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public User(String firstName, String lastName, String ssn, int userId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.user_id = userId;
	}
	
	// define getter/setters
	public int getuser_id() {
		return user_id;
	}

	public void setuser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Account> getAccounts() {
		
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		
		this.accounts = accounts;
	}

	// define toString method
	@Override
	public String toString() {
		return "User [id=" + user_id + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + "]";
	}

}
