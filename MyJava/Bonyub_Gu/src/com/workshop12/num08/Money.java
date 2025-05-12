package com.workshop12.num08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Money {

    public static void main(String[] args) {
        // 데이터 정의
        List<String> data = List.of(
            "홍길동,5000000", 
            "이순신,6500000", 
            "유관순,4800000", 
            "강감찬,7000000", 
            "신사임당,5500000"
        );


        Map<String, Integer> resultMap = data.stream()
            .map(entry -> entry.split(","))
            .filter(entry -> Integer.parseInt(entry[1]) >= 5000000)  // 급여가 500만 이상인 경우만 필터링
            .collect(Collectors.toMap(entry -> entry[0], entry -> Integer.parseInt(entry[1])));

        // 이름 순으로 정렬 후 출력
        resultMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))  // 이름 기준으로 정렬
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + "원"));
        
        Path filePath = Paths.get("employee_salary.txt");
        List<String> lines = resultMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey(Comparator.reverseOrder()))  // 이름 역순 정렬
                .map(entry -> entry.getKey() + ": " + entry.getValue() + "원")  // "이름: 급여" 형식으로 변환
                .collect(Collectors.toList()); 
        
        try {
			Files.write(filePath, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        System.out.println("=== 파일 내용 ===");
        try {
			Files.lines(filePath).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
