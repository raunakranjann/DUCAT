package com.ducat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {

	@GetMapping("/")
	public String StudentPage() {
		return "student";
	}
	
	@PostMapping("/student")
	public String student(@RequestParam String studentname, @RequestParam String coursename, @RequestParam int studentmarks, Model model ) {
		
		
	if(studentmarks >=0 && studentmarks <=100) {

		String grade;
		
		if(studentmarks>90 && studentmarks<=100) {
			grade = "Grade : A";
			
		}else if (studentmarks>50 && studentmarks<=90) {
			grade = "Grade : B";
			
		}else if(studentmarks>=0 && studentmarks<=50){
			grade = "Grade : Fail";
		}else {
			grade = "Not Available";
		}
		
		
		model.addAttribute("StudentName", studentname);
		model.addAttribute("CourseName", coursename);
		model.addAttribute("ObtainedGrade",grade);
		
		
		return "Dashboard";
		
	}else {
		model.addAttribute("message", "Enter a Valid Marks");
		
		return "Student";
	}
		
	}
	
	
	
	
}
