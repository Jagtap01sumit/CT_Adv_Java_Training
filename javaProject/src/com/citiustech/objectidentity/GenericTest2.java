

public class GenericTest2 {
	public static Object select(int sign, Object first,Object second) {
		if(sign>0)
			return first;
		return second;
	}
//its working but not type safe
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss=(String) select(9,"Monday","Tuesday");
		System.out.printf("Selected string =%s%n",ss);
		
		double sd=(double) select(-7,4.0,5.0);
		System.out.printf("Selected double =%s%n",sd);
		Interval si=(Interval) select(5,new Interval(4,50),new Interval(2,40));
		System.out.printf("Selected double =%s%n",si);
	}
	
	
}
