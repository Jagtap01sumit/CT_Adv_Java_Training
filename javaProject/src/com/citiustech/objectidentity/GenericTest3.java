
public class GenericTest3 {
	
	//Generic Programming
	//Type Erase:replacing T by Objet
	public static <T>T select(int sign, T first,T second) {
		if(sign>0)
			return first;
		return second;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss= select(9,"Monday","Tuesday");
		System.out.printf("Selected string =%s%n",ss);
		
		double sd= select(-7,4.0,5.0);
		System.out.printf("Selected double =%s%n",sd);
		
		Interval si= select(5,new Interval(4,50),new Interval(2,40));
		System.out.printf("Selected double =%s%n",si);
	}
	
	
}
