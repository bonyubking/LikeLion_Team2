package com.workshop12.num02;

public class Account {

	private String account;
	private double balance;
	private double interestRate;
	
	public Account() {
		
	}

	public Account(String account, double balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public double calculateInterest() {
		
		return balance * interestRate / 100;
	}
	
	public void deposit(double money) {
		
		if (money < 0) {
            throw new IllegalArgumentException("입금액이 0보다 작습니다.");}

		balance = balance + money;
				
	}
	
	public void withdraw(double money) {
		
		if (money > balance) {
            throw new IllegalArgumentException("잔액이 부족합니다.");}
		
		balance = balance - money;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	

}
