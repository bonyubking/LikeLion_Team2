package com.sec17.tcpexam;

import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args){
        //1. ServerSocket(777) 을 생성해 특정 포트에서 클라이언트의 접속 대기
    	System.out.println("서버");
    	ServerSocket serverSocket = null;
    	Socket socket = null;
    	
    	try {
    		serverSocket = new ServerSocket(9999);
    		
    		//2. ServerSocket accpet()메소드를 이용해 클라이언트의 접속을 기다림
        	//3. 클라이언트의 접속 요청이 들어오면 accept() 메소드가 실행되어 클라이언트와의
    		//통신을 위한 Socket 객체 생성

    		socket = serverSocket.accept();
    		System.out.println("클라이언트 접속");
    		
    		OutputStream os = socket.getOutputStream();
    		os.write("서버가 클라이언트에게".getBytes());
    		os.close();
    		
    	}catch(Exception e) {
    		try{
    			//6. 통신에 사용된 IO스트림과 Socket 객체를 close 함 
    			serverSocket.close();
    		}catch(IOException e1) {
    			e1.printStackTrace();
    		}
    	}
    	
    	
    	//4. 생성된 Socket 객체로부터 통신을 위한 InputStream , OutputStream을 얻음
    	//5. InputStream, OutputStream을 이용하여 클라이언트와 통신
    	
    }
}