package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceTest {

    public static void main(String[] args) {
        // 1️. Optional<T> reduce(BinaryOperator<T> accumulator)
        // 리스트의 모든 값을 합산하여 Optional<Integer>로 반환
    	// Integer::sum은 public static int sum(int a,int b)이고 
    	//이 reduce()에서 두 개의값을 결합하는 함수를 제공할때 그 함수 타입이 BinaryOperator<T>임 
    	// reduce()에서 두 개의 값이 결합할 때 어떻게 결합할지 결정하는 함수형 인터페이스 -> BinaryOperator<T> 
    	// BinaryOperator<T>에서 apply 메소드가 두 개의 동일한 타입의 값을 받아 하나의 값으로 결합함 
    	// Integer::sum이 BinaryOperator<T> 타입이여서 계산한 값을 Optional 타입으로 반환받음 
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);

        // Optional 값이 존재하면 출력, 없으면 "noValue" 출력
        System.out.println(sum.orElseGet(() -> {
            System.out.println("noValue");
            return 0;
        }));

        // 2. T reduce(T identity, BinaryOperator<T> accumulator)
        // 초기값(identity) 0을 지정하여 리스트의 모든 값을 합산
        int sum01 = numbers.stream().reduce(0, Integer::sum); 
        System.out.println("Sum with identity: " + sum01);
        

        // 3. <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        // 병렬 스트림을 사용하여 초기값 0.0을 지정한 후, BiFunction과 BinaryOperator를 통해 병렬 연산 수행
        //현재 numbers는 Collection 인터페이스를 상속받은 List객체. 
        //Collection 인터페이스에 parallelStream 메소드가 정의되어 있음. 그래서 List 객체에서 parallelStream을 쓸수있는것
        //defaultdefault Stream<E> parallelStream()
        double sum03 = numbers.parallelStream().reduce(
                0.0, // 초기값(identity)
                (partialSum, a) -> partialSum + a, // BiFunction<U, ? super T, U>
                Double::sum // BinaryOperator<U>
        ); 
        System.out.println("Parallel Sum: " + sum03);
    }
}
