package com.citiustech.listtest;

public class Interval {
	
		private int mins;
		private int secs;
		
		public Interval(int m, int s) {
			mins= m+s/60;
			secs=s%60;
			
		}
		
		public int minutes() {
			return mins;
		}
		public int seconds() {
			return secs;
		}
		public int time() {
			return 60*mins+secs;
		}
		
		public String toString() {
//			if(secs<10)return mins+":0"+secs;
			return mins+":0"+secs;
		}

	

		
}
 