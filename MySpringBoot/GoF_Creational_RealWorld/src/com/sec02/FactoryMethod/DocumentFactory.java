package com.sec02.FactoryMethod;

public class DocumentFactory {
    public static Document createDocument(String type) {
        return switch (type) {
            case "pdf" -> new PdfDocument();
            case "word" -> new WordDocument();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
