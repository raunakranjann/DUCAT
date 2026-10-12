//package com.example.demo.service;
//
//import java.util.List;
//
//import com.example.demo.entity.*;
//
//public class UserService {
//
//	private static List list = new ArrayList<>();
//	static {
//		User u = new User("Ram");
//		list.add(u);
//		u = new User("Sita");
//		list.add(u);
//		u=new User("Gita");
//		list.add(u);
//	}
//	public list getList() {
//		return list;
//	}
//	
//}
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service("my") // Tells Spring to register this bean with the name "my"
public class UserService {

	private static List<User> list = new ArrayList<>();
	
	static {
		User u = new User("Ram");
		list.add(u);
		u = new User("Sita");
		list.add(u);
		u = new User("Gita");
		list.add(u);
	}
	
	public List<User> getList() {
		return list;
	}
}