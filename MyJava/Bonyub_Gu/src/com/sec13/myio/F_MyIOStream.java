package com.sec13.myio;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class F_MyIOStream {


	public static void main(String[] args) {
		String filename = "f.txt";
		try {

			MyWrite(filename);
			MyReader02(filename);
		}	catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void MyWrite(String filename) throws IOException {
		BufferedWriter bo = new BufferedWriter(new FileWriter(filename));
		for(char i = 'A'; i <= 'Z'; i++) {
			bo.append(i);
		}
		bo.close();
	}
	
	private static void MyReader02(String filename) throws IOException {
		BufferedReader bi = new BufferedReader(new FileReader(filename));
		String data = null;
		while ((data = bi.readLine()) != null) {
			System.out.println(data);
		}
		bi.close();
	}

}
