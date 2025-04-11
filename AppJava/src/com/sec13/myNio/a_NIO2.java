package com.sec13.myNio;
import java.nio.file.*;

//test 폴더를 만들고
// 폴더 하위에 AA, BB 폴더 생성 
// BB 아래에 a.txt 파일 생성
public class a_NIO2 {

	public static void main(String[] args)throws Exception{
		// test 폴더 생성
		Path test = Paths.get("/Users/heeyeon/dev/likelion/test");
		Files.createDirectory(test);
		
		// test \\AA 폴더 생성
		Path aadir = test.resolve("AA");
		Files.createDirectory(aadir);
		
		// test \\BB 폴더 생성
		Path bbdir = test.resolve("BB");
		Files.createDirectory(bbdir);
		
		// test \\BB\\a.txt 생성
		Path atxt = bbdir.resolve("a.txt");
		Files.createFile(atxt);
		
		//test\\BB\\a.txt 파일만 삭제
		Files.delete(atxt);
	}

}
