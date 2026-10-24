package com.raunak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.raunak.Model.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

	
	@GetMapping("/register")
	public String showForm(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		else {
		model.addAttribute("message","Registration Successfull");
		return "success";
		}
		
	}
}
