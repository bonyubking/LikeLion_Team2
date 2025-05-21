package com.sec06.Memento;

// 캡처 객체 _ 스냅샷 // getter만 선언 
class Memento {
    private String state;
    public Memento(String state) { this.state = state; }
    public String getState() { return state; }
}
// Memento 보관하고 요청 시 Originator에 넘겨주는 caretaker class 존재 

// 저장, 복원 하는 클래스 
class Originator {
    private String state;
    public void setState(String state) { this.state = state; }
    public Memento save() { return new Memento(state); } // 저장
    public void restore(Memento m) { state = m.getState(); } // 이전 복원
    public void show() { System.out.println("State: " + state); } // 현재 상태 출력
}

// 실행 클래스
public class TestMemento {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("A"); // A 상태 저장 
        Memento m = originator.save(); // B 상태로 변경
        originator.setState("B"); // A로 복원 
        originator.restore(m); // 출력 A
        originator.show();
    }
}

// spring AOP -> 실행 메소드 이전, 이후 콜백 
