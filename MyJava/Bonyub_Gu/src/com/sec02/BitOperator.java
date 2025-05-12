package com.sec02;
	public class BitOperator {
		
		public static void prn(){
			int a=51;
			int b=240;
			
			 System.out.println("AND ="+( a&b));
			 System.out.println("OR=" +(a|b));
			 System.out.println("XOR="+(a^b));
		}
		
		public static void main(String[] args) {
			
			
			int a=51;
			int b=240;
			
			System.out.println(" a의 51을 2진 문자열로 = " + Integer.toBinaryString(a));
			
			System.out.println("b를 2진 문자열로 = " + Integer.toBinaryString(b));
			
			String str = String.format("%16s", Integer.toBinaryString(a)).replace(' ', '0');;
			System.out.printf("16자리 수" + str);
			
			String str03 = BinaryStringPadding(a);
			System.out.println(str03);
			
			String str04 = BinaryStringPadding_float(a);
			System.out.println(str04);
			
			double doubleValue = 3.14159263559;
			long bits = Double.doubleToLongBits(doubleValue);
			String binaryString = Long.toBinaryString(bits);
			System.out.println(doubleValue + "\n" + bits + "\n" + binaryString);
			
			double non_value = Double.NaN;
			long res03 = Double.doubleToLongBits(non_value);
			long res04 = Double.doubleToRawLongBits(non_value);
			System.out.println(non_value + "\n" + res03 + "\n" +res04);
			System.out.println(Long.toBinaryString(res03)+ "\n" + res04);
		}
		// 메소드화
		public static String BinaryStringPadding(int res) {
			
			String result = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
			return result;
		}
		
		public static String BinaryStringPadding_float(float res) {
			
			String result = String.format("%32s", Float.toHexString(res)).replace(' ', '0');
			return result;
		}
		
	
	}




	
	
