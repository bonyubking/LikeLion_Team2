package com.sec13.myio;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;

public class E_MyIOStream {


	public static void main(String[] args) {
		File filename = new File("d.txt");
		System.out.println(filename.getPath());
		try {
			MyReader(filename);
			MyWrite(filename);
		}	catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void MyWrite(File filename) throws IOException {
		BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(filename));
		for(byte i = 'A'; i <= 'Z'; i++) {
			bo.write(i);
		}
		bo.close();
	}
	
	private static void MyReader(File filename) throws IOException {
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(filename));
		int data;
		while ((data = bi.read()) != -1) {
			System.out.println(data);
		}
		bi.close();
	}

}
