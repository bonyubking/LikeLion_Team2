package com.sec01.Singleton;


import java.io.IOException;
import java.util.logging.LogManager;

public class TestSingleton2 {
    public static void main(String[] args) {
    	
    	Runtime run = Runtime.getRuntime();
    	
    	try {
			run.exec("mspaint.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	}
}
