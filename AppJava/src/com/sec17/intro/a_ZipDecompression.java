package com.sec17.intro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class a_ZipDecompression {
	public static void main(String[] args) {
		File gzipFile = new File("output.txt.zip");
		
		try(FileInputStream fis = new FileInputStream(gzipFile);
			ZipInputStream gzipIn = new ZipInputStream(fis)){
			
			ZipEntry entry = null;
			
			while((entry = gzipIn.getNextEntry() )!= null) {
				System.out.println("압축 해제 중: "+ entry.getName());
				
				BufferedReader br = new BufferedReader(new InputStreamReader(gzipIn, StandardCharsets.UTF_8));
				
				String line = null;
				
				while((line = br.readLine()) != null) {
					System.out.println(line);
				}
				
				gzipIn.closeEntry();
				
			}	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
