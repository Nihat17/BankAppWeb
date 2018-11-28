package com.bankapp.dao;

import java.util.List;

import com.bankapp.entities.AccountUserDetail;
import com.bankapp.entities.Transaction;
import com.bankapp.entities.User;

public interface BankDAO {
	public List<AccountUserDetail> getAccountUserDetailList();
	
	public void saveAccountUserDetail(AccountUserDetail account);

	public boolean updateBalance(double amount, int accountId, boolean transactionType);

	public AccountUserDetail getAccountUserDetail(int accountId);

	public void updateAccount(AccountUserDetail detail);

	public void saveTransaction(String transactionType, String currentDateTime, int accountId, double amount);

	public List<Transaction> getTransactionDetail(int accountId);
}
