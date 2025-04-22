package com.example;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/chat")
public class MyServer {
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    // 웹소켓 연결
    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("새 클라이언트 접속: " + session.getId());
    }

    //웹소켓 메세지 수신시 호출 
    @OnMessage
    public void onMessage(String message, Session sender) throws IOException {
        System.out.println("수신 메시지: " + message);
        for (Session session : sessions) {
            if (session.isOpen()) {
                try {
                    session.getBasicRemote().sendText("[클라이언트 " + sender.getId() + "] " + message);
                } catch (IOException e) {
                    System.err.println("메시지 전송 오류: " + e.getMessage());
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("클라이언트 퇴장: " + session.getId());
    }
}