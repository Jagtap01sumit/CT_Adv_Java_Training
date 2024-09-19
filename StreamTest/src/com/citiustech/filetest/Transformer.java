package com.citiustech.filetest;
 
public class Transformer {
	public static void transform(byte[] buffer, int count) {
		for(int i = 0; i < buffer.length; i++) {
			buffer[i] = (byte) (buffer[i] ^ '#');
		}
	}
}