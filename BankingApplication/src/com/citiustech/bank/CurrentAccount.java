package com.citiustech.bank;

 class CurrentAccount extends Account{

	@Override
	public void withdraw(double amount) throws InsufficientFundsException {
		// TODO Auto-generated method stub
		balance=-amount;
	}

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		if(balance<0) amount*=0.9;
		balance+=amount;
	}
		
}
