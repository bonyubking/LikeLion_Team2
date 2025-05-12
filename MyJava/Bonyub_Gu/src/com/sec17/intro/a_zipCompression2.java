package com.sec17.intro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//문자열 → GZIP 압축 → 파일 저장 
public class a_zipCompression2{
    public static void main(String[] args) {
        String data = """
                Hello, this is compressed content.
                Java GZIP is easy to use!
                Virtual Thread도 문제 없이 동작합니다 
                """;

        File GzipFile = new File("output02.zip");

        try (FileOutputStream fos = new FileOutputStream(GzipFile);
             ZipOutputStream gzipOut = new ZipOutputStream(fos);
        		
             OutputStreamWriter writer = new OutputStreamWriter(gzipOut, StandardCharsets.UTF_8)) {
        	
        	ZipEntry ze = new ZipEntry("a.txt");
        	gzipOut.putNextEntry(ze);

            writer.write(data);
            writer.flush();

            System.out.println(" 압축 완료: " + GzipFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
