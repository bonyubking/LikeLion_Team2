package com.sec02.FactoryMethod;

public class TestFactoryMethod {
    public static void main(String[] args) {
        Document doc = DocumentFactory.createDocument("pdf");
        doc.open();
    }
}
