package com.sec13.myio;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class D_MyIOStream {


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
		FileOutputStream fo = new FileOutputStream(filename);
		for(byte i = 'A'; i <= 'Z'; i++) {
			fo.write(i);
		}
		fo.close();
	}
	
	private static void MyReader(File filename) throws IOException {
		FileInputStream fi = new FileInputStream(filename);
		int data;
		while ((data = fi.read()) != -1) {
			System.out.println(data);
		}
		fi.close();
	}

}
