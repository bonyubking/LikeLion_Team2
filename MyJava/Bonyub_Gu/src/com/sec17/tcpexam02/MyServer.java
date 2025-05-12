package com.sec17.tcpexam02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		
		//  	TCP 에코 서버 작성순서
			
		//	1.ServerSocket(9999)을 생성하여 특정 포트에서 클라이언트의 접속을 대기한다. 
		System.out.println(" 나 서버야 ");
		

		
		
		try (			
				ServerSocket serverSocket = new ServerSocket(9999) ){
			while(true) {
		
			Socket client_socket = serverSocket.accept();
			System.out.println("클라이언트 접속");
			
			Thread.startVirtualThread(() -> handleClient(client_socket));

		
			
			
			//	2.ServerSocket의 accept() 메서드를 이용하여 클라이언트의 접속을 기다린다.     
			//	3.클라이언트의 접속 요청이 들어오면 accept() 메서드가 실행되어 클라이언트와의 통신을 위한 
			//	Socket 객체를 생성한다. 
			


		}
		
		} catch(IOException e) {
			e.printStackTrace();
			//	 6.통신에 사용된 IO스트림과 Socket 객체를 close()한다.
		}
		
 
		//	4.생성된 Socket 객체로부터 통신을 위한 InputStream, OutputStream을 얻는다.
		//	 5.InputStream, OutputStream을 이용하여 클라이언트와 통신한다.

		 
	}

	private static void handleClient(Socket client_socket) {

			try(client_socket;
					OutputStream os = client_socket.getOutputStream();
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))
					
					
					){
						writer.write("가상 스레드");
						writer.flush();
			}
		  catch (Exception e) {

			  e.printStackTrace();
		}
	}

}
