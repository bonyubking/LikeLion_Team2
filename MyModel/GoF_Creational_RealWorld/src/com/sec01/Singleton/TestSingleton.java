package com.sec01.Singleton;

import java.util.logging.LogManager;
import java.io.IOException;
import java.util.logging.*;
import java.util.logging.Logger;

public class TestSingleton {
    public static void main(String[] args) {
        // new 연산자를 사용하지 않고 객체가 정적으로 생성한 메소드 호출
//        Logger logger1 = Logger.getInstance();
//        Logger logger2 = Logger.getInstance();
//        logger1.log("System started");
        // System.out.println("Same instance: " + (logger1 == logger2));

        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("mspaint.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogManager res = LogManager.getLogManager();
        Logger res_Logger = res.getLogger("com.sec01.Singleton.Logger");
        System.out.println(res_Logger);

    }
}
