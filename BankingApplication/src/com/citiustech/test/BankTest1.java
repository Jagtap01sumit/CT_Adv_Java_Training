package com.citiustech.test;

import com.citiustech.bank.Account;
import com.citiustech.bank.CurrentAccount;
import com.citiustech.bank.InsufficientFundsException;
import com.citiustech.bank.SavingsAccount;

public class BankTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account sacc = new SavingsAccount();
		Account cacc = new CurrentAccount();;
		
		sacc.deposit(40000);
		
		System.out.printf("Intial balance for sacc with id %d= %.2f%n",sacc.id(),sacc.balance() );
		System.out.printf("Initial balance for cacc with id %d = %.2f%n", cacc.id(),cacc.balance());
		
		try {
			sacc.transfer(7000, cacc);
		}catch(InsufficientFundsException e) {
			System.out.println("ERROR: Transfer failed due to lack of funds!");
		}
		

		System.out.printf("Intial balance for sacc with id %d= %.2f%n",sacc.id(),sacc.balance() );
		System.out.printf("Initial balance for cacc with id %d = %.2f%n", cacc.id(),cacc.balance());
		
	}

}
