package com.sec17.obj;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
	
	public static void main(String[] args) {
		try(
			Socket sc = new Socket("localhost",7777);
			ObjectOutputStream oos = new ObjectOutputStream(sc.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
			Scanner input = new Scanner(System.in);
		){
			//클라이언트 값 입력 
			System.out.print("첫번째 숫자 : ");
			double a = input.nextDouble();
			System.out.print("연산자 : ");
			String op = input.next();
			System.out.print("두번째 숫자 : ");
			double b = input.nextDouble();
			
			//객체에 값을 담고 서버로 전송 
			SendData sd = new SendData(a,b,op);
			oos.writeObject(sd);
			oos.flush();
			
			// 서버로부터 리턴받은 결과값 출력 
			SendData response = (SendData) ois.readObject();
			System.out.println("서버로부터 받은 연산 결과 : "+ response.getResult());
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

}
