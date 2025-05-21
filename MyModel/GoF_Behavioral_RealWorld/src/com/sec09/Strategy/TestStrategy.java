package com.sec09.Strategy;

// 전략 페턴 : 알고리즘을 캡슐화 _ 정렬 알고리즘, 압축 알고리즘, 결제 방식 (카드,계좌이체..) 등 
// redirect:https://myhost.com/some/arbitrary/path -> ViewResolver
interface Strategy {
    int operate(int a, int b);
}

class AddStrategy implements Strategy {
    public int operate(int a, int b) { return a + b; }
}
// web로 spring mvc로 가면 캡슐화가 돼서 .xml 파일로 설정된다. 
class Context {
    private Strategy strategy;
    public Context(Strategy strategy) { this.strategy = strategy; }
    public int execute(int a, int b) { return strategy.operate(a, b); }
}

public class TestStrategy {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println("Result: " + context.execute(3, 4));
    }
}
