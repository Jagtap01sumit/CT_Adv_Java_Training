package com.citiustech.test;

import com.citiustech.bank.Account;
import com.citiustech.bank.Banker;
import com.citiustech.bank.Profitable;

public class BankTest4 {
	private static double totalBalance(Account[] accounts) {
		double total = 0;
		for(Account acc: accounts) {
			System.out.println(acc.getClass().getName());
			total+=acc.balance();
		}
		return total;
	}
	private static void payAnnualInterest(Account [] accounts) {
		for(Account account:accounts) {
			if(account instanceof Profitable) {
				Profitable p= (Profitable) account;
				p.addInterest(1);
			}
		}
	}
	public static void main(String [] args) {
		Account[] accounts = new Account[4];
		
		accounts[0]= Banker.openSavingsAccount();
		accounts[0].deposit(40000);
		accounts[1]= Banker.openCurrentAccount();
		accounts[1].deposit(60000);
		accounts[2]= Banker.openCurrentAccount();
		accounts[2].deposit(70000);
		accounts[3]= Banker.openSavingsAccount();
		accounts[3].deposit(70000);
		
		for(Account account:accounts) {
	
			System.out.printf("%.2f%n", account.balance());
			
		}
		System.out.printf("Total blaance = %.2f%n", totalBalance(accounts));
		
		payAnnualInterest(accounts);
		for (Account account : accounts) {
			System.out.printf("%.2f%n", account.balance());
		}
	}
}
