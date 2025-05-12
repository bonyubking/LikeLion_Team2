package com.sec17.intro;
//압축된 .gz → 다시 읽기 (복원) 
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class a_zipDecompression2 {
    public static void main(String[] args) {
        File gzipFile = new File("output02.zip");

        try (FileInputStream fis = new FileInputStream(gzipFile);
             ZipInputStream gzipIn = new ZipInputStream(fis)) {
        	
        		
        		ZipEntry entry = null;
        		
        	while(( entry = gzipIn.getNextEntry()) != null) {
        		
        		System.out.println("압축해제중 : " + entry.getName());
        	
        		
                InputStreamReader reader = new InputStreamReader(gzipIn, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(reader);


                String line;
                while ((line = br.readLine()) != null) {
                   System.out.println(line);
                   }
                
                gzipIn.closeEntry();
                
                   
        		
        	}
        		
        		
        }		

        

         catch (IOException e) {
            e.printStackTrace();
        }

    }
}

