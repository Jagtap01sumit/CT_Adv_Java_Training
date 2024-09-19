//package com.citiustech.threadtest;
//
//public class ThreadTest2 {
//	static String client;
//	private static void handleJob(int job) {
//		System.out.printf("Thread <%d> accepted job %d from client %s%n",Thread.currentThread().hashCode(),job,client);
//		Worker.doWork(job);
//		System.out.printf("Thread <%d> finished job %d from client %s%n",Thread.currentThread().hashCode(),job,client);
//
//	}
//	public static void main(String[] args) {
//		Thread child = new Thread(()->{
//			client="Jill";
//			handleJob(4);
//			
//		});
//		child.start();
//		client = "Jack";
//		handleJob(7);
//	}
//}

package com.citiustech.threadtest;

public class ThreadTest2 {
	static ThreadLocal<String> client= new ThreadLocal<>();//we just set client in localstorage of thread not in class . 
	private static void handleJob(int job) {
		System.out.printf("Thread <%d> accepted job %d from client %s%n",Thread.currentThread().hashCode(),job,client.get());
		Worker.doWork(job);
		System.out.printf("Thread <%d> finished job %d from client %s%n",Thread.currentThread().hashCode(),job,client.get());

	}
	public static void main(String[] args) throws Exception {
		Thread child = new Thread(()->{
			client.set("Jill");
			handleJob(7);
			
		});
		child.setDaemon(true);
		child.start();
		
		
		client.set("Jack");
		handleJob(4);
		child.join();//dont terminate a thread whereever the child will terminate....when child dies then only terminate the thread ....just join me with the child threde ...but dont shedule main thread .
	}
}
