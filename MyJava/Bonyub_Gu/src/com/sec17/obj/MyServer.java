package com.sec17.obj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	
	public static void main(String[] args) {
	
	try (ServerSocket server = new ServerSocket(7777)){
	System.out.println("서버 대기중~~~");
	
	
	while (true) {
	Socket client = server.accept();
	
	
	try(
	ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
	ObjectInputStream ois = new ObjectInputStream(client.getInputStream())){
		
	SendData response = (SendData)ois.readObject();
	double res = MyCalculate(response.getNum1(), response.getNum2(), response.getOperator());
	
	response.setResult(res);
	
	oos.writeObject(response);
	oos.flush();
	} catch(IOException e) {
		e.printStackTrace();
		}
	}
	}
	catch(Exception e) {
		System.out.println(e.toString());
	}
	
}
	
	private static double MyCalculate(double a, double b, String op) {
		
		return switch(op) { 
		case "+" -> a+b;
		case "-" -> a-b;
		case "*" -> a*b;
		case "/" -> b != 0 ?  a / b : Double.NaN;
		default -> 0;
		};
	}
	
}
