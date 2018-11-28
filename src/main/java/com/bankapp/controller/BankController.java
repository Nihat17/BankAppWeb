package com.bankapp.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.bankapp.service.BankService;

@Controller
@RequestMapping("/bankapp")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	Logger myLogger = Logger.getLogger(getClass().getName(), null);

	private int accountId;
		 
	private AccountUserDetail accountUserDetail;
	
	@GetMapping("/home")
	public String buildHome(Model model){
		
		List<AccountUserDetail> accountUserDetailList = getAccountUserDetailList();
		
		myLogger.info("====>>>>> " + accountUserDetailList);
		
		model.addAttribute("accountUserDetail", accountUserDetailList);
		
		return "home-page";
	}

	private List<AccountUserDetail> getAccountUserDetailList() {
		
		return bankService.getAccountUserDetailList();
	}
	
	@GetMapping("/addAccount")
	public String addAccount(Model model){
		
		AccountUserDetail detail = new AccountUserDetail();
		
		model.addAttribute("detail", detail);
		
		return "add-account";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@Valid @ModelAttribute("detail") AccountUserDetail detail,
			BindingResult bindingResult, Model model){
       	        
		myLogger.info("++++++>>>>> INSIDE saveAccount method!!!");
		
		if(bindingResult.hasErrors()){
			
			return "add-account";
		}
		
		detail.setBalance(detail.getBalance());
		
		bankService.saveAccountUserDetail(detail);
		
		return "redirect:/bankapp/home";
	}
	
	@GetMapping("/displayAccount")
	public String displayAccount(@RequestParam("accountId") int accountId, Model model){
		
		// we gotta get the account user details from db
		AccountUserDetail details =
				bankService.getAccountUserDetail(accountId);
		
		model.addAttribute("detail", details);
		
		return "account-detail";
	}
	
	
	@PostMapping("/updateAccount")
	public String updateUserInfo(@ModelAttribute("detail") AccountUserDetail detail){
						
		bankService.updateAccount(detail);
		
		myLogger.info("INSIDE UPDADEUSERINFO>>>");
		
		return "redirect:/bankapp/home";
	}
	
}
