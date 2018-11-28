package com.bankapp.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountUserDetail {

	private int accountId;

	@Min(value = 5, message = "You must deposit at least 5$!")
	private double balance;

	@Size(min = 2, message = "Please fill the empty forms!")
	private String firstName, lastName, ssn;

	@NotNull(message = "Please choose one of the given account types!")
	private String accountType;

	public AccountUserDetail() {

	}

	public AccountUserDetail(String firstName, String lastName, int accountId, double balance) {
		this.accountId = accountId;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public AccountUserDetail(String firstName, String lastName, String ssn, double balance, String accountType) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.balance = balance;
		this.accountType = accountType;
	}

	public AccountUserDetail(String firstName, String lastName, String ssn, int accountId, String accountType,
			double balance) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;

	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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

	@Override
	public String toString() {
		return "AccountUserDetail [accountId=" + accountId + ", balance=" + balance + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", ssn=" + ssn + ", accountType=" + accountType + "]";
	}

}
