package com.sec17.intro;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;
import java.util.zip.GZIPInputStream;

public class a_intro {
	public static void main(String[] args) throws InterruptedException {

		String urlString = "https://www.python.org";

		// 가상스레드를 사용하는 ExecutorService 생성
		// 작업당 하나의 가상스레드를 생성해 동시성을 효율적으로 관리함 
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor(); 

		executor.submit(() -> { //가상스레드를 생성해 비동기적으로 웹페이지 내용을 가져오는 작업 실행 
			try {
				URL url = URI.create(urlString).toURL();// 문자열 URL을 URI로 변환한 후 다시 URL 객체로 변환함 

				// GZIP 압축 해제 후 UTF-8로 읽기
				/*
				 * 웹페이지 내용을 InputStream으로 가져온 뒤 GZIP 형식이라 가정하고 압축 해제함
				 *  - www.python.org의 응답이 실제로 GZIP으로 압축되어있어야 GZIPInputStream이 정상작동함 
				 * */
				try (InputStream rawStream = url.openStream();
						InputStream decodedStream = new GZIPInputStream(rawStream);
						// 압축해제된 바이트 스트림을 UTF-8로 읽을 수 있게 문자 스트림으로 변환함 
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(decodedStream, StandardCharsets.UTF_8))) {

					System.out.println("\n [웹 페이지 내용 시작]");
					String line;
					// 웹페이지 내용 한줄씩 출력 
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}
					System.out.println(" [웹 페이지 내용 끝]");
				}
			} catch (Exception e) {
				System.err.println("오류 발생: " + e.getMessage());
			}
		});
		
		// Executor 종료. 최대 10초동안 모든 작업이 완료되길 기다림 
		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);
	}
}
