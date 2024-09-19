package com.citiustech.generics;
 
 
public class SimpleStack<V> {
    private V[] arr;
    private int track;
 
    public SimpleStack(int size) {
        arr = (V[]) new Object[size];
        track = -1;
    }
 
    public void push(String name) {
        if (track == arr.length - 1) {
        	System.out.println("Stack is full");
        }
        arr[++track] = (V) new Employee(name);
        display();
    }
 
    public V pop() {
        if (track == -1) {
        	System.out.println("Stack empty");
        }
        return arr[track--]; 
    }
 
    public V peek() {
        if (track == -1) {
            System.out.println("Stack empty");
        }
        return arr[track];
    }

 
    public void display() {
        for (int i = 0; i <= track; i++) {
            Employee employee = (Employee) arr[i];
            System.out.println("Name: " + employee.name);
           
    
        }
    }
}