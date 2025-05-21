package com.sec02.FactoryMethod;

// 팩토리 패턴 : java.lang.NumberFormatm java.text.DataFormat, java.util.Locale
// java.nio.Paths -> get()  java.net.URI.create() / java.sql.DriverManager.getConnect()
public class TestFactoryMethod {
    public static void main(String[] args) {
        Document doc = DocumentFactory.createDocument("pdf");
        doc.open();
    }
}
