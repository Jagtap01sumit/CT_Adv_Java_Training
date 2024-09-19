package com.citiustech.filetest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileStreamTest {

	public static void main(String[] args) {//dont throws exception. when we throw exception from main it will handle by jvm but its bad way...never throws from main method
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	
		String inputFile= scan.next();
		String outputFile=scan.next();
		try(var input = new FileInputStream(inputFile)){
			try(var output = new FileOutputStream(outputFile)){
				byte[] buffer = new byte[80];
				while(input.available()>0) {
					int n = input.read(buffer,0,80);
					//Transformer
					Transformer.transform(buffer,n);
					output.write(buffer,0,n);
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
		//file chennel newio; in java
		
		//Employee id name sal ,getter setter
		
	}

}
