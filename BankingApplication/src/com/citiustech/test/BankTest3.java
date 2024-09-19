package com.citiustech.test;

import com.citiustech.bank.Account;
import com.citiustech.bank.CurrentAccount;
import com.citiustech.bank.Profitable;
import com.citiustech.bank.SavingsAccount;

public class BankTest3 {
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
		
		accounts[0]= new SavingsAccount(); //here is problem => everyone can create new obj of savingaccount or any acc its visible to all user thus =>banktest4
		accounts[0].deposit(40000);
		accounts[1]= new CurrentAccount();
		accounts[1].deposit(60000);
		accounts[2]= new CurrentAccount();
		accounts[2].deposit(70000);
		accounts[3]= new SavingsAccount();
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
