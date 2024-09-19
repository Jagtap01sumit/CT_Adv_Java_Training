package com.citiustech.test;

import com.citiustech.bank.Account;
import com.citiustech.bank.CurrentAccount;
import com.citiustech.bank.Profitable;
import com.citiustech.bank.SavingsAccount;

public class BankTest2 {
	private static double totalBalance(Account[] accounts) {
		double total = 0;
		for(Account acc: accounts) {
			System.out.println(acc.getClass().getName());
			total+=acc.balance();
		}
		return total;
	}
	private static void payAnnualInterest(Account [] accounts) {
		for(Account account:accounts) {//when we add the method of addInterest in superclass Account=> it break a SRP .=> only the savingacc want intrest method so we cannot add this in super classs.
			//or when we add this method in savingAccount class then also it break SOLID Principle=> every method in the subclass want to be in a superclass.
			if(account instanceof SavingsAccount) { //here is problem=> its losely coupled => when there is new account like EmpAccount and it also have intrest then need to add new  if block . 
				SavingsAccount sacc= (SavingsAccount) account;//solution of this is in BankTest3=> interface.
				sacc.addInterest(1);
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
