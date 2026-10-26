package com.ducat.Model;


public class Account {

	private String name;
	private String email;
	private double balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(String name, String email, double balance) {
		super();
		this.name = name;
		this.email = email;
		this.balance = balance;
	}
	
	
	
	
}
