package com.sec09.Strategy;

// 전략 패턴 : 알고리즘을 캡슐화 _정렬알고리즘, 압축알고리즘, 결제방식 등등
interface Strategy {
    int operate(int a, int b);
}

class AddStrategy implements Strategy {
    public int operate(int a, int b) {
        return a + b;
    }
}

// Web의 Spring mvc로 가면 캡슐화되어 .xml 파일로 설정됨
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int a, int b) {
        return strategy.operate(a, b);
    }
}

public class TestStrategy {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println("Result: " + context.execute(3, 4));
    }
}
