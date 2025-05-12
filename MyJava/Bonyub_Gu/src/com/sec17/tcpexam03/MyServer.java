package com.sec17.tcpexam03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.*;
import java.time.LocalDateTime;

public class MyServer {
	
	private static final File logfile = new File("server_log.txt");
	private static final AtomicInteger clientCounter = new AtomicInteger(1);
	
	public static void main(String[] args) {
		
		
		System.out.println(" 서버 오픈 완료 ");
		
		try (			
				ServerSocket serverSocket = new ServerSocket(9999) ){
			while(true) {
		
			Socket client_socket = serverSocket.accept();
			
			int Clientid = clientCounter.incrementAndGet();
			String c_IP = client_socket.getInetAddress().getHostAddress();
			int c_PORT = client_socket.getPort();
			LocalDateTime c_time = LocalDateTime.now();
			
			System.out.printf("클라이언트 %d 접속 IP 는 %s PORT 는 %d TIME 은 %s \n",
					Clientid, c_IP, c_PORT, c_time);
			
			logFileClient(Clientid, c_IP, c_PORT, c_time);
			
			Thread.startVirtualThread(() -> handleClient(client_socket, Clientid));
			
			}
		
		} catch(IOException e) {
			e.printStackTrace();

		}
	}

	private static void logFileClient(int clientid, String c_IP, int c_PORT, LocalDateTime c_time) {
		
		try(BufferedWriter logwriter = 
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(logfile, true), 
								StandardCharsets.UTF_8))){
			
			String str = String.format("클라이언트 %d , IP 는 %s PORT 는 %d TIME 은 %s \n",
					clientid, c_IP, c_PORT, c_time);
			
			logwriter.write(str);
			
		}catch(IOException e) {
				e.printStackTrace();
			}
		
		
	}

	private static void handleClient(Socket client_socket, int Clientid) {

			try(client_socket;
					OutputStream os = client_socket.getOutputStream();
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))
					
					
					){
						writer.write("가상 스레드");
						writer.flush();
						System.out.printf("클라이언트 %d 응답 완료 - 연결  종료\n", Clientid);
			}
		  catch (Exception e) {

			  e.printStackTrace();
		}
	}

}
