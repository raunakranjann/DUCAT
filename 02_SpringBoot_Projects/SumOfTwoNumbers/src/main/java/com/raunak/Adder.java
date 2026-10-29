package com.raunak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adder")
public class Adder {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	ModelAndView dosum(@RequestParam("num1") int x, @RequestParam("num2") int y) {
		
		//processing 
		
		int z = x + y;
		ModelAndView mav = new ModelAndView();
		//Result is stored in the ModelAndView object 
		
		mav.addObject("sum", z);
		//viewName is stored in ModelAndView
		
		mav.setViewName("result");
		
		//ModelAndView object is returned 
		
		return mav;
		
		
	
	}
	
}
