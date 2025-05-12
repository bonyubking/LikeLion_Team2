package com.workshop7.num07;

public class Sales extends Employee{

	
		public Sales(){
			super();
		}
		
		public Sales(String name, int number, String department, int salary) {
			super(name, number, department, salary);

		}

		
		@Override
		public void incentive(int pay) {
				this.setSalary(this.getSalary() + (int)(pay * 1.2)); 
		}

		@Override
		public double tax() {
	        return this.getSalary() * 0.13; 
		}
		
		
		
}
