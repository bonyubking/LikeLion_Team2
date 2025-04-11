package com.sec13.myio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

//buffer 단위로 읽고 쓰자 
public class e_MyIOStream {
	public static void main(String[] args) {
		String filename = "ad.txt"; 
//		File filename = new File("d.txt");
		
		try {
			MyWrite(filename);
			MyReader(filename);
			
		}catch(Exception e) {
			
		}
	}
	
	public static void MyWrite(String filename) throws IOException{
		BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(filename));
		for(byte i = 'A';i<='Z';i++) {
			bo.write(i);
		}
		bo.close();
		System.out.println("파일이 A ~ Z 저장했어 !!");
	}
	
	public static void MyReader(String filename) throws IOException{
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(filename));
		int data;
		System.out.println("파일에서 읽은 데이터");
		while((data = bi.read())!=-1) { //한 바이트씩 읽어서 data에 대입하자 -1일때까지 
			System.out.print(data+"  ");
		}
		System.out.println(bi.read());
		bi.close();	
	}
	
	

}
