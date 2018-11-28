package com.bankapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankapp.entities.AccountUserDetail;
import com.bankapp.entities.Transaction;
import com.bankapp.service.BankService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

	private int accountId;
	
	@Autowired
	private BankService bankService;
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/depositForm")
	public String depositForm(@RequestParam("accountId") int accountId, Model model){
		
		this.accountId = accountId;
		
		AccountUserDetail account = new AccountUserDetail();
		
		model.addAttribute("account", account);
			
		return "deposit";	// deposit jsp
	}
	
	@PostMapping("/depositTransaction")
	public String depositTransaction(@Valid @ModelAttribute("account")
			AccountUserDetail account, BindingResult result){		
		
		logger.info(">>>> INSIDE DEPOSIT TRANSACTION");
		
		if(result.getErrorCount() == 2){
			
			return "deposit";
		}
		
		updateBalance(account.getBalance(), false);
		
		// we send the amount as parameter
		bankService.saveTransaction("deposit", getCurrentDateTime(), accountId, account.getBalance());
			 	
		return "redirect:/bankapp/home";
	}
	
	@GetMapping("/withdrawForm")
	public String showWithdrawForm(@RequestParam("accountId") int accountId, Model model){
		
		this.accountId = accountId;
		
		AccountUserDetail account = new AccountUserDetail();
		
		model.addAttribute("account", account);
		
		return "withdraw";
	}
	
	@PostMapping("/withdrawTransaction")
	public String withdrawTransaction(@Valid @ModelAttribute("account")
			AccountUserDetail account, BindingResult result, Model model){
		
		logger.info(">>>> INSIDE WITHDRAW TRANSACTION");
		
		do{ 
		
			if(result.getErrorCount() == 2){
					
				boolean error = true;
				model.addAttribute("withdrawError", error);
				
				return "withdraw";				
			}
						
			if(!updateBalance(account.getBalance(), true)){
				
				result.addError(
						new ObjectError("Not enough amount of balance error",
								"You don't have enough money on account to withdraw this amount"));
			}
			
			else{
			 	bankService.saveTransaction("withdraw", getCurrentDateTime(), accountId, account.getBalance());
		 	}
		
		}while(result.getErrorCount() == 2);
		// we send the amount as parameter
		
		return "redirect:/bankapp/home";
	}
	
	@GetMapping("/displayTransaction")
	public String displayTransaction(@RequestParam("accountId") int accountId,
			Model model){
		
		logger.info("ACCOUNTID IS RECEIVED: " + accountId);
		
		List<Transaction> listTransaction = new ArrayList<Transaction>();
		
		listTransaction = bankService.getTransactionDetail(accountId);
		
		logger.info(listTransaction);
		
		model.addAttribute("transactionDetail", listTransaction);
		
		return "transaction-table";
	}
	
	private boolean updateBalance(double amount, boolean transactionType) {		
		// Withdraw = true, deposit = false
		
		return bankService.updateBalance(amount, accountId, transactionType);
	}
	
	private String getCurrentDateTime() {
		
	    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		Calendar cal = Calendar.getInstance();
		
		return sdf.format(cal.getTime());
	}

}
