package com.sec01;

public class Test_type {
	//숫자 리터럴에 _(언더스코어) 사용하기 [컴파일 시 사라짐] -> JDK 1.7 이상

	public static void main(String[] args) {
		long creditCardNumber = 1234_5678_9012_3456L;
		long socialSecurityNumber = 999_99_9999L;
		float pi =  3.14_15F;
		long hexBytes = 0xFF_EC_DE_5E;
		long hexWords = 0xCAFE_BABE;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		byte nybbles = 0b0010_0101;
		long bytes = 0b11010010_01101001_10010100_10010010;
//언더 스코어는 숫자 앞, 뒤, 소수점 앞에 사용 불가!! | 진법 접두어뒤에 사용 불가
	}

}
