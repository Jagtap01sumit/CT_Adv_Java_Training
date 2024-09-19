package com.citiustech.threadtest;
class ChildThread extends Thread{
	public void run() {
		System.out.println("Child thread is running");
	}
}
class MyChildThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Child thread with runnable is running");
	}
	
}
public class ThreadTest1 {
	
	static String client;
	private static void handleJob(int job) {
		System.out.printf("Thread <%d> accepted job %d from client %s%n",Thread.currentThread().hashCode(),job,client);
		System.out.printf("Thread <%d> finished job %d from client %s%n",Thread.currentThread().hashCode(),job,client);

	}
	
	private static void begin() {
		System.out.println("Child thread with runnable is running");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		handleJob(4);
//		handleJob(7);
		//1. method to create thread;
//		Thread child = new ChildThread();
//		child.start();
//		System.out.println("Main thread is running");
		
		//2.second method to create thread
//		Thread child = new Thread(new MyChildThread());
//		child.start();
//		System.out.println("Main thread is running");
		
		//3. if you dont want to create a new class and implement runnable so then we can use annonomous class . so we dont need to create MyChildThread class
//		Thread child = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Child thread with anonymous is running!!");
//			}
//		});
		
		//4.using method refernece
//		Thread child = new Thread(ThreadTest1::begin);
//		child.start();
//		System.out.println("Main thread is running");
//
//		//5. using lambda expression   
		
	}

}
