package com.sec12.mstream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FlatMapTest {
	
	public static void test_flatMap() {
		
		Path path = Paths.get("D:\\MyBootCamp\\Myjava\\Bonyub_Gu\\src\\com\\sec12\\mstream\\a.txt");
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			
			Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
			
			words.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(" no file " + e.getMessage());
		}
		
	}
	public static void main(String[] args) {

		Path path = Paths.get("D:\\MyBootCamp\\Myjava\\Bonyub_Gu\\src\\com\\sec12\\mstream\\a.txt");
		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
			
			Stream<Stream<String>> words = lines.map(line -> Stream.of(line.split(" +")));
			
			
			words.forEach(innerStream -> innerStream.forEach(System.out::println));
		} catch (IOException e) {
			System.out.println(" no file " + e.getMessage());
		}

	}

}