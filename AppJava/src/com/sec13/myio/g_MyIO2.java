package com.sec13.myio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;

//char 단위를 BufferedReader, BufferedWriter로 읽고 쓰자 
public class g_MyIO2 {
	public static void main(String[] args) {
		String filename = "g.txt"; 
//		File filename = new File("d.txt");
		
		try {
			MyWrite(filename);
			MyReader02(filename);
			
		}catch(Exception e) {
			
		}
	}
	
	public static void MyWrite(String filename) throws IOException{
		BufferedWriter bo = new BufferedWriter(new FileWriter(filename));
		for(char i = 'A';i<='Z';i++) {
			bo.append(i);
		}
		bo.close();
		System.out.println("파일이 A ~ Z 저장했어 !!");
	}
	
	public static void MyReader(String filename) throws IOException{
		BufferedReader bi = new BufferedReader(new FileReader(filename));
		int data;
		System.out.println("파일에서 읽은 데이터");
		while((data = bi.read())!=-1) { //0~65535코드 값으로 data에 대입하자 -1이 될때까지 
			System.out.print((char)data+"  ");
		}
		bi.close();	
	}
	
	public static void MyReader02(String filename) throws IOException{
		// 라인 단위로 읽겠다 = String 
		BufferedReader bi = new BufferedReader(new FileReader(filename));
		String data = null; //한줄씩 읽어서 대입한 객체 변수 null로 지역변수 초기화 
		System.out.println("파일에서 읽은 데이터");
		while((data = bi.readLine())!=null) { //0~65535코드 값으로 data에 대입하자 -1이 될때까지 
			System.out.print(data);
		}
		bi.close();	
	}
	
	

}
