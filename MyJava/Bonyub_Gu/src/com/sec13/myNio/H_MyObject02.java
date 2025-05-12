package com.sec13.myNio;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.sec13.myio.Student;

import java.io.File;

public class H_MyObject02 {


	public static void main(String[] args) {
		String filename = "f.txt";
		try {

			MyWrite(filename);
			Student.age = 100;
			
			MyReader(filename);
		}	catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void MyWrite(String filename) throws IOException {
		Path path = Paths.get(filename);
		ObjectOutputStream bo = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE));
		bo.writeObject(new Student("111",1,1,1));
		bo.writeObject(new Student("222",2,2,2));
		bo.writeObject(new Student("333",3,3,3));
		bo.close();
	}
	
	private static void MyReader(String filename) throws IOException, ClassNotFoundException {
		Path path = Paths.get(filename);
		ObjectInputStream bi = new ObjectInputStream(Files.newInputStream(path));
		Student s1 = (Student)bi.readObject();
		Student s2 = (Student)bi.readObject();
		Student s3 = (Student)bi.readObject();
		
		System.out.println(s1.studentInfo());
		System.out.println(s2.studentInfo());
		System.out.println(s3.studentInfo());
		
		System.out.println("Static : " + Student.age);
		System.out.println("S1 : " + s1.getWeight());
		
		
		bi.close();
	}

}
