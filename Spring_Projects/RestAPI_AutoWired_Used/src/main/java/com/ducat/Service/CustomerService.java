package com.ducat.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.ducat.Entity.Customer;


@Service	
public class CustomerService {

	private static List list = new ArrayList<>();
	static 
	{
		Customer c = new Customer();
		c.setId(1L);
		c.setName("Ram");
		c.setAge(28L);
		c.setLocation("India");
		list.add(c);
		
		c = new Customer();
		c.setId(2L);
		c.setName("Sita");
		c.setAge(30L);
		c.setLocation("India");
		list.add(c);
		
		
	}
	
	public List getCustomerList() {
		return list;
		
	}
	
	
}
