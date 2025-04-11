package com.sec13.myio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;

//char 단위로 읽고 쓰자 
public class f_MyIO {
	public static void main(String[] args) {
		String filename = "f.txt"; 
//		File filename = new File("d.txt");
		
		try {
			MyWrite(filename);
			MyReader(filename);
			
		}catch(Exception e) {
			
		}
	}
	
	public static void MyWrite(String filename) throws IOException{
		FileWriter fw = new FileWriter(filename);
		for(char i = 'A';i<='Z';i++) {
			fw.write(i);
		}
		fw.close();
		System.out.println("파일이 A ~ Z 저장했어 !!");
	}
	
	public static void MyReader(String filename) throws IOException{
		FileReader fr = new FileReader(filename);
		int data;
		System.out.println("파일에서 읽은 데이터");
		while((data = fr.read())!=-1) { //한 바이트씩 읽어서 data에 대입하자 -1일때까지 
			System.out.print((char)data+"  ");
		}
		fr.close();	
	}
	
	

}
