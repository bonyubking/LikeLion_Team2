package com.sec17.intro;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class a_exam {
	public static void main(String[] args) {
		try {
			InetAddress[] res = Inet4Address.getAllByName("www.python.org");
			
			for(InetAddress address: res) {
				System.out.println(address.getHostAddress());
				System.out.println(address.getCanonicalHostName());
			}
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
