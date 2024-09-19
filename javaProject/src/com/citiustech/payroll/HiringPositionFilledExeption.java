package com.citiustech.payroll;


	public class HiringPositionFilledExeption extends RuntimeException {
	    public HiringPositionFilledExeption() {
	        super("Error: Department is full. Cannot hire more employees.");
	    }
	}

