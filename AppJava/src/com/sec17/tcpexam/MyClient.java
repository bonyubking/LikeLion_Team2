package com.sec17.tcpexam;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws IOException {
    	// 1. 서버와 통신을 위한 Socket 객체 생성. 이때 접속 요청할 서버의 IP 주소와 Port 번호를
    	// 매개변수로 지정
    	Socket socket = null;
    	try {
    		socket = new Socket("localhost",9999);
    		System.out.println("클라이언트");
    		
    		InputStream ios = socket.getInputStream();
    		int r = 0;
    		while((r=ios.read()) != -1) {
    			System.out.print(r);
    		}
    		
    		
    	}catch(UnknownHostException e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			socket.close();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	// 2.Socket 객체로부터 서버와의 통신을 위한 InputStream, OutputStream 
    }
}