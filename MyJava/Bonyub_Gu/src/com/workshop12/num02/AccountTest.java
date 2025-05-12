package com.workshop12.num02;

public class AccountTest {

	public static void main(String[] args) {
		
		Account acc = new Account("441-0290-1203",500000,7.3);
		
		System.out.printf("계좌정보 : %s %.1f %.1f\n", acc.getAccount(), acc.getBalance(), acc.getInterestRate());

		try {
			acc.deposit(-10);
            System.out.println("입금 후 잔액: " + acc.getBalance());
		} catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
		
		try {
			acc.withdraw(600000);
            System.out.println("출금 후 잔액: " + acc.getBalance());
		} catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
		
		System.out.printf("이자 : %.1f", acc.calculateInterest());
	}
	

}
