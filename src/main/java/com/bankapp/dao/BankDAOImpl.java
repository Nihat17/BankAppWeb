package com.bankapp.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;
import com.bankapp.entities.User;
import com.bankapp.entities.AccountUserDetail;
import com.bankapp.entities.Transaction;;

@Repository
public class BankDAOImpl implements BankDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	public List<AccountUserDetail> getAccountUserDetailList() {
		Session session = sessionFactory.getCurrentSession();
		 
		Query getUserDetail  = 
				session.createQuery("SELECT new com.bankapp.entities."
						+ "AccountUserDetail(u.firstName, u.lastName, a.account_id, a.balance)"
						+ " FROM Account a join a.users u WHERE u.user_id = a.account_id");
		
		List<AccountUserDetail> list = getUserDetail.getResultList(); 
		
		return list;
	}

	public void saveAccountUserDetail(AccountUserDetail accountUserDetail) {
		
		Session session = sessionFactory.getCurrentSession();
		
		User user = new User(accountUserDetail.getFirstName(), accountUserDetail.getLastName(),
				accountUserDetail.getSsn());
					
		Account account = new Account(accountUserDetail.getAccountType(), accountUserDetail.getBalance());
		
		session.saveOrUpdate(account);				
		
		account.addUser(user);
		
		session.saveOrUpdate(user);
				
	}

	public boolean updateBalance(double amount, int accountId, boolean transactionType) {
		
		Session session = sessionFactory.getCurrentSession();
				
		Account account = session.get(Account.class, accountId);
		
		boolean output = true;
		
		if(transactionType){
		
			logger.info("INSIDE updateBalance method: " + amount);
			logger.info("INSIDE updateBalance method: " + (account.getBalance() - amount));
			
 			if((account.getBalance() - amount) > 0){
				account.setBalance(round(account.getBalance() - amount));
				
				output = true;
				
				session.update(account);
			}
 			
 			else 
 				output = false;
		}
		else{
			
			account.setBalance(round(account.getBalance() + amount)); 
		}
				
		return output;
		
	}

	public AccountUserDetail getAccountUserDetail(int accountId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query getDetails = 
				session.createQuery("SELECT new com.bankapp.entities.AccountUserDetail("
						+ "u.firstName, u.lastName, u.ssn, a.account_id, a.type, a.balance) "
						+ "FROM Account a join a.users u WHERE  u.user_id = a.account_id AND "
						+ "a.account_id = :accountId");
		
		AccountUserDetail details = (AccountUserDetail)
				getDetails.setParameter("accountId", accountId).getSingleResult();
		
		return details;
	}

	public void updateAccount(AccountUserDetail detail) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("UPDATE User u SET u.firstName = :firstName,"
				+ " u.lastName = :lastName, u.ssn = :ssn WHERE u.user_id = :userId");
		
		query.setParameter("firstName", detail.getFirstName());
		query.setParameter("lastName", detail.getLastName());
		query.setParameter("ssn", detail.getSsn());
		query.setParameter("userId", detail.getAccountId());
		
		query.executeUpdate();
	}

	public void saveTransaction(String transactionType, String currentDateTime,
			int accountId, double amount) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Account account = session.get(Account.class, accountId);
		
		Transaction transaction = 
				new Transaction(transactionType, currentDateTime, accountId, amount);
				
		account.addTransaction(transaction);
		
		session.saveOrUpdate(account);
			
	}
	
	public static double round(double value) {
	    if (2 < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public List<Transaction> getTransactionDetail(int accountId) {
		
		Session session = sessionFactory.getCurrentSession();
		
	/*	Query query = session.createQuery("SELECT t.type, t.amount, t.dateTime"
				+ " FROM Transaction t WHERE t.accountId = :accountId"); */
		
		Query query = session.createQuery("FROM Transaction t WHERE t.accountId = :accountId");
		
		query.setParameter("accountId", accountId);
		
		List<Transaction> transactionList = query.getResultList();
		
		for(Transaction trans : transactionList){
			logger.info("Transaction: " + trans);
		}
		
		return transactionList;
	}

}
