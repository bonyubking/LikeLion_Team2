package com.sec13.myNio;

import java.nio.ByteBuffer;

public class i_BufferedTest {

	public static void main(String[] args) {
		
		System.out.println("===ByteBuffer 확인");
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		
		byteBuffer.put((byte) 'A'); // position 1
		byteBuffer.put((byte) 'B'); // position 2
		
		byteBuffer.mark();
		
		byteBuffer.put((byte) 'C');
		byteBuffer.put((byte) 'D');
		
		System.out.println("데이터 저장 후 before reset :" + byteBuffer.position() + " " + byteBuffer.limit());
		
		byteBuffer.reset(); // mark 자리로돌아감
		byteBuffer.put((byte) 'c');

		
		
		byteBuffer.flip();
		
		System.out.println("데이터 저장 후 after reset :" + byteBuffer.position() + " " + byteBuffer.limit());
		
		
		while (byteBuffer.hasRemaining()) {
			System.out.println((char) byteBuffer.get());
		}

	}

}
