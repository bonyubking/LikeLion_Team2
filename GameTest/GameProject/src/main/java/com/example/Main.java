package com.example;

public class Main {
    public static void main(String[] args) {
        ChatServer server = new ChatServer(8080);
        server.start();
        System.out.println("서버 시작: ws://localhost:8080");
    }
}