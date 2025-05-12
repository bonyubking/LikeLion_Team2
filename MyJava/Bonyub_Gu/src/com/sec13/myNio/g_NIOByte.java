package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class g_NIOByte {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("a.txt");
		
		try (var out = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE) ){
			for (byte i = 'A'; i<= 'Z'; i++) {
				out.write(i);
			}
		}
		
		try (var in =Files.newInputStream(path) ){
			int data = 0;
			while ( ( data = in.read() ) != -1) {
				System.out.print((char)data);
			}
		}
	}

}
