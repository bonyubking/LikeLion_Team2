package com.sec13.myio;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class G_MyIOStream {


	public static void main(String[] args) {
		String filename = "f.txt";
		try {

			MyWrite(filename);
			MyReader(filename);
		}	catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void MyWrite(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		for(byte i = 'A'; i <= 'Z'; i++) {
			fw.write(i);
		}
		fw.close();
	}
	
	private static void MyReader(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		int data;
		while ((data = fr.read()) != -1) {
			System.out.println((char)data + " ");
		}
		fr.close();
	}

}
