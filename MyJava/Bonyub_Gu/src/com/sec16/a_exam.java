package com.sec16;

public class a_exam implements Runnable{
	
	@Override
	public void run() {
		for (int i = 0; i<= 100; i ++) {
			
			System.out.println("나 쓰례드야");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		
		
		Thread t1 = new Thread(new a_exam(), "야옹이");
		Thread t2 = new Thread(new a_exam(), "멍멍이");
		t1.start();
		t2.start();
		
		try {
			t1.join();
		}
		
		catch(InterruptedException i) {
			System.out.println(i); // i.getstackTrace(); 와같음
		}
		
		/* Thread.start() -> JVM은 OS에 커넬 스레드 요청
		 * -> 0s 해당스레드를 스케줄링을 한다 . (시간할당, 우선순위 고려)
		 * -> JVM은 각 Thread객체에 Thread Stack을 할당
		 * -> 각 스레드는 독립적으로 Call Stack을 갖는다.
		 * 
		 * JConsole Overview
		 * Overview : CPU 사용량, Heap 메모리 , 클래스 수, 스레드 수
		 * Memory : GC ( 전체 Heap의 15% 이상 차지하면 application 메모리 조정)
		 * Threads : 스레드 목록, 상태 확인
		 * Classes : 클래스 로딩 수 , 메모리 점유량 확인
		 * Vm Summary : JVM 기본 설정값 ( 힙 크기, GC 설정, 명령줄 옵션)
		 * Mbeans : User가 등록한 프로세스를 관리하는 목적 -> 고급 모니터링 사용자 관리
		 */
		
	}

	

}
