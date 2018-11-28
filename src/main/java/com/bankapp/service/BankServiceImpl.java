package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.BankDAO;
import com.bankapp.dao.BankDAOImpl;
import com.bankapp.entities.AccountUserDetail;
import com.bankapp.entities.Transaction;
import com.bankapp.entities.User;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDAO bankDao;
	
	@Transactional
	public List<AccountUserDetail> getAccountUserDetailList() {
		
		return bankDao.getAccountUserDetailList();
	}

	@Transactional
	public void saveAccountUserDetail(AccountUserDetail account) {
		
		 bankDao.saveAccountUserDetail(account);
	}

	@Transactional
	public boolean updateBalance(double amount, int accountId, boolean transactionType) {
		
		return bankDao.updateBalance(amount, accountId, transactionType);
	}

	@Transactional
	public AccountUserDetail getAccountUserDetail(int accountId) {
		
		return bankDao.getAccountUserDetail(accountId);
	}

	@Transactional
	public void updateAccount(AccountUserDetail detail) {
		bankDao.updateAccount(detail);
		
	}

	@Transactional
	public void saveTransaction(String transactionType, String currentDateTime, int accountId, double amount) {

		bankDao.saveTransaction(transactionType, currentDateTime, accountId, amount);
	}

	@Transactional
	public List<Transaction> getTransactionDetail(int accountId) {
		
		return bankDao.getTransactionDetail(accountId);
	}

}
