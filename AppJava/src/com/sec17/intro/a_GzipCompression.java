package com.sec17.intro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;

//문자열 → GZIP 압축 → 파일 저장 
public class a_GzipCompression{
    public static void main(String[] args) {
        String data = """
                Hello, this is compressed content.
                Java GZIP is easy to use!
                Virtual Thread도 문제 없이 동작합니다 
                """;
        
        // 압축 결과가 저장될 파일 객체 생성 
        File gzipFile = new File("output.txt.gz");

        /*
         * FileOutputStream : 파일에 바이트 출력
         * GZIPOutputStream : 출력되는 데이터 gzip 압축
         * OutputStreamWriter : 문자열 데이터를 utf-8 인코딩 후 바이트 변환 
         * */
        try (FileOutputStream fos = new FileOutputStream(gzipFile);
             GZIPOutputStream gzipOut = new GZIPOutputStream(fos);
             OutputStreamWriter writer = new OutputStreamWriter(gzipOut, StandardCharsets.UTF_8)) {

            writer.write(data);
            System.out.println(" 압축 완료: " + gzipFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
