//package com.citiustech.threadtest;
//
//
// class JointAccount{
//	int balance;
//	
//	public int balance() {
//		return balance;
//	}
//	public boolean withdraw(int amount) {
//		boolean success= false;
//		
//		if(balance>amount) {
//			Worker.doWork(amount/500);
//			balance -=amount;
//			success=true;
//		}
//		return success;
//	}
//	public void deposite(int amount) {
//		Worker.doWork(amount);
//		balance+=amount;
//	}
//}
//public class ThreadMonitoringTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JointAccount acc= new JointAccount();
//		System.out.println("Prathamesh and sumit opend JointAccount");
//		System.out.printf("Initial balance = %d%n",acc.balance());
//
//		acc.deposite(5000);
//		System.out.printf("Initial balance = %d%n",acc.balance());
//		
//		Thread child = new Thread(()->{
//			System.out.println("Prathmesh withdraw's 3000");
//			if(acc.withdraw(3000)==false) {
//				System.out.println("Prathmesh withdraw failed");
//			}
//		});
//		child.start();
//		System.out.println("Sumit withdraow's 4000");
//		if(acc.withdraw(4000)==false) {
//			System.out.println("Sumit withdraw failed");
//		}
//		System.out.printf("Final balance=%d%n",acc.balance());
//	}
//
//}

package com.citiustech.threadtest;


 class JointAccount{
	int balance;
	
	public int balance() {
		return balance;
	}
	public boolean withdraw(int amount) {
		boolean success= false;
		
		synchronized(this){if(balance>amount) {//we make this block to a synchronized so only one thread can execute whenever it ends then next can enter
			Worker.doWork(amount/500);
			balance -=amount;
			success=true;
		}
		}
		return success;
	}
	public synchronized void  deposite(int amount) {//we make this method synchronized ....it bad practice when the method is so huge ....so we mostly use block synchronied
		Worker.doWork(amount);
		balance+=amount;
	}
}
public class ThreadMonitoringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JointAccount acc= new JointAccount();
		System.out.println("Prathamesh and sumit opend JointAccount");
		System.out.printf("Initial balance = %d%n",acc.balance());

		acc.deposite(5000);
		System.out.printf("Initial balance = %d%n",acc.balance());
		
		Thread child = new Thread(()->{
			System.out.println("Prathmesh withdraw's 3000");
			if(acc.withdraw(3000)==false) {
				System.out.println("Prathmesh withdraw failed");
			}
		});
		child.start();
		System.out.println("Sumit withdraow's 4000");
		if(acc.withdraw(4000)==false) {
			System.out.println("Sumit withdraw failed");
		}
		System.out.printf("Final balance=%d%n",acc.balance());
	}

}

