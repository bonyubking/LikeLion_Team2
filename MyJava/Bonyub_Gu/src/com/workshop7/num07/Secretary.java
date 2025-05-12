package com.workshop7.num07;

public class Secretary extends Employee {
	
	public Secretary() {
		
		super();
	}
	
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);

	}
	
	@Override
	public void incentive(int pay) {
			
        this.setSalary(this.getSalary() + (int)(pay * 0.8));
	}

	@Override
	public double tax() {
        return this.getSalary() * 0.1;
	}
	
}
