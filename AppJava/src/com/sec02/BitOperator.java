package com.sec02;
	public class BitOperator {
		
		public static void prn() {
			int a=51;
			int b=240;
			
			 System.out.println("AND ="+( a&b));
			 System.out.println("OR=" +(a|b));
			 System.out.println("XOR="+(a^b));
		}
		
		public static void main(String[] args) {
			int a = 51;
			int b = 240;
			
			System.out.println(Integer.toBinaryString(a));
			System.out.println(Integer.toBinaryString(b));
			
			//Integer.toBinaryString(a)의 문자열로 리턴받은 이전 문자열의 16자리로
			//만들고 빈공간을 0으로 채움
			String str = BinaryStringPadding(a);
			System.out.printf("%16s",str);
			
			String str2 = BinaryStringPadding(b);
			System.out.printf("%16s",str2);
			
			int res_a = 2;
			System.out.println(BinaryStringPadding(res_a));
			
			float res_f = 7.2f;
			System.out.println(BinaryStringPadding_float(res_f));
			
			double doubleValue = 3.14159265359; //8byte
			long bits = Double.doubleToLongBits(doubleValue); 
			String binaryString = Long.toBinaryString(bits);
			System.out.println(doubleValue+"\n"+bits+"\n"+binaryString);
			
			System.out.println("============NaN============");
			double non_value = Double.NaN;
			long res03 = Double.doubleToLongBits(non_value);
			long res04 = Double.doubleToRawLongBits(non_value);
			System.out.println(non_value+"\n"+res03+"\n"+res04);
			System.out.println(Long.toBinaryString(res03)+"\n"+Long.toBinaryString(res04));
		}
		
		public static String BinaryStringPadding(int res) {
			String str = String.format("%32s\n", Integer.toBinaryString(res)).replace(' ', '0');
			return str;

		}
		public static String BinaryStringPadding_float(float res) {
			String str = String.format("%32s\n", Float.toHexString(res)).replace(' ', '0');
			return str;

		}
	}

	
	
