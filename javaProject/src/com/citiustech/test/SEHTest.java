package com.citiustech.test;

class NameNotFoundException extends Exception{}//checked exeption=> compiler inforces to to use try catch or hadle exeption.
class InvalidNameException extends RuntimeException{};//unchecked exeption => automatically propogate exeption and not inforce to create try catch block
public class SEHTest {
	private static String [] names = {"Jack","Jill","John","Jeff"};
	private static double [] balance = {2000,4000,6000,8000};
	
	private static int search(String name)throws NameNotFoundException {
		int index=0;
		
		if(name.length()<4) throw new InvalidNameException();
		
		for(String value: names) {
			if(value==name) return index;
			index++;
		}
		throw new NameNotFoundException();
	}
	private static void run(String name) {
		
		try {
		int index= search(name);
		System.out.printf("Balance = %.2f%n", balance[index]);
		}catch(NameNotFoundException e) {
			System.out.printf("%s not found %n", name);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("resourse allocation");
		try {
			
			run("Jil");
		}catch(InvalidNameException e) {
			System.out.println("Invalid name");
		}catch(Exception e) {
			System.out.println("Unkown error");
		}finally {
			System.out.println("resourse released");
		}
		
		
	}

}
