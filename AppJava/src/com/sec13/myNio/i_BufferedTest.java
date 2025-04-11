package com.sec13.myNio;

import java.nio.ByteBuffer;

public class i_BufferedTest {

	public static void main(String[] args) {
		
		System.out.println("===ByteBuffer 확인 ===");
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		
		byteBuffer.put((byte) 'A'); //position 1
		byteBuffer.put((byte) 'B'); //position 2
		
		byteBuffer.mark(); //mark 저장 position 2
		byteBuffer.put((byte) 'C'); //position 3
		byteBuffer.put((byte) 'D'); //position 3
		
		System.out.println("데이터 저장 후 : before reset "+byteBuffer.position() + " "+byteBuffer.limit());
		
		byteBuffer.reset(); //mark 위치로 돌아감-> position 2
		byteBuffer.put((byte) 'E'); //덮어쓰기 C 덮어쓰기.E로 변경됨 
		System.out.println("읽기");
		byteBuffer.flip();
		System.out.println("flip 이후 : after reset "+byteBuffer.position()+ " "+byteBuffer.limit());
		
		while(byteBuffer.hasRemaining()) {
			System.out.println(byteBuffer.get()); 
		}

	}

}
