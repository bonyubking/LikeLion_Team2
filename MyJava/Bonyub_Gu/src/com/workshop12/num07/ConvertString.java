package com.workshop12.num07;

public class ConvertString {
	
    public static String convert(int money) {

        String moneyStr = Integer.toString(money);
        

        StringBuilder formattedMoney = new StringBuilder(moneyStr);
        

        int length = formattedMoney.length();
        for (int i = length - 3; i > 0; i -= 3) {
            formattedMoney.insert(i, ","); 
        }


        return formattedMoney.toString() + "원";
    }

}
