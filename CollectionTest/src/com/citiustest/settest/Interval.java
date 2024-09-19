package com.citiustest.settest;

public class Interval implements Comparable<Interval>{
	
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
		
		public int hashCode() {
			return 60*mins+secs;
		}
		public boolean equals(Object other) {
			if(other instanceof Interval) {
				Interval that = (Interval) other ;
				return this.mins==that.mins && this.secs==that.secs;
			}
			return false;
		}

		@Override
		public int compareTo(Interval other) {
			// TODO Auto-generated method stub
			return this.time() -other.time();
		}
		


	

		
}
 