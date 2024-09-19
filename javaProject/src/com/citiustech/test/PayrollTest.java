package com.citiustech.test;

import java.util.Scanner;


import com.citiustech.payroll.Department;
import com.citiustech.payroll.Employee;
import com.citiustech.payroll.*;
import com.citiustech.payroll.HiringPositionFilledExeption;
public class PayrollTest {
    public static void main(String[] args) {
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        Department[] departments = new Department[10]; 
        int deptCount = 0;
        
        do {
            System.out.println("1. Add Department");
            System.out.println("2. Show Departments");
            System.out.println("3. Hire Employee");
            System.out.println("4. Display Net Income of Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                	System.out.print("Enter department name: ");
                	String deptName = sc.nextLine();
                	System.out.print("Enter department location: ");
                	String deptLocation = sc.nextLine();
                	System.out.print("Enter department size: ");
                	int deptSize = sc.nextInt();
                	sc.nextLine();

                	boolean deptExists = false;
                	for (int i = 0; i < deptCount; i++) {
                	    if (departments[i].getDeptName().toUpperCase().equals(deptName.toUpperCase())) {
                	        System.out.println("Department already exists!");
                	        deptExists = true;
                	        break;
                	    }
                	}

                	if (!deptExists) {
                	    departments[deptCount] = new Department(deptSize, deptName, deptLocation);
                	    System.out.println("Department added successfully!");
                	    deptCount++;
                	}
                case 2:
                    for (int i = 0; i < deptCount; i++) {
                        System.out.println(departments[i].toString());
                    }
                    break;
                case 3:
                    System.out.print("Enter employee name: ");
                    String empName = sc.nextLine();
                    System.out.print("Enter employee hours: ");
                    int hours = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter employee rate: ");
                    float rate = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Department Names:");
                    int count=1;
                    for(Department dept:departments) 
                    {if(dept!=null) {
                    	System.out.println(count +" "+dept.getDeptName());
                    	count++;
                    }
                    }
                    System.out.print("Enter department name: ");
                    String empDeptName = sc.nextLine();

                    boolean deptFound = false;
                    for (int i = 0; i < deptCount; i++) {
                        if (departments[i].getDeptName().toUpperCase().equals(empDeptName.toUpperCase()
                        		)) {
                            Employee emp = new Employee(empName, hours, rate);
                            try {
                                departments[i].hireEmployee(emp);
                                deptFound = true;
                                break;
                            } catch (HiringPositionFilledExeption e) {
                                System.out.println(e.getMessage());
                            }
                            deptFound = true;
                            break;
                        }
                    }

                    if (!deptFound) {
                        System.out.println("Department not found. Please choose from this!!");
                        int val=1;
                        for(Department dept:departments) 
                        {if(dept!=null) {
                        	System.out.println(val +" "+dept.getDeptName());
                        	val++;
                        }
                        }
                    }

                    break;
                case 4:
                  
                    System.out.print("Enter department name: ");
                    String deptname = sc.nextLine();
                    
                    
                    for (int i = 0; i < deptCount; i++) {
                        if (departments[i].getDeptName().toUpperCase().equals(deptname.toUpperCase())) {
                            Employee[] employees = departments[i].getEmployees();
                            int netInc=0;
                            for(Employee emp : employees) {
                            	if(emp!=null) {
                            	netInc+=emp.netIncome();
                            	}
                            }
                            System.out.printf("Net Income for %s department is %d%n",deptname,netInc);
                            break;
                        }
                    }

                    break;
                case 5:
                    check = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (check);
        
        
    }
}
