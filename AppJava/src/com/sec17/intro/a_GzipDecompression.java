package com.sec17.intro;
//압축된 .gz → 다시 읽기 (복원) 
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class a_GzipDecompression {
    public static void main(String[] args) {
    	//복원할 대상 gzip 파일 지정 
        File gzipFile = new File("output.txt.gz");
        
        
        /*
         * FileInputStream : gzip 파일을 바이트 단위로 읽음
         * GZIPInputStream : 읽은 바이트를 gzip 형식으로 압축 해제함
         * InputStreamReader : 압축이 풀린 데이터를 utf-8 로 문자 해석
         * BufferedReader : 문자열을 라인 단위로 읽음 
         * 
         * */
        try (FileInputStream fis = new FileInputStream(gzipFile);
             GZIPInputStream gzipIn = new GZIPInputStream(fis);
             InputStreamReader reader = new InputStreamReader(gzipIn, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(reader)) {

            System.out.println(" 압축 해제된 내용:");
            String line;
            // 줄 단위로 복원된 텍스트 출력 
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

