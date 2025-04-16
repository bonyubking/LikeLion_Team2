package com.sec17.intro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.*;

//문자열 → ZIP 압축 → 파일 저장 
public class a_zipCompression2{
    public static void main(String[] args) {
        String data = """
                Hello, this is compressed content.
                Java GZIP is easy to use!
                Virtual Thread도 문제 없이 동작합니다 
                """;

        File gzipFile = new File("output.txt.zip");

        try (FileOutputStream fos = new FileOutputStream(gzipFile);
             ZipOutputStream gzipOut = new ZipOutputStream(fos);){
        		
            OutputStreamWriter writer = new OutputStreamWriter(gzipOut, StandardCharsets.UTF_8);
            
            //압축 항목 정의
            ZipEntry ze = new ZipEntry("a.txt");
            gzipOut.putNextEntry(ze);
            writer.write(data);
            System.out.println(" 압축 완료: " + gzipFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
