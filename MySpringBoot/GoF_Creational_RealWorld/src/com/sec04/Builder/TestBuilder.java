package com.sec04.Builder;

public class TestBuilder {
    public static void main(String[] args) {
        Report report = new ReportBuilder()
            .setHeader("=== Report ===")
            .setBody("Data goes here")
            .setFooter("End of Report")
            .build();
        report.print();
        
        System.out.println(new StringBuffer().append("abc").append("ddd").toString());
        
    }
}
