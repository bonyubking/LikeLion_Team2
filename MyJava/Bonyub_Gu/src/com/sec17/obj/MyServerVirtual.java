package com.sec17.obj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServerVirtual {
    public static void main(String[] args) {
    	try (ServerSocket server = new ServerSocket(7777);
    			ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor())
    	{
    		System.out.println("서버 대기중~~~");
    		
    		
    		while (true) {
    		Socket client = server.accept();
    		System.out.println("클라이언트 접속완료");
    		executor.submit(()-> handleClient(client));
    		}
    		
    		
    	}catch(Exception e) {
    			System.out.println(e.toString());
    		}
    	
    	}
    	
    

    private static void handleClient(Socket client) {
    	
    	
    	try(client; ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
    	ObjectInputStream ois = new ObjectInputStream(client.getInputStream())){
    		
    	SendData response = (SendData)ois.readObject();
    	double res = MyCalculate(response.getNum1(), response.getNum2(), response.getOperator());
    	
    	response.setResult(res);
    	
    	oos.writeObject(response);
    	oos.flush();
    	} catch(IOException e) {
    		e.printStackTrace();
    		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
