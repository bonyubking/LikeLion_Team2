package com.sec13.myNio;
import java.nio.file.*;

public class a_Ni02 {
	
	public static void main(String[] args)throws Exception{
		//Q1. D: Test 폴더 생성하자.
		Path test= Paths.get("D:\\MyBootCamp\\test");
		Files.createDirectory(test);
		//Q2. test 밑에 AA 폴더 생성
		Path aadir = test.resolve("AA");
		Files.createDirectory(aadir);
		
		Path bbdir = test.resolve("BB");
		Files.createDirectory(bbdir);
		
		Path txtdir = bbdir.resolve("a.txt");
		Files.createFile(txtdir);
		System.out.println(" 다 만들었엉 ");
	}
}
