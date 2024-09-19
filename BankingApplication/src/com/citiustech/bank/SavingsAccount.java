package com.citiustech.bank;

class SavingsAccount extends Account implements Profitable{
	
	
	static final double MIN_BALANCE=10000;
	  
	public void SavingAccount() {
		balance=MIN_BALANCE;
	}
	@Override
	public void withdraw(double amount) throws InsufficientFundsException {
		// TODO Auto-generated method stub
		if(balance - amount>MIN_BALANCE) {
			balance-=amount;
		}else {
			throw new InsufficientFundsException();
		}
	}
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		balance+=amount;
	}
	
	public void addInterest(int period) {
		balance+=period*1000;
	}
}
