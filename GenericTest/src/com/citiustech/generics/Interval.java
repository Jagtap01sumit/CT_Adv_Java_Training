package com.citiustech.generics;

public class Interval implements Comparable<Interval> {
	
		private int mins;
		private int secs;
		
		public Interval(int m, int s) {
			mins= m+s/60;
			
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
			if(secs<10)return mins+":0"+secs;
			return mins+":"+secs;
		}

	
	

		@Override
		public int compareTo(Interval other) {
			// TODO Auto-generated method stub
			return this.time()-other.time();
		}

		
}
 