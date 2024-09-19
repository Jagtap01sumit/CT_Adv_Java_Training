//package com.citiustech.reftest;
//
//public class ReflectionTest1 {
//	private static  void printAsXML(Item info) {
//		System.out.println("<Item>");
//		System.out.printf("  <name>%s</name>%n",info.name());
//		System.out.printf("  <brand>%s</brand>%n",info.brand());
//		
//		System.out.println("<Item>");
//
//	}
//	public static void main(String[] args) {
//		Item item=new Item("CPU","Intel");
//		printAsXML(item);
//		
//	}
//}
// 

package com.citiustech.reftest;
//now we can pass any Object through this method...its flexible..if any class having any number of fields it can aceess 
public class ReflectionTest1 {
	private static  void printAsXML(Object info) {
	var c = info.getClass();
	System.out.printf("<%s>%n",c.getSimpleName());
	var fields = c.getDeclaredFields();
	for(var f:fields) {
		System.out.printf("<%s>",f.getName());
		try {
			f.setAccessible(true);//can acess private fields also
			System.out.printf("%s",f.get(info));//its private
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.printf("</%s>%n",f.getName());
	}
	System.out.printf("</%s>%n",c.getSimpleName());
	}
	public static void main(String[] args) {
		Item item=new Item("CPU","Intel");
		printAsXML(item);
		Item item1= new Item("GPU","ID");
		printAsXML(item1);
		
	}
}
 