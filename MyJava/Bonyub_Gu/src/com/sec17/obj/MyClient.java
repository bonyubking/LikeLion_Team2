package com.sec17.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Socket sc = new Socket("localhost",7777);
		ObjectOutputStream oos = new ObjectOutputStream(sc.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
		
		
		Scanner sc_input = new Scanner(System.in);
		System.out.print("첫번쨰 숫자");
		double a = sc_input.nextDouble();
		System.out.print("연산자 :");
		String op = sc_input.next();
		System.out.print("두번쨰 숫자 :");
		double b = sc_input.nextDouble();
		
		
		SendData sd = new SendData(a,b,op);
		oos.writeObject(sd);
		oos.flush();
		
		SendData response = (SendData)ois.readObject();
		System.out.println("서버로 부터 받은 연산 결과 : " + response.getResult());
		

	}

}
