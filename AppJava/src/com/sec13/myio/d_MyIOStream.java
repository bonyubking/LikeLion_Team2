package com.sec13.myio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

//byte 단위로 읽고 쓰자 
public class d_MyIOStream {
	public static void main(String[] args) {
		String filename = "/Users/heeyeon/dev/likelion/MyJava/AppJava/src/com/sec13/myio/d.txt"; 
//		File filename = new File("d.txt");
		
		try {
			//MyWrite(filename);
			
		}catch(Exception e) {
			
		}
	}
	
	public static void MyWrite(String filename) throws IOException{
		FileOutputStream fo = new FileOutputStream(filename);
		fo.write(100);
		fo.close();	
	}
	
	public static void MyRead(String filename) throws IOException{
		FileInputStream fi = new FileInputStream(filename);
		int data;
		System.out.println("파일에서 읽은 데이터");
		while((data = fi.read())!=-1) { //한 바이트씩 읽어서 data에 대입하자 -1일때까지 
			System.out.print(data+"  ");
		}
		System.out.println(fi.read());
		fi.close();	
	}
	
	

}
