package com.ducat.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.Model.Account;



@RestController
@RequestMapping("/account")
public class AccountController {

	@PostMapping("/create")
	public String createAccount(@RequestBody Account account) {
		return "Account created for "+account.getName()+",Balance:"+account.getBalance();
			
		
	}
}
