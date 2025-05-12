package com.sec17.tcpexam;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class MyServerNio {
    public static void main(String[] args) throws IOException {
        System.out.println("🌐 NIO 서버 시작");

        Selector selector = Selector.open();
        
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(9999));
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select(); // 블로킹처럼 보이지만 내부는 이벤트 기반
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();

                if (key.isAcceptable()) {
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_WRITE);
                    System.out.println("클라이언트 연결됨 (NIO)");
                }

                if (key.isWritable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.wrap("서버가 클라이언트에게".getBytes("UTF-8"));
                    client.write(buffer);
                    client.close();
                }
            }
        }
    }
}
