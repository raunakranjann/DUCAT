package com.raunak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.raunak.Model.Student;

import jakarta.validation.Valid;

@Controller
public class StudentController {

	
	@GetMapping("/")
	public String StudentPage(Model model) {
		
		model.addAttribute("student", new Student());
		return "student";
	}
	
	@PostMapping("/student")
	public String validateStudent(@Valid Student student, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			return "student";
		}
		
		model.addAttribute("Student",student);
		model.addAttribute("success", "Validated User");
		return "result";
		
	}
	
	
	
	
}
