package com.ducat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

//	@GetMapping("/account")
//	public String getAccount(@RequestParam long accountId) {
	
		@GetMapping("/{accountId}")
		public String getAccount(@PathVariable long accountId) {
		
		return "Fetching account details for Account ID:"+accountId;
		
	}
}
