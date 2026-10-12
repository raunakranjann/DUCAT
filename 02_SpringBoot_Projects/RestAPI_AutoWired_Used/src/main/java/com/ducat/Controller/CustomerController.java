package com.ducat.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.Service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService cservice;
	
	@GetMapping("/customers")
	public List getList() {
		return cservice.getCustomerList();
	}
}
