package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class h_NIOChar {

	//- 문자열 단위 : write(), Files.readAllLines() - List<String>
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("b.txt");
		
		//문자열 쓰기
		List<String> lines = List.of("public","static","void main");
		//write(Path,path, Iterable<? extends CharSequence> lines, OpenOption...options)
		Files.write(path, lines); //컬렉션하위 인터페이스 List<CharSequence의 구현체>, Set<CharSequence의 구현체>
		System.out.println("저장 완료!!");
		
		//문자열 읽기
		List<String> returnLines = Files.readAllLines(path);
		returnLines.forEach(System.out::println);

	}

}
