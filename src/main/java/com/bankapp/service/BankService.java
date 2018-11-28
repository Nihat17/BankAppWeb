package com.bankapp.service;

import java.util.List;

import com.bankapp.entities.AccountUserDetail;
import com.bankapp.entities.Transaction;
import com.bankapp.entities.User;

public interface BankService {
	public List<AccountUserDetail> getAccountUserDetailList();

	public void saveAccountUserDetail(AccountUserDetail account);

	public boolean updateBalance(double amount, int accountId, boolean transactionType);

	public AccountUserDetail getAccountUserDetail(int accountId);

	public void updateAccount(AccountUserDetail detail);

	public void saveTransaction(String string, String currentDateTime, int AccountId, double amount);

	public List<Transaction> getTransactionDetail(int accountId);
	
}
