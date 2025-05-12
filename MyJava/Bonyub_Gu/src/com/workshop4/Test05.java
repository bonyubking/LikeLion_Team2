package com.workshop4;

public class Test05 {

	public static void main(String[] args) {
		
		Student[] a1 = new Student[3];
		
		a1[0] = new Student("kim", 100, 90, 95, 89);
		a1[1] = new Student("Lee", 60, 70, 99, 98);
		a1[2] = new Student("Park", 68, 86, 60, 40);
		
		/*a1[0].setName("kim");
		*a1[0].setKorean(100);
		*a1[0].setMath(95);
		*
		*
		*public Student(String name, int korean, int english, int math, int science) {
		        this.name = name;
		        this.korean = korean;
		        this.english = english;
		        this.math = math;
		        this.science = science;
		    }
		*/
		

		for (int i=0; i<=2; i++) {
			System.out.println(a1[i].getName()+" 평균: "+a1[i].getAvg()+" 학점:"+a1[i].getGrade()+"학점");
		}
	}

}
