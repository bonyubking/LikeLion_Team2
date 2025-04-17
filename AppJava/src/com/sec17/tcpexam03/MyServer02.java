package com.sec17.tcpexam03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class MyServer02 {
	private static final AtomicInteger clientCounter = new AtomicInteger(0); // 고유 클라이언트 ID를 위한 카운트 체크
	
    public static void main(String[] args) {
        // 1.ServerSocket(9999)을 생성하여 특정 포트에서 클라이언트의 접속 대기 
        System.out.println(" 나 서버야  ");

        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            
        	while(true) {
	        	Socket clientSocket = serverSocket.accept(); 	
	        	
	        	int clientId = clientCounter.incrementAndGet();
	        	String clientIp = clientSocket.getInetAddress().getHostAddress();
	        	int clientPort = clientSocket.getPort();
	        	LocalDateTime clientTime = LocalDateTime.now();
	        	
	        	String clientString = String.format("[클라이언트 %d 접속] IP: %s PORT: %d TIME: %s\n", 
	        							clientId, clientIp, clientPort, clientTime);
	        	String dateString = clientTime.toLocalDate().format(DateTimeFormatter.ISO_DATE); 
	        	System.out.printf(clientString);
	        	
	        	logFileClient(clientString,dateString);
	        	
	        	// 클라이언트 별도 가상 스레드로 처리
	        	Thread.startVirtualThread(()-> handleClient(clientSocket, clientId));
        	}
	        	
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    private static void logFileClient(String clientString,String dateString) {
    	File logFile = new File("client_log_"+dateString+".txt");
		try(BufferedWriter logWriter = 
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(logFile, true), StandardCharsets.UTF_8))) {
			logWriter.write(clientString);
			logWriter.newLine();
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
    
    private static void handleClient(Socket clientSocket, int clientId) {
		// 클라이언트 -> 서버 메세지 전송 
		try(clientSocket;
				OutputStream os = clientSocket.getOutputStream();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))){
			writer.write("[서버 응답] 클라이언트 " + clientId + "님, 안녕하세요!\n");
			writer.flush();
			System.out.printf("[클라이언트 %d] 응답완료... 연결종료...\n", clientId);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
