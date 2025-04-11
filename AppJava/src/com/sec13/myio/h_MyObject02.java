package com.sec13.myio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		ObjectOutputStream bo = new ObjectOutputStream(new FileOutputStream(filename));
		bo.writeObject(new Student("111",1,1,1));
		bo.writeObject(new Student("222",2,2,2));
		bo.writeObject(new Student("333",3,3,3));
		bo.close();
		System.out.println("파일이 A ~ Z 저장했어 !!");
	}

	public static void MyReader(String filename) throws IOException, ClassNotFoundException{
		ObjectInputStream bi = new ObjectInputStream(new FileInputStream(filename));
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
