package com.citiustech.filetest;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
	
	public static void getAllDept(Department[] dept) {
		for (Department depts : dept) {
			if (depts != null) {
				System.out.println(depts.toString()); 
			}
		}
	}
	
	public static void getAllDeptId(Department[] dept) {
		for (Department depts : dept) {
			if (depts != null) {
				System.out.printf("Department ID: %s \t",depts.getDeptId()); 
				System.out.printf("Department Name: %s%n",depts.getDeptName()); 
			}
		}
	}

	public static void main(String[] args) {
		
		Department[] dept = new Department[10];
		int i = 0;

		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("Enter Your Choice : ");
			System.out.println("1. Add a Department\n2. Print Departments\n3.Exit");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					if (i < dept.length) {
						System.out.println("Enter Name of the Department: ");
						String deptName = sc.next();
						System.out.println("Enter Location of the Department: ");
						String deptLoc = sc.next();
						System.out.println("Enter Number of Employees in Department: ");
						int deptSize = sc.nextInt();
						
						dept[i] = new Department(deptName, deptLoc, deptSize);
						
						int empch;
						do {
							System.out.println("1. Add Employee\n2. Print Employee\n3.Store Department Object \n4. Exit");
							empch = sc.nextInt();
							
							switch (empch) {
								case 1:
									System.out.println("Enter Name of the Employee: ");
									String name = sc.next();
									System.out.println("Enter Salary of the Employee: ");
									double sal = sc.nextDouble();
									Employee emp = new Employee(name,sal);
									System.out.println(emp);
									if(dept[i].hireEmployee(emp)) {
										System.out.println("Employee added successfully.\n");
									}
									else {
										System.out.println("Cannot hire any more employees.\n");
									}
									break;
								case 2:
									dept[i].printEmp();
									break;
								case 3:
								    try {
								        FileOutputStream fos = new FileOutputStream("departments.dat");
								        ObjectOutputStream oos = new ObjectOutputStream(fos);
								        
								        for (Department depts : dept) {
								            if (depts != null) {
								                oos.writeObject(depts);
								            }
								        }
								        
								        oos.close();
								        fos.close();
								        
								        System.out.println("Department objects stored successfully.");
								    } catch (Exception e) {
								        System.out.println("Error storing department objects: ");
								    }
								    break;
								case 4:
									System.out.println("Exiting Employee menu.");
									break;
								default:
									System.out.println("Invalid Choice");
							}
						} while (empch != 4);
						
						i++;
					} else {
						System.out.println("Department list is full.");
					}
					break;
					
				case 2:
					int pdept;
					int pdeptId;
					do {
						System.out.println("1.Print Specific Department \n2.Print All Departments \n3.Exit");
						pdept = sc.nextInt();
						switch(pdept) {
						case 1:
							getAllDeptId(dept);
							System.out.println("Enter Department ID : ");
							pdeptId = sc.nextInt();
							System.out.println(dept[pdeptId-1].toString());	
							break;
						
						case 2:
							getAllDept(dept);
							break;
							
						case 3:
							System.out.println("Exiting Department menu.");
						}
					}while(pdept != 3);
					
					
				case 3:
					System.out.println("Exiting program.");
					break;
					
				default:
					System.out.println("Invalid Choice");
			}
			
		} while (choice != 3);

		sc.close();
	}
}

