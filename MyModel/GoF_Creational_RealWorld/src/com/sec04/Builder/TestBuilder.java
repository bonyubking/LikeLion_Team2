package com.sec04.Builder;

// 복잡한 객체의 생성과정을 단계별로 분리함 -> 객체 생성을 여러개로 나눔
// 빌더 객체 생성 -> 빌더의 메소드 호출 -> 메소드 체이닝 -> build()라는 메소드로 최종 객체를 리턴받음
public class TestBuilder {
    public static void main(String[] args) {
        Report report = new ReportBuilder()
            .setHeader("=== Report ===")
            .setBody("Data goes here")
            .setFooter("End of Report")
            .build();
        report.print();

        System.out.println(new StringBuffer().append("abc").append("ddd").toString());    }
}
