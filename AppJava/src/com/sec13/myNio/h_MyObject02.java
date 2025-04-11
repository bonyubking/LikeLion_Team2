package com.sec13.myNio;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.sec13.myio.Student;

public class h_MyObject02 {
	public static void main(String[] args) {
		String filename = "h.txt"; 
//		File filename = new File("d.txt");
		
		try {
			MyWrite(filename);
			MyReader(filename);
			
		}catch(Exception e) {
			
		}
	}
	
	public static void MyWrite(String filename) throws IOException{
		Path path = Paths.get(filename, null);
		
		ObjectOutputStream bo = new ObjectOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE));
		bo.writeObject(new Student("111",1,1,10));
		bo.writeObject(new Student("222",2,2,20));
		bo.writeObject(new Student("333",3,3,30));
		bo.close();
		System.out.println("파일이 A ~ Z 저장했어 !!");
	}

	public static void MyReader(String filename) throws IOException, ClassNotFoundException{
		Path path = Paths.get(filename, null);
		
		ObjectInputStream bi = new ObjectInputStream(Files.newInputStream(path));
		Student s1 = (Student)bi.readObject();
		Student s2 = (Student)bi.readObject();
		Student s3 = (Student)bi.readObject();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println("파일에서 읽은 데이터");
		bi.close();	
	}
}
