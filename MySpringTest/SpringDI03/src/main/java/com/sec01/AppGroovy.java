package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;




public class AppGroovy {
    public static void main(String[] args) {

        GenericGroovyApplicationContext context =
            new GenericGroovyApplicationContext("classpath:app01.groovy");

        // myaddress
        MyAddress res = context.getBean("myaddress", MyAddress.class);
        System.out.println(res);

        // myaddress02
        res = context.getBean("myaddress02", MyAddress.class);
        System.out.println(res);

        // myaddress03 (기존 myaddress04 → myaddress03)
        res = context.getBean("myaddress03", MyAddress.class);
        System.out.println(res);

        // info
        AddressInfo info = context.getBean("info", AddressInfo.class);
        info.prn();
    }
}
