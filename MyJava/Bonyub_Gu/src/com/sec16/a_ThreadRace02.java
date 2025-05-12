package com.sec16;

public class a_ThreadRace02 {

	public static void main(String[] args) {
		
		String[] runners = { "고양이" , "강아지", "병아리", "토끼" , "거북이"};
		
		for (String name : runners) {
			
			new Racer(name).start();
		}
	}
	
	
	

}

class Racer extends Thread{
	
	private static int rank = 1;
	
	public Racer(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
	     
		for (int i = 1; i <= 5; i++) {
	            System.out.println(getName() + " 달리는 중 ♂️: " + i + "미터");
	            try {
	                Thread.sleep((int)(Math.random() * 400 + 100)); // 100~500ms 랜덤 지연
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        synchronized (Racer.class) {
	            System.out.println("🎉 " + getName() + " 도착! 순위: " + rank++);
	        }
	
		super.run();
	}
}