package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest02 {

    public static void main(String[] args) {
    	System.out.println("Q1️. {3, 7, 2, 9, 5, 8}에서 reduce()를 사용하여 최댓값을 구해보자");  
        List<Integer> numbers1 = Arrays.asList(3, 7, 2, 9, 5, 8);
        Optional <Integer> max = numbers1.stream().reduce(Integer::max);
        max.ifPresent(m->System.out.println("최대값 : "+m));
        
        System.out.println("Q2. {\"Java\", \"Stream\", \"Reduce\", \"Example\"}에서 reduce()를 사용하여 문자열을 하나로 연결하자");
        List<String> words = Arrays.asList("Java", "Stream", "Reduce", "Example");        
        Optional<String> res = words.stream().reduce((a,b) -> a+" "+b);
        res.ifPresent(m-> System.out.println(m));
        
        System.out.println("Q3. {2, 3, 4, 5}에서 reduce()를 사용하여 모든 값을 곱한 결과를 구하자");
        //숫자 목록의 곱셈 결과 계산
        //reduce(identity, 두 값을 결합하는 함수)
        List<Integer> numbers3 = Arrays.asList(2, 3, 4, 5);
        int res02 = numbers3.stream().reduce(1,(a,b)->a*b);
        System.out.println(res02);
        
        System.out.println("Q4. {1, 2, 3, 4, 5}에서 reduce()를 사용하여 모든 숫자의 제곱 합을 구하자");
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
        //첫번째 요소 4 + 초기값 0
        //두번째 요소 9 + 이전 계산결과 
        //세번째 요소 16 + 이전 계산 결과 -> 29
        int res03 = numbers4.stream().map(e -> e*e).reduce(0,Integer::sum);
        
        System.out.println("Q5. {\"hello\", \"world\", \"java\", \"stream\"}에서 reduce()를 사용하여 모든 단어의 길이의 합을 구하자");
        List<String> words5 = Arrays.asList("hello", "world", "java", "stream");
        int res04 = words5.stream().map(String::length).reduce(0,Integer::sum);
        System.out.println("문자열 길이 합 :"+res04);
        
        System.out.println("Q6. {\"apple\", \"banana\", \"cherry\", \"date\"}에서 reduce()를 사용하여 가장 긴 문자열을 찾자");
        List<String> words6 = Arrays.asList("apple", "banana", "cherry", "date");
        Optional<String> res05 = words6.stream().reduce((a, b) -> a.length() >= b.length() ? a:b);
        res05.ifPresent(e -> System.out.println(e));
    }
}
