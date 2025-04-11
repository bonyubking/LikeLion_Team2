package com.sec07.mytest02;

class Employee {
    private final String name; //재정의하지 않고 초기값만 가진 상수
    private final int salary; //재정의하지 않고 초기값만 가진 상수

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getDetails() {
        return "Name: " + name + "\nSalary: " + salary;
    }

    public void prn() {
        System.out.println("I'm an Employee");
    }
}

class Manager extends Employee {
    private final String department;

    public Manager(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public String getDetails() {
    	//return 현재 정보를 리턴함 
//        return "Name: " + getName() + "\nManager of: " + department;
    	return super.getDetails()+"\nManager of: " + department;
    }

    public void disp() {
        System.out.println("I'm a Manager");
    }
}

public class OverridingTest {
    public static void main(String[] args) {
        Employee emp = new Manager("John Doe", 5000, "IT");
        
        System.out.println(emp.getDetails()); // 동적 바인딩으로 Manager의 getDetails() 호출
        emp.prn(); // Employee의 prn() 호출

        
        if (emp instanceof Manager manager) {
            manager.disp();
        }
    }
}
